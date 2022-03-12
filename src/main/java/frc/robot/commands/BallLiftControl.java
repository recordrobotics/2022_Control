/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.OI;
import frc.robot.RobotContainer;
import frc.robot.subsystems.BallLift;


public class BallLiftControl extends CommandBase {
  private BallLift m_ballLift = RobotContainer.getInstance().getBallLift();
  private double ballLiftSpeed = 0.6;
  private double ballLiftSpeedMunchkin = 0.5;
  private boolean moveUp = false;
  private boolean moveDown = false;

  public BallLiftControl() {
    /** Use requires() here to declare subsystem dependencies*/
    addRequirements(m_ballLift);
  }

  
  /**new ball in the lift from acq*/
  private boolean checkNewBall(){
   return m_ballLift.getSlot(0) || (!m_ballLift.getSlot(1) && 
   moveUp && !checkInput()) && !m_ballLift.getSlot(3);
    /** 
    Move up if there is a ball in the lowest slot OR if the ball is already moving and there is no ball in slot 1
    NEVER move the ball if there is a ball in the top slot, unless due to user input

    May cause bug if there is an attempt to fire before any balls have been aquired
    maybe add timer when moving automatically, and time out to avoid movement when empty?
    or a flag when a ball has been recently aquired?
    */
  }
/**
 * checkInput checks for the button to move up
 * checkReverseInput checks for the button to move down
 */
  private boolean checkInput(){
    return OI.getXboxButtonState("RT");
  }

  private boolean checkReverseInput(){
return OI.getXboxButtonState("RB");
  }

  /** Called just before this Command runs the first time*/
  public void ballLift2020(){
    if (moveUp) { 
      m_ballLift.moveBallLift(ballLiftSpeed);
    } else if (moveDown){
      m_ballLift.moveBallLift(-ballLiftSpeed);
    }
    else {
      m_ballLift.moveBallLift(0);
    }
  }
  public void conveyorMunchkin(){
    if(OI.getXboxButtonState("LT")){
      m_ballLift.moveBallLift(ballLiftSpeedMunchkin);
    }else{
      if(OI.getXboxButtonState("LB")){
      m_ballLift.moveBallLift(ballLiftSpeedMunchkin);
      }else{
        m_ballLift.moveBallLift(0);
      }}
  }

  /** Called repeatedly when this Command is scheduled to run*/
  @Override
  public void execute(){
    switch (Constants.CURRENT_ROBOT) {
      case MUNCHKIN: 
        //
        break;
      case ROBOT2020:
        //
        break;
      default:
        break;
    }
    moveUp = checkInput(); /** || checkNewBall();*/
  /** Called repeatedly when this Command is scheduled to run*/
    
    /**
     * Checks whether to run forwards or in reverse, then runs ball lift either forwards or in reverse
     */
    moveDown = checkReverseInput();

    
    
  }

  /** Make this return true when this Command no longer needs to run execute()*/
  @Override
  public boolean isFinished() {
    return false;
  }
  
}
