/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drive2020;
import frc.robot.subsystems.DriveMonolith;
import frc.robot.subsystems.DriveTrain;
import frc.robot.Constants;
import frc.robot.OI;

public class ManualDrive extends CommandBase {

  /** input multiplier, reduces or increases the input value */
  private DriveTrain m_driveTrain = RobotContainer.getInstance().getDriveTrain();

  public ManualDrive() {
    /** Use requires() here to declare subsystem dependencies */
    addRequirements(m_driveTrain);
  }

  /** Called repeatedly when this Command is scheduled to run */
  @Override
  public void execute() {
    switch (Constants.CURRENT_ROBOT) {
      case MONOLITH:
        driveMonolith();
        break;
      case ROBOT2020:
        drive2020();
        break;
      default:
        break;
    }
  }

  private double driveMonolith() {
    DriveMonolith m_driveMonolith = (DriveMonolith) m_driveTrain; // To be able to reference DriveMonolith specifically
    m_driveMonolith.updateVoltage();

    double turnAmount = OI.getTurn() * Constants.TURN_MULTIPLIER;
    double forwardAmount = OI.getForward() * Constants.FORWARD_MULTIPLIER;
    
    double leftAmount = forwardAmount;
    double rightAmount = forwardAmount;

    leftAmount += turnAmount;
    rightAmount -= turnAmount;

    leftAmount = OI.accCurve(leftAmount);
    rightAmount = OI.accCurve(rightAmount);

    m_driveMonolith.moveLeftWheels(leftAmount);
    m_driveMonolith.moveRightWheels(rightAmount);

    return ((leftAmount + rightAmount) / 2);
  }

  private void drive2020() {
    // Drive2020 m_drive2020 = (Drive2020) m_driveTrain; In case we need to reference Drive2020 specifically

    double fwdMult2020 = Constants.FORWARD_MULTIPLIER;
    double turnMult2020 = Constants.TURN_MULTIPLIER;
    if (OI.getXboxButtonState("LS")) {

      fwdMult2020 = Constants.FORWARD_MULTIPLIER * 1.5;
      turnMult2020 = Constants.TURN_MULTIPLIER * 1.5;

      if (fwdMult2020 > 1) {
        fwdMult2020 = 1;
      }
      if (turnMult2020 > 1) {
        turnMult2020 = 1;
      }
    }
    m_driveTrain.getDrive().arcadeDrive(OI.getForward() * fwdMult2020, OI.getTurn() * Constants.TURN_MULTIPLIER);
  }

  /** Make this return true when this Command no longer needs to run execute() */
  @Override
  public boolean isFinished() {
    return false;
  }
}
