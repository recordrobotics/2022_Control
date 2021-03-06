/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.Constants;
import frc.robot.subsystems.Gyroscope;


public class MoveToFire extends SequentialCommandGroup {
    /**
     * Constants.CAMERA_OFF_CENTER How far away the camera is from the center of the robot.
     * targetAngle The angle the robot needs to face in order to shoot at the goal.
     * gyroAngle The angle returned by the gyro.
     */
    double targetAngle;
    double gyroAngle;
    private Gyroscope m_gyro = RobotContainer.getInstance().getGyro();
    /**
     * MoveToFire() Moves the robot into position to fire.
     * @param firingDistance How far the robot needs to be from the goal in order to score.
     */
    public MoveToFire(double firingDistance){
        gyroAngle = m_gyro.getDeg();
        if (Constants.CAMERA_OFF_CENTER != 0){
            targetAngle = (90 - Math.toDegrees(Math.atan(firingDistance / Constants.CAMERA_OFF_CENTER)));
            targetAngle = (int)(targetAngle + 0.5);

            if (targetAngle > 0){
                targetAngle = -targetAngle;
            }
            System.out.println(targetAngle);
        }
        else {
            targetAngle = 0;
        }

        System.out.println("Target Angle" + targetAngle);

        
        addCommands(

        new TurnToGoal(targetAngle),
        new MoveToRange(firingDistance),
        new TurnToGoal(targetAngle),
        new BallLiftAutoRun(),
        new MoveForward(36, 0.5));

        /**addSequential(new TiltAcquisition(), timeOut);*/

/**
*        addSequential(new TurnToAngle(-180+gyroAngle));
*        addSequential(new MoveForward((120-firingDistance) + 48, 0.5));
*/
    }
}
