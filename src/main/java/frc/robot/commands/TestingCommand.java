/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.RobotContainer;
import frc.robot.control.XboxJoystick;
import frc.robot.subsystems.MotorTestingSubsystem;

/**
 * An example command. You can replace me with your own command.
 */
public class TestingCommand extends CommandBase {
  private MotorTestingSubsystem m_test = RobotContainer.getInstance().getTestSubsystem();
  public TestingCommand() {
    addRequirements(m_test);
    /** Use robot container to declare the subsytem's default command */
  }
  /** Called just before this Command runs the first time */
  @Override
  public void initialize() {
    m_test.motorTestingSubsysytem();
  }

  /** Called repeatedly when this Command is scheduled to run */
  @Override
  public void execute() {
    runMotors();
  }
public void runMotors(){
  m_test.testMotors(OI.getForward()*0.2);
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
