package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.RangeFinder;

public class DiagonalStartingPositionMunchkin extends SequentialCommandGroup {
    /**
     * rangeFinder1 rangeFinder2 the range finders on the robot, left and right respectively. 
     */
    private RangeFinder rangeFinder1, rangeFinder2;

    /**
     * sets the RangeFinder fields
     * @param rf1 left RangeFinder object
     * @param rf2 right RangeFinder object
     */
    public DiagonalStartingPositionMunchkin(RangeFinder rf1, RangeFinder rf2) { //first rangefinder is the left one, second is right one
        rangeFinder1 = rf1;
        rangeFinder2 = rf2;
    }
    /**
     * calculates which range finder gets a shorter distance, and outputs 1, 0, or -1 accordingly.
     * @return 1 when range finder 1 (the left one) has a shorter value, -1 when range finder 2 (the right one) has a shorter value, and 0 when the values are equal.
     */
    public int getShorter() {
        int shorter = 0;
        if (rangeFinder1.getDistance() > rangeFinder2.getDistance()) {
            shorter = 1;
        } else if (rangeFinder1.getDistance() < rangeFinder2.getDistance()) {
            shorter = -1;
        }
        return shorter;
    }
    /**
     * calculates the robot's current angle (non-obtuse) given the rangefinder values
     * @return angle of the robot
     */
    public double calcAngle() {
        double rfDist1 = rangeFinder1.getDistance();
        double rfDist2 = rangeFinder2.getDistance();
        return Math.atan(Constants.DISTANCE_BETWEEN_RANGE_FINDERS / Math.abs(rfDist1 - rfDist2)); //angle has the same sign as distanceBetweenRangeFinders
    }
    /**
     * creates TurnToAngle command given the current angle and shorter rangefinder value.
     */
    public void turn() {
        addCommands(new TurnToAngle(getShorter() * calcAngle() / 2));
    }
}
