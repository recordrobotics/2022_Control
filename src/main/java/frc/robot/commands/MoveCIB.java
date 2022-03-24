/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.lang.module.ModuleDescriptor.Requires;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.*;

public class MoveCIB extends CommandBase {
    private RobotLift m_lift = RobotContainer.getInstance().getRobotLift();
    private double distance;
    private double speed;
    public MoveCIB(double d, double sp) {
        addRequirements(m_lift);
        speed = sp;
        distance = d;
    }

  /** Called just before this Command runs the first time */
  @Override
  public void initialize() {
      m_lift.resetEncoder();
  }

  /** Called repeatedly when this Command is scheduled to run */
  @Override
  public void execute() {
      m_lift.moveLift(speed);
  }

  /** Make this return true when this Command no longer needs to run execute() */
  @Override
  public boolean isFinished() {
    //return true when encoder value is equal to certain value;
    return Math.abs(m_lift.getPosition()) >= Math.abs(distance);
  }

  /** Called once after isFinished returns true */
  @Override
  public void end(boolean interrupted) {
  }

}
