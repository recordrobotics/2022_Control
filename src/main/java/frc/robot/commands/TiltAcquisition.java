/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Acquisition;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Timer;

public class TiltAcquisition extends CommandBase {
  /**
   * acqTimer Timer to time the amount of time that has passed since the
   * acquisition started tilting. Constants.ACQ_MOVE_TIME How long it should take to tilt.
   * TiltAcquisition Creates new TiltAcquisition object.
   */
  private Timer acqTimer = new Timer();
  private Acquisition m_acquisition = RobotContainer.getInstance().getAcquisition();

  /** Called just before this Command runs the first time */
  @Override
  public void initialize() {
    acqTimer.start();
  }

  /** Called repeatedly when this Command is scheduled to run */
  @Override
  public void execute() {
    if (m_acquisition.getTiltPosition()) {
      m_acquisition.moveTilt(-Constants.TILT_SPEED);
    } else {
      m_acquisition.moveTilt(Constants.TILT_SPEED);
    }
  }

  /** Make this return true when this Command no longer needs to run execute() */
  @Override
  public boolean isFinished() {
    return acqTimer.get() > Constants.ACQ_MOVE_TIME && m_acquisition.getTiltLimit();
  }

  /** Called once after isFinished returns true */
  @Override
  public void end(boolean intterupted) {
    m_acquisition.setTiltPosition(!m_acquisition.getTiltPosition());
    acqTimer.stop();
    acqTimer.reset();
  }
}
