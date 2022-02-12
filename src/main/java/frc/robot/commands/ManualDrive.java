/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
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
      case MONTY:
        driveMonty();
      default:
        break;
    }
  }

  private double driveMonolith() {
    double turnAmount = OI.getTurn() * Constants.TURN_MULTIPLIER;
    double forwardAmount = OI.getForward() * Constants.FORWARD_MULTIPLIER;
    
    double leftAmount = forwardAmount;
    double rightAmount = forwardAmount;

    leftAmount += turnAmount;
    rightAmount -= turnAmount;

    leftAmount = OI.accCurve(leftAmount);
    rightAmount = OI.accCurve(rightAmount);

    m_driveTrain.moveLeftWheels(leftAmount);
    m_driveTrain.moveRightWheels(rightAmount);

    return ((leftAmount + rightAmount) / 2);
  }

  private void drive2020() {
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
  private void driveMonty() {
    double turnAmount = OI.getTurn() * Constants.TURN_MULTIPLIER;
    double forwardAmount = OI.getForward() * Constants.FORWARD_MULTIPLIER;
    
    double leftAmount = forwardAmount;
    double rightAmount = forwardAmount;

    leftAmount += turnAmount;
    rightAmount -= turnAmount;

    if (leftAmount > 0.5) {
      leftAmount =0.5;
    }
    if (rightAmount > 0.5) {
      rightAmount =0.5;
    }

    leftAmount = OI.accCurve(leftAmount);
    rightAmount = OI.accCurve(rightAmount);

    if (leftAmount > 0.5) {
      leftAmount =0.5;
    }
    if (rightAmount > 0.5) {
      rightAmount =0.5;
    }

    m_driveTrain.moveLeftWheels(leftAmount);
    m_driveTrain.moveRightWheels(rightAmount);
  }

  /** Make this return true when this Command no longer needs to run execute() */
  @Override
  public boolean isFinished() {
    return false;
  }
}
