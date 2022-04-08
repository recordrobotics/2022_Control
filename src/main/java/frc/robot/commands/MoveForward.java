/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.RangeFinder;

public class MoveForward extends CommandBase {

    private double distance;
    /** distance to travel in INCHES */
    /**
     * Called when another command which requires one or more of the same subsystems
     * is scheduled to run
     */
    private double speed;
    private DriveTrain m_driveTrain = RobotContainer.getInstance().getDriveTrain();
    private RangeFinder m_rangeFinder = RobotContainer.getInstance().getRangeFinder();

    /**
     * s
     * @param dist distance in INCHES 
     * @param sp speed to move at
     */
    public MoveForward(double dist, double sp) {
        distance = dist;
        speed = sp;
    }

    public MoveForward() {
        distance = m_rangeFinder.getDistance();
        speed = 0.5;
    }

    /** Called just before this Command runs the first time */
    @Override
    public void initialize() {
        m_driveTrain = RobotContainer.getInstance().getDriveTrain();
        /** reset the encoders */
        m_driveTrain.resetEncoders();
        System.out.println("command move init");
        System.out.println(m_driveTrain.getLeftEncoder() + m_driveTrain.getRightEncoder());
    }

    /** Called repeatedly when this Command is scheduled to run */
    @Override
    public void execute() {
        m_driveTrain.moveLeftWheels(speed);
        m_driveTrain.moveRightWheels(-speed);
    }

    /** Make this return true when this Command no longer needs to run execute() */
    @Override
    public boolean isFinished() {
        System.out.println(m_driveTrain.getRightEncoder());
        System.out.println(m_driveTrain.getLeftEncoder());
        return Math.abs(m_driveTrain.getRightEncoder()) >= distance && Math.abs(m_driveTrain.getLeftEncoder()) >= distance;
    }

    /** Called once after isFinished returns true */
    @Override
    public void end(boolean intterupted) {
        if (intterupted) {
            System.out.println("AUTO MOVE INTTERUPTED!!! \n\n");
        }
        m_driveTrain.moveLeftWheels(0);
        m_driveTrain.moveRightWheels(0);
    }
}