/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.BallLift;
import frc.robot.subsystems.Flywheel;

/**
 * ballTimer is a built in Timer function
 * BELT_SPEED the motor speed for the belt
 * FLYWHEEL_SPEED the motor speed for the flywheel
 * ballTimeout the amount of time that the belt and flywheel run for 
 */
public class BeltAutoRun extends CommandBase {
  
  private Flywheel m_flywheel = RobotContainer.getInstance().getFlywheel(); 
  private BallLift m_ballLift = RobotContainer.getInstance().getBallLift();
  private Timer ballTimer = new Timer();
  private double BELT_SPEED = 0.5, FLYWHEEL_SPEED = 0.80;

 /** Called just before this Command runs the first time*/
 
  @Override
  public void initialize() {
      /**
   * Starts the timer and turns on the flywheel motor at the set speed
   */
    ballTimer.start();
    m_flywheel.moveWheel(FLYWHEEL_SPEED);
  }

  ///** Called rep Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    /**
     * Once again runs the flywheel motor at the set speed
     * If the timer has been running for at least 1 second runs the belt at the set speed
     */
    m_flywheel.moveWheel(FLYWHEEL_SPEED);

    if (ballTimer.get() > 1)
    m_ballLift.moveBelt(BELT_SPEED);
  }
 /**
  * Ends the command when the timer value is greater than the timeout variable
  */
  /** Make this return true when this Command no longer needs to run execute()*/
  @Override
  public boolean isFinished() {
    return ballTimer.get() >= Constants.BALL_TIMEOUT;
  }
/**
 * Stops the flywheel and belt when the command ends
 */
  /** Called once after isFinished returns true*/
  @Override
  public void end(boolean interrupted) {
    m_flywheel.moveWheel(0);
    m_ballLift.moveBelt(0);
  }

}
