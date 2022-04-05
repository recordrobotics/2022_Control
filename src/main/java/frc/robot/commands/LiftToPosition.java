/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.RobotContainer;
import frc.robot.subsystems.RobotLift;
import frc.robot.subsystems.CIBMunchkin;
import frc.robot.subsystems.LiftRotater;
import frc.robot.control.PID;

/**
 * An example command. You can replace me with your own command.
 */
public class LiftToPosition extends CommandBase {
  private double pos;
  private LiftRotater m_lift = RobotContainer.getInstance().getRotater();
  private PID pid;
  private final double LIFT_SPEED = 0.15;

  public LiftToPosition(double position) {
    /** Converts degree input to abstract units for the encoders
     * Currently large margin of error, may need to be adjusted
    */
    pos = position;
  }

  /** Called just before this Command runs the first time */
  @Override
  public void initialize() {
    // m_lift.resetEncoder();
  }

  /** Called repeatedly when this Command is scheduled to run */
  @Override
  public void execute() {
    if(pos < 0){
      m_lift.rotateLift(-LIFT_SPEED);
    }else{
      if(pos > 0){
        m_lift.rotateLift(LIFT_SPEED);
      }else{
        m_lift.rotateLift(0);
      }
    }
  }

  /** Make this return true when this Command no longer needs to run execute() */
  @Override
  public boolean isFinished(){
    if (Math.abs(m_lift.getPosition()) > Math.abs(pos)){
        System.out.println("Done lifting at: " + m_lift.getPosition());
        return true;
    } else{
        return false;
    }
  }

  /** Called once after isFinished returns true */
  @Override
  public void end(boolean interrupted) {
    m_lift.rotateLift(0);
  }

}
