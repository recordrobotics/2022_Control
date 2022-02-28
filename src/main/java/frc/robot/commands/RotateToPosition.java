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
    /** Converts degree input to abstract units for the encoders
     * Currently large margin of error, may need to be adjusted
    */
    pos = position * 0.5;
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
      m_rotater.RotateLift(-0.15);
      System.out.println(m_rotater.getPosition()+ "moving to negative");
    }else{
      if(pos > 0){
        m_rotater.RotateLift(0.15);
        System.out.println(m_rotater.getPosition()+ "moving to positive");
      }else{
        m_rotater.RotateLift(0);
      }
    }
    
    System.out.println("Running Auto Lift" + pos);
  }

  /** Make this return true when this Command no longer needs to run execute() */
  @Override
  public boolean isFinished() {
    if(pos>0){
    if(m_rotater.getPosition()>pos){
      return true;
    }else{
      return false;
    }
  }
  if (pos<0){
    if(m_rotater.getPosition()<pos){
      return true;
    }else{
      return false;
    }
  }else{
    return true;
  }
  }

  /** Called once after isFinished returns true */
  @Override
  public void end(boolean interrupted) {
    m_rotater.RotateLift(0);
  }

}
