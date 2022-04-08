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
import frc.robot.subsystems.Flywheel;

/*
 * Automatically shoots the Flywheel at the start of the game
 */
public class FlywheelAutoRun extends CommandBase {
  
  private Flywheel m_flywheel = RobotContainer.getInstance().getFlywheel();
  private Timer flywheelShootDurationTimer = new Timer();

 /** Called just before this Command runs the first time*/
 
  @Override
  public void initialize() {
      /**
   * Starts the timer and turns on the flywheel motor at the set speed
   */
    flywheelShootDurationTimer.start();
    m_flywheel.setWheelSpeed(Constants.FLYWHEEL_SPEED);
    
  }

  ///** Called rep Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    /**
     * Once again runs the flywheel motor at the set speed
     * If the timer has been running for at least 1 second runs the ball lift at the set speed
     */
    m_flywheel.setWheelSpeed(Constants.FLYWHEEL_SPEED);
    if(flywheelShootDurationTimer.get() > 2){
      m_flywheel.shoot();
    }
  }
 /**
  * Ends the command when the timer value is greater than the timeout variable
  */
  /** Make this return true when this Command no longer needs to run execute()*/
  @Override
  public boolean isFinished() {
    System.out.println(flywheelShootDurationTimer.get());
    return flywheelShootDurationTimer.get() >= Constants.BALL_TIMEOUT;
  }
/**
 * Stops the flywheel and ball lift when the command ends
 */
  /** Called once after isFinished returns true*/
  @Override
  public void end(boolean interrupted) {
    m_flywheel.setWheelSpeed(0);
    m_flywheel.reset();
  }
}
