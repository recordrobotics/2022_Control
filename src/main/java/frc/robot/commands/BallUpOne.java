/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.Constants;
import frc.robot.subsystems.Acquisition;
import frc.robot.subsystems.BallLift;
import edu.wpi.first.wpilibj.Timer;

public class BallUpOne extends CommandBase {
  private BallLift m_ballLift = RobotContainer.getInstance().getBallLift();
  private Acquisition m_acq = RobotContainer.getInstance().getAcquisition();
  
  /**
   * highestSlot The highest slot with a ball.
   * targetSlot Where the highest ball needs to go.
   * ballCount How many balls in the lift.
   * BELT_SPEED How fast the belt is moving.
   * Constants.MOVE_TIME How long the belt should take to move.
   * hitSlot If the targetSlot has been reached.
   * ballTimer Timer to time how long it takes for the ball to move to the targetSlot.
   */
  private int highestSlot, targetSlot, ballCount;
  private final double BELT_SPEED = 0.4;
  private Boolean hitSlot;


  private Timer ballTimer = new Timer();

  /** Called just before this Command runs the first time*/
  @Override
  public void initialize() {
    ballTimer.start();

    highestSlot = m_ballLift.highestFullSlot();

    if(highestSlot == 3){
      targetSlot = 3;
    }
    else if(highestSlot != 0){
      targetSlot = highestSlot+1;
    }
  }

  /** Called repeatedly when this Command is scheduled to run*/
  @Override 
  public void execute() {
    m_ballLift.moveBelt(BELT_SPEED);
    m_acq.moveAcq(0.9);
    ballCount = m_ballLift.countBall();
    hitSlot = m_ballLift.getSlot(targetSlot-1);
    
  }

  /** Make this return true when this Command no longer needs to run execute()*/
  @Override
  public boolean isFinished() {
    /** Last or is emergency shutoff so the command will stop running in case of a ball getting stuck*/
    return (ballTimer.get() > Constants.MOVE_TIME && hitSlot)
     || (ballTimer.get() > 1);
  }
}
