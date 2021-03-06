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
import frc.robot.control.*;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Gyroscope;

public class AutoTurn extends CommandBase {
    private DriveTrain m_driveTrain = RobotContainer.getInstance().getDriveTrain();
    private Gyroscope m_gyro = RobotContainer.getInstance().getGyro();

    double inputAngle;  /**number of degrees to turn*/
    /**declare variables*/
    double initAngle;    /**angle when command is started*/
    /**declare variables*/
    double targetAngle;  /**angle robot is trying to be at*/
    /**declare variables*/
    PID pid;  /**PID controller object*/
    /**declare variables*/

    /**constructor*/
  public AutoTurn(double angle) {
    /** Use requires() here to declare subsystem dependencies*/
    if (m_driveTrain != null){
      addRequirements(m_driveTrain);
    }
    inputAngle = angle;  /**input should be an angle from -180 to positive 180*/
    /**assigns argument to variable*/
  }

  /** Called just before this Command runs the first time*/
  @Override
  public void initialize() {
    initAngle = m_gyro.getDeg();  /**is a value representing the angle the robot is at*/
  /** Called just before this Command runs the first time*/
    targetAngle = (initAngle + inputAngle);  /**sets the target angle, there is a risk of the angle being less than 360 or greater than 0*/
  /** Called just before this Command runs the first time*/
    System.out.println("init autoturn, target: " + targetAngle);

    /**set up PID controller*/
    double kp = 0.35, ki = 0.25, kd = 0;
    pid = new PID(kp, ki, kd, Math.toRadians(targetAngle));

    /*
    I am doing the PID loop in radians because radians are smaller, and the motors will be unable to handle an input of 90, but kp * pi/2 will probably be fine
    */
  }

  /** Called repeatedly when this Command is scheduled to run*/
  @Override
  public void execute() {
    System.out.println(m_gyro.getDeg());
    double increment;  /**the amount that the robot will turn every period*/
  /** Called repeatedly when this Command is scheduled to run*/
    double leftAmount;
    double rightAmount;

    /**determine which way to turn the wheels*/
    boolean turnRight;

    if (targetAngle > initAngle){
      turnRight = false;
    } else {
      turnRight = true;
    }

    increment = Math.abs(pid.control(m_gyro.getRad()));
    /**increment = 0.5;*/

    if (turnRight){
      leftAmount = increment;
      rightAmount = -increment;
    } else {
      leftAmount = -increment;
      rightAmount = increment;
    }

    /**move the robot around it's own axis*/
    m_driveTrain.moveLeftWheels(leftAmount);
    m_driveTrain.moveRightWheels(rightAmount);
  }

  /** Make this return true when this Command no longer needs to run execute()*/
  @Override
  public boolean isFinished() {
    if (m_gyro.getDeg() > targetAngle - Constants.PRECISION && m_gyro.getDeg() < targetAngle + Constants.PRECISION){
        System.out.println("Done turing at angle: " + m_gyro.getDeg());
        return true;
    } else{
        return false;
    }
  }  
}
