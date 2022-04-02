/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.OI;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Dashboard;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.RangeFinder;

public class ControlFlywheel extends CommandBase {

  private boolean enabled = false, boosted = false;
  private boolean enableBtnDown = false, boostBtnDown = false;
  private Flywheel m_flywheel = RobotContainer.getInstance().getFlywheel();
  private Dashboard m_dashboard = RobotContainer.getInstance().getDashboard();
  private RangeFinder m_rangeFinder = RobotContainer.getInstance().getRangeFinder();

  private final double SPEED_IDLE = 0.0;
  private final double SPEED_NORMAL = 0.25;
  private final double SPEED_BOOSTED = 0.4;

  public ControlFlywheel() {
    addRequirements(m_flywheel);
    addRequirements(m_rangeFinder);
  }

  @Override
  public void execute() {
    // Toggle on/off
    if (!enableBtnDown && enableBtn()) {
      enabled = !enabled;
      enableBtnDown = true;
    } else {
      enableBtnDown = enableBtn();
    }

    if (enabled) {
      if (!boostBtnDown && boostBtn()) {
        boosted = !boosted;
        boostBtnDown = true;
      } else {
        boostBtnDown = boostBtn();
      }

      // Holding Y accelerates the flywheel and shoots ball
      if (boosted) {
        m_flywheel.setWheelSpeed(SPEED_BOOSTED);
      } else {
        m_flywheel.setWheelSpeed(SPEED_NORMAL);
      }
      
      if (shootBtn()) {
        m_flywheel.shoot();
      } else {
        m_flywheel.reset();
      }
    } else {
      boosted = false;
      m_flywheel.setWheelSpeed(SPEED_IDLE);
      m_flywheel.reset();
    }
  }

  /**
   * Checks if enable button is pressed
   * @return button state
   */
  private boolean enableBtn() {
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
  private boolean boostBtn() {
    if (Constants.FLYWHEEL_USE_XBOX_CONTROLLER) {
      return OI.getXboxButtonState(Constants.XBOX_FLYWHEEL_BOOST);
    } else {
      return false;
    }
  }
  
  /**
   * Check if shoot buttton is pressed
   * @return button state
   */
  private boolean shootBtn() {
    if (Constants.FLYWHEEL_USE_XBOX_CONTROLLER) {
      return OI.getXboxButtonState(Constants.XBOX_FLYWHEEL_SHOOT);
    } else {
      return false;
    }
  }

  @Override
  public boolean isFinished() {
    return false;
  }

}
