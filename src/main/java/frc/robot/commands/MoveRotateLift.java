/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.Constants;
import frc.robot.subsystems.LiftRotater;
import frc.robot.subsystems.RobotLift;

/**
 * An example command. You can replace me with your own command.
 */
public class MoveRotateLift  extends CommandBase {
    private LiftRotater m_lift = RobotContainer.getInstance().getRotater();
    private double distance;
    private double speed;
    public MoveRotateLift(double distance, double sp) {
        this.distance = distance;
        speed = sp;
        addRequirements(m_lift);
    /** Use robot container to declare the subsytem's default command */
  }

  /** Called just before this Command runs the first time */
  @Override
  public void initialize() {
      m_lift.resetLeftRotateEncoder();
  }

  /** Called repeatedly when this Command is scheduled to run */
  @Override
  public void execute() {
      m_lift.RotateLift(speed); //change to ROTATE_SPEED;
  }

  /** Make this return true when this Command no longer needs to run execute() */
  @Override
  public boolean isFinished() {
    //return true when encoder value is equal to certain value;
    return Math.abs(m_lift.getPosition()) >= Math.abs(distance);
  }

  /** Called once after isFinished returns true */
  @Override
  public void end(boolean interrupted) {
    m_lift.RotateLift(0);
  }

}

