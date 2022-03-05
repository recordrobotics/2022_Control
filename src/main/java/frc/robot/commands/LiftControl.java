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

public class LiftControl extends CommandBase {
  private RobotLift m_lift = RobotContainer.getInstance().getRobotLift();
  /**
   * Creates a LiftControl constructor.
   */
  public LiftControl() {
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
    switch (Constants.CURRENT_ROBOT) {
      case MUNCHKIN:
      liftControlMunchkin();
      break;
      case ROBOT2020:
        liftControl2020();
        break;
      default:
        break;
    } 
  }
 
  public void liftControlMunchkin(){
    if(OI.getRightStickUp()){
    m_lift.moveLift(0.3);
    }
    else if(OI.getRightStickDown()){
        m_lift.moveLift(-0.3);
    }
    else{
        m_lift.moveLift(0);
    }
  }
  
  /**
   * Moves lift based on GREEN PANEL BUTTONS OR YELLOW PANEL BUTTONS.
   */
  public void liftControl2020() {
    /**
     * if the left green button is pressed, move up if the right green button is
     * pressed, move down
     */
    
    if ((OI.getPanelButtonState(ButtonMap.liftRaise)) || OI.getPanelButtonState(ButtonMap.LiftOverrideUp)) {
      m_lift.moveLift(Constants.SPEED);
      position++;

    } else if ((OI.getPanelButtonState(ButtonMap.liftLower) && position >= 0)
        || OI.getPanelButtonState(ButtonMap.LiftOverrideDown)) {
      m_lift.moveLift(-Constants.SPEED);
      position--;
    } else {
      m_lift.moveLift(0);
    }

    SmartDashboard.putNumber("Lift position", position);
  }

  /** Make this return true when this Command no longer needs to run execute() */
  @Override
  public boolean isFinished() {
    return false;
  }

}
