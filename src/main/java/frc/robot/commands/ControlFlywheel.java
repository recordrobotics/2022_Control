/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.OI;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Flywheel;

public class ControlFlywheel extends CommandBase {
  /**
   * prevToggle if it was last on or off.
   * flywheelIsOn if the flywheel is currently on or off.
   * Constants.USE_XBOX_CONTROLLER use xbox controller to toggle flywheel.
   * Constants.XBOX_BUTTON which button on the xbox controller toggles the flywheel.
   * Constants.PANEL_BUTTON which button on the panel toggles the flywheel.
   * WHEEL_SPEED how fast the flywheel spins.
   */
  private boolean prevToggle = false, flywheelIsOn = false;
  private Flywheel m_flywheel = RobotContainer.getInstance().getFlywheel();

  private final double WHEEL_SPEED = 0.85;
  /**
   * Create a ControlFlywheel constructor.
   */
  public ControlFlywheel() {
    /** Use requires() here to declare subsystem dependencies*/
    addRequirements(m_flywheel);
  }

  /** Called just before this Command runs the first time*/
  

  /** Called repeatedly when this Command is scheduled to run*/
  @Override
  public void execute() {
    /**toggle*/
    if ((getButton() != prevToggle) && getButton()){
      flywheelIsOn = !flywheelIsOn;
      System.out.println("toggle! " + flywheelIsOn);
    }
    /**hold y to slow down flywheel*/
    if (flywheelIsOn){
      if (OI.getXboxButtonState("Y")){
        m_flywheel.moveWheel(WHEEL_SPEED - 0.4);
      } else {
        m_flywheel.moveWheel(WHEEL_SPEED);
      }
    } else {
      m_flywheel.moveWheel(0);
    }

    prevToggle = getButton();
  }
  /**
   * Returns the button used to toggle the flywheel.
   * @return the button used to toggle the flywheel.
   */
  private boolean getButton(){
    if (Constants.USE_XBOX_CONTROLLER){
      return OI.getXboxButtonState(Constants.XBOX_BUTTON);
    } else {
      return OI.getPanelButtonState(Constants.PANEL_BUTTON);
    }
  }

  /** Make this return true when this Command no longer needs to run execute()*/
  @Override
  public boolean isFinished() {
    return false;
  }

  /** Called once after isFinished returns true*/
  

/**
*   Called when another command which requires one or more of the same
*   subsystems is scheduled to run
*/
  
}
