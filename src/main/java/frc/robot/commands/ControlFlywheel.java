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

  private boolean enabled = false, prevBtnState = false; 
  private Flywheel m_flywheel = RobotContainer.getInstance().getFlywheel();

  // TODO: figure out what speed we actually need
  private final double SPEED = 0.6;
  private final double SPEED_BOOSTED = 1.0;

  public ControlFlywheel() {
    addRequirements(m_flywheel);
  }

  @Override
  public void execute() {
    // Toggle on/off
    if (toggled() && !prevBtnState) {
      enabled = !enabled;
    }
    if (enabled) {
      // Holding Y accelerates the flywheel
      if (boosted()) {
        m_flywheel.moveWheel(SPEED_BOOSTED);
      } else {
        m_flywheel.moveWheel(SPEED);
      }
    } else {
      m_flywheel.moveWheel(0);
    }

    prevBtnState = toggled();
  }

  /**
   * Checks if toggle button is pressed
   * @return button state
   */
  private boolean toggled() {
    if (Constants.FLYWHEEL_USE_XBOX_CONTROLLER){
      return OI.getXboxButtonState(Constants.XBOX_FLYWHEEL_ENABLE);
    } else {
      return OI.getPanelButtonState(Constants.PANEL_FLYWHEEL_ENABLE);
    }
  }

  /**
   * Checks if boost button in pressed
   * @return button state
   */
  private boolean boosted() {
    if (Constants.FLYWHEEL_USE_XBOX_CONTROLLER) {
      return OI.getXboxButtonState(Constants.XBOX_FLYWHEEL_BOOST);
    } else {
      return false;
    }
  }

  @Override
  public boolean isFinished() {
    return false;
  }

}
