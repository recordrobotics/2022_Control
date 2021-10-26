/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class MoveForward extends CommandBase {

    private double distance;
    /** distance to travel in INCHES */
    /**
     * Called when another command which requires one or more of the same subsystems
     * is scheduled to run
     */
    private double speed;
    private RobotContainer m_container;

    public MoveForward(double dist, double sp) {
        distance = dist;
        speed = sp;
    }

    public MoveForward() {
        m_container = RobotContainer.getInstance();
        distance = m_container.getRangeFinder().getDistance();
        speed = 0.7;
    }

    /** Called just before this Command runs the first time */
    @Override
    public void initialize() {
        /** reset the encoders */
        m_container.getDriveTrain().resetEncoders();
        System.out.println("command move init");
    }

    /** Called repeatedly when this Command is scheduled to run */
    @Override
    public void execute() {
        m_container.getDriveTrain().moveLeftWheels(speed);
        m_container.getDriveTrain().moveRightWheels(speed);
    }

    /** Make this return true when this Command no longer needs to run execute() */
    @Override
    public boolean isFinished() {
        return m_container.getDriveTrain().getRightEncoder() >= distance || m_container.getDriveTrain().getLeftEncoder() >= distance;
    }

    /** Called once after isFinished returns true */
    @Override
    public void end(boolean intterupted) {
        m_container.getDriveTrain().moveLeftWheels(0);
        m_container.getDriveTrain().moveRightWheels(0);
    }
}