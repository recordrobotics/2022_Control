/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.RobotContainer;
import frc.robot.control.PID;
import frc.robot.subsystems.DriveTrain;
import frc.robot.Constants;
import frc.robot.subsystems.RangeFinder;

public class MoveToRange extends CommandBase {
    /**
     * distance The current distance from the target. speed How fast the robot will
     * move. Constants.TOLERANCE Total tolerance when moving to the location. range The range
     * the robot has to move to. pid Creates a PID Controller. Constants.KP, Constants.KI, Constants.KD Components
     * of PID Controller.
     */
    private double distance, speed = 0.15;
    /** inches */
    /**
     * addSequential(new TurnToAngle(-180+gyroAngle)); addSequential(new
     * MoveForward((120-firingDistance) + 48, 0.5));
     */
    private double range;

    private RangeFinder m_rangeFinder = RobotContainer.getInstance().getRangeFinder();
    private DriveTrain m_driveTrain = RobotContainer.getInstance().getDriveTrain();

    /**
     * MoveToRange() Moves the robot to the set location.
     * 
     * @param dist Total distance to travel.
     */
    public MoveToRange(double dist) {
        distance = dist;
    }

    /** Called just before this Command runs the first time */
    @Override
    public void initialize() {
    }

    /** Called repeatedly when this Command is scheduled to run */
    @Override
    public void execute() {
        range = m_rangeFinder.getBDistance();

        int direction = 1;
        if (range < distance) {
            direction = -1;
        }

        /** speed = pid.control(range); */
        // speed = 0.125;
        // if (range > distance) {
        //     speed *= (range / distance);
        // } else if (range < distance) {
        //     speed *= (distance / range);
        // }

        if (speed > 0.35)
            speed = 0.35;
        if (speed < -0.35)
            speed = -0.35;
        //System.out.println(speed * direction);
        m_driveTrain.moveLeftWheels(speed * direction);
        m_driveTrain.moveRightWheels(speed * -direction);
    }

    /** Make this return true when this Command no longer needs to run execute() */
    @Override
    public boolean isFinished() {
        if (range < distance + Constants.TOLERANCE && range > distance - Constants.TOLERANCE) {
            return true;
        }
        return false;
    }

    /** Called once after isFinished returns true */
    @Override
    public void end(boolean intterupted) {
        m_driveTrain.moveLeftWheels(0);
        m_driveTrain.moveRightWheels(0);
        System.out.println("Moved TO Range, Target: " + distance + ", Actual: " + m_rangeFinder.getDistance());
    }
}