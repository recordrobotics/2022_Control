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
import frc.robot.control.PID;

/**
 * An example command. You can replace me with your own command.
 */
public class RotateToPosition extends CommandBase {
  private double pos;
  private LiftRotater m_rotater = RobotContainer.getInstance().getRotater();
  private PID pid;
  private final double PID_MODIFIER = 0.2;

  public RotateToPosition(double position) {
    /** Converts degree input to abstract units for the encoders
     * Currently large margin of error, may need to be adjusted
    */
    pos = position * 0.5;
    pid = new PID(0.1,0.1,0,pos);
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
      m_rotater.rotateLift(-PID_MODIFIER*pid.control(m_rotater.getPosition()-pos));
      System.out.println(m_rotater.getPosition()+ "moving to negative");
    }else{
      if(pos > 0){
        m_rotater.rotateLift(PID_MODIFIER*pid.control(m_rotater.getPosition()-pos));
        System.out.println(m_rotater.getPosition()+ "moving to positive");
      }else{
        m_rotater.rotateLift(0);
      }
    }
    
    System.out.println("Running Auto Lift" + pos);
  }

  /** Make this return true when this Command no longer needs to run execute() */
  @Override
  public boolean isFinished() {
    if (m_rotater.getPosition() > pos - 1 && m_rotater.getPosition() < pos + 1){
        System.out.println("Done turing at angle: " + m_rotater.getPosition());
        return true;
    } else{
        return false;
    }
  }

  /** Called once after isFinished returns true */
  @Override
  public void end(boolean interrupted) {
    m_rotater.rotateLift(0);
  }

}
