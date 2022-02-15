/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import com.revrobotics.*;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * This is the class that all Record Robotics drive trains should extend
 */
public class DriveMunchkin extends DriveTrain {
  private CANSparkMax[] left = {
                                  new CANSparkMax(0, CANSparkMax.MotorType.kBrushless),
                                  new CANSparkMax(1, CANSparkMax.MotorType.kBrushless),
                                  new CANSparkMax(2, CANSparkMax.MotorType.kBrushless)};
  private CANSparkMax[] right = {
                                  new CANSparkMax(3, CANSparkMax.MotorType.kBrushless),
                                  new CANSparkMax(4, CANSparkMax.MotorType.kBrushless),
                                  new CANSparkMax(5, CANSparkMax.MotorType.kBrushless)};

  private SpeedControllerGroup leftMotors = new SpeedControllerGroup(left);
  private SpeedControllerGroup rightMotors = new SpeedControllerGroup(right);
  /**
   * Library Differential Drive object
   */
  private DifferentialDrive drive = new DifferentialDrive(leftMotors, rightMotors);
  public DriveMunchkin() {

  }

  private long disabled_time = 0;
  private long disabled_start_time = 0;

  /**
   * @param amount amount to move the wheel. Depends on contex, is usually percent
   *               output
   */
  public void moveLeftWheels(double amount) {
    leftMotors.set(amount);
  };

  /**
   * @param amount amount to move the wheel. Depends on contex, is usually percent
   *               output
   */
  public void moveRightWheels(double amount) {
    rightMotors.set(amount);
  }

  /**
   * @return The Value of the right encoder in INCHES
   */
  public double getRightEncoder() {
    return 0.0;
  }
  /**
   * @return The Value of the right encoder in INCHES
   */
  public double getLeftEncoder() {
    return 0.0;
  }
  /**
   * Reset both encoders to zero
   */
  public void resetEncoders() {};
  
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
