/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.RobotContainer;
import frc.robot.subsystems.LiftRotater;

/**
 * An example command. You can replace me with your own command.
 */
public class RotateLift extends CommandBase {
  private LiftRotater m_rotater = RobotContainer.getInstance().getRotater();
  private final double ROTATOR_SPEED = 0.25;
  public RotateLift() {
    /** Use robot container to declare the subsytem's default command */
    addRequirements(m_rotater);
  }

  /** Called just before this Command runs the first time */
  @Override
  public void initialize() {
  }

  /** Called repeatedly when this Command is scheduled to run */
  @Override
  public void execute() {
    double speed = OI.getCStickXAxis();
    if (Math.abs(speed) < 0.15) {
      speed = 0;
    } else if (Math.abs(speed) > 0.5) {
      speed = Math.abs(speed) / (speed * 2);
    }
    moveRotater(speed);
  }

  private void moveRotater(double v){
    m_rotater.RotateLift(v);
  }
  
  /** Make this return true when this Command no longer needs to run execute() */
  @Override
  public boolean isFinished() {
    return false;
  }

  /** Called once after isFinished returns true */
  @Override
  public void end(boolean interrupted) {
  }

}
