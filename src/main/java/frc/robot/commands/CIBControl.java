/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI;
import frc.robot.RobotContainer;
import frc.robot.Constants;
import frc.robot.control.*;
import frc.robot.subsystems.RobotLift;

public class CIBControl extends CommandBase {
  private RobotLift m_lift = RobotContainer.getInstance().getRobotLift();
  /**
   * Creates a LiftControl constructor.
   */
  public CIBControl() {
    /** Use requires() here to declare subsystem dependencies */
    addRequirements(m_lift);
  }

  /**
   * Constants.SPEED the speed the lift moves. position safety or no safety.
   */
  private int position = 0;

  /** nonzero value kills the saftey mechanism */
  /** Use requires() here to declare subsystem dependencies */

  /** Called just before this Command runs the first time */
  @Override
  public void initialize() {
    position = 0;
  }

  /** Called repeatedly when this Command is scheduled to run */
  @Override
  public void execute() {
    if(OI.getRightStickUp()){
      m_lift.moveLift(OI.getCStickYAxis() / 2);
    }
    else if(OI.getRightStickDown()){
      m_lift.moveLift(OI.getCStickYAxis() / 2);
    }
    else if (OI.getXboxButtonState("A")) {
      m_lift.moveLift(0.125);
    }
    else {
      m_lift.moveLift(0);
    }
  }

  /** Make this return true when this Command no longer needs to run execute() */
  @Override
  public boolean isFinished() {
    return false;
  }

}