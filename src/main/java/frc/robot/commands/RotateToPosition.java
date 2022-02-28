/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.LiftRotater;

/**
 * An example command. You can replace me with your own command.
 */
public class RotateToPosition extends CommandBase {
  private double pos;
  private LiftRotater m_rotater = RobotContainer.getInstance().getRotater();
  public RotateToPosition(double position) {
    /** Use robot container to declare the subsytem's default command */
    pos = position;
  }

  /** Called just before this Command runs the first time */
  @Override
  public void initialize() {
    m_rotater.resetLeftRotateEncoder();
  }

  /** Called repeatedly when this Command is scheduled to run */
  @Override
  public void execute() {
    if(pos < 0){
      m_rotater.RotateLift(0.15);
    }
    if(pos > 0){
      m_rotater.RotateLift(-0.15);
    }else{
      m_rotater.RotateLift(0);
    }

  }

  /** Make this return true when this Command no longer needs to run execute() */
  @Override
  public boolean isFinished() {
    if(m_rotater.getPosition()>pos){
      return true;
    }else{
      return false;
    }
  }

  /** Called once after isFinished returns true */
  @Override
  public void end(boolean interrupted) {
    m_rotater.RotateLift(0);
  }

}
