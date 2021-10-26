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
import frc.robot.control.ButtonMap;
import frc.robot.subsystems.LiftSpool;

public class ControlSpool extends CommandBase {
  /**
   * spoolSpeed how fast the spool spins.
   */
  private double spoolSpeed = 0.5;
  private LiftSpool m_liftSpool;

  /**
   * Creates a ControlSpool constuctor.
   */
  public ControlSpool() {
    m_liftSpool = RobotContainer.getInstance().getLiftSpool();
    /** Use requires() here to declare subsystem dependencies */
    addRequirements(m_liftSpool);
  }

  /** Called repeatedly when this Command is scheduled to run */
  @Override
  public void execute() {
    if (OI.getPanelButtonState(ButtonMap.winchUp)) {
      m_liftSpool.MoveSpool(spoolSpeed);
    } else if (OI.getPanelButtonState(ButtonMap.winchDown)) {
      m_liftSpool.MoveSpool(-spoolSpeed);
    } else {
      m_liftSpool.MoveSpool(0);
    }
  }

  /** Make this return true when this Command no longer needs to run execute() */
  @Override
  public boolean isFinished() {
    return false;
  }

}
