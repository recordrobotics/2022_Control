/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import com.revrobotics.*;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import frc.robot.RobotMap;

/**
 * This is the class that all Record Robotics drive trains should extend
 */
public class DriveMunchkin extends DriveTrain {
  private CANSparkMax[] left = {
                                  new CANSparkMax(RobotMap.driveMotor_lf, CANSparkMax.MotorType.kBrushless),
                                  new CANSparkMax(RobotMap.driveMotor_lb, CANSparkMax.MotorType.kBrushless)};
  private CANSparkMax[] right = {
                                  new CANSparkMax(RobotMap.driveMotor_rf, CANSparkMax.MotorType.kBrushless),
                                  new CANSparkMax(RobotMap.driveMotor_rb, CANSparkMax.MotorType.kBrushless)};

  private MotorControllerGroup leftMotors = new MotorControllerGroup(left);
  private MotorControllerGroup rightMotors = new MotorControllerGroup(right);
  //Drive encoders
  private RelativeEncoder encoderLeftf = left[0].getEncoder();
  private RelativeEncoder encoderLeftb = left[1].getEncoder();
  private RelativeEncoder encoderRightb = right[1].getEncoder();
  private RelativeEncoder encoderRightf = right[0].getEncoder();
  /**
   * Library Differential Drive object
   */
  private DifferentialDrive drive = new DifferentialDrive(leftMotors, rightMotors);
  
  /**
   * creates drive object, stopping motors like a good boi
   */
  public DriveMunchkin(){
    System.out.println("ENCODER INIT: " + encoderRightb.setPositionConversionFactor(21.42/Math.PI));
    System.out.println("ENCODER INIT: " + encoderRightf.setPositionConversionFactor(21.42/Math.PI));
    encoderLeftb.setPositionConversionFactor(10.71/(6*Math.PI));
    encoderLeftf.setPositionConversionFactor(10.71/(6*Math.PI));
    leftMotors.stopMotor();
    rightMotors.stopMotor();
    resetEncoders();
  }

  private long disabled_time = 0;
  private long disabled_start_time = 0;

  /**
   * @param amount amount to move the wheel. Depends on context, is usually percent output
   */
  public void moveLeftWheels(double amount) {
    leftMotors.set(amount);
  };

  /**
   * @param amount amount to move the wheel. Depends on context, is usually percent output
   */
  public void moveRightWheels(double amount) {
    rightMotors.set(amount);
  }

  /**
   * @return The Value of the right encoder in FEET
   */
  public double getRightEncoder() {
    return (encoderRightb.getPosition() + encoderRightf.getPosition()) / 2;
  }
  /**
   * @return The Value of the right encoder in FEET
   */
  public double getLeftEncoder() {
    return (encoderLeftb.getPosition() + encoderLeftf.getPosition()) / 2;
  }
  /**
   * Reset both encoders to zero
   */
  public void resetEncoders() {
    System.out.println("ENCODERS RESETTING");
    System.out.println(encoderRightb.setPosition(0.0));
    System.out.println(encoderRightf.setPosition(0.0));
    System.out.println(encoderLeftb.setPosition(0.0));
    System.out.println(encoderLeftf.setPosition(0.0));
    System.out.println("ENCODER VALUES AFTER RESET: RIGHT: " + getRightEncoder() + "LEFT: " + getLeftEncoder());
  };
  
  /**
   * @return The differential drive object used, if any
   */
  public DifferentialDrive getDrive() {
    return drive;
  }

  public boolean isDisabled() {
    return System.currentTimeMillis() - disabled_start_time < disabled_time;
  }


  public void stop() {
    moveLeftWheels(0);
    moveRightWheels(0);
  }
}
