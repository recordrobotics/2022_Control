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
import frc.robot.subsystems.AcqServosMunchkin;

/**
 * An example command. You can replace me with your own command.
 */
public class ControlMunchkinServos extends CommandBase {
  private boolean prevToggle = false, servosFlipped = false;
  private AcqServosMunchkin m_servos = RobotContainer.getInstance().getAcqServos();
  public ControlMunchkinServos() {
    /** Use robot container to declare the subsytem's default command */
  }

  /** Called just before this Command runs the first time */
  @Override
  public void initialize() {
    m_servos.setServos(0);
  }

  /** Called repeatedly when this Command is scheduled to run */
  @Override
  public void execute() {
    if ((OI.getXboxButtonState("X") != prevToggle) && (OI.getXboxButtonState("X"))){
      servosFlipped = !servosFlipped;
      System.out.println("toggle! " + servosFlipped);
    }

    if (servosFlipped){  
    m_servos.setServos(1);
    } else {
    m_servos.setServos(0);
    }

    prevToggle = OI.getXboxButtonState("X") ;
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
