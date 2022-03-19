/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.OI;
import frc.robot.RobotContainer;
import frc.robot.RobotModel;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.FlywheelMunchkin;

public class ControlFlywheel extends CommandBase {

  private boolean enabled = false, prevBtnState = false; 
  private Flywheel m_flywheel = RobotContainer.getInstance().getFlywheel();
  private FlywheelMunchkin m_servos;

  // TODO: figure out what speed we actually need
  private final double SPEED = 0.6;
  private final double SPEED_BOOSTED = 1.0;

  public ControlFlywheel() {
    if (Constants.CURRENT_ROBOT == RobotModel.MUNCHKIN) {
      m_servos = (FlywheelMunchkin) m_flywheel;
     }
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
      try {
        //Timer.delay(0.3);
        m_servos.setServos(0.33, 0);
      }
      catch (Exception e) {
        System.out.println(e);
      }      
    } else {
      m_flywheel.moveWheel(0);
      try {
        m_servos.setServos(0, 0.33);
      }
      catch (Exception e) {
        System.out.println(e);
      }
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
