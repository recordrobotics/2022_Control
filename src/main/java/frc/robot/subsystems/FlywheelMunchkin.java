/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.Servo;
import frc.robot.RobotMap;

public class FlywheelMunchkin extends Flywheel {
    /**
     * flywheelMotor Creates a motor object for the flywheel motor. targetVoltage
     * The target voltage of the flywheel.
     */
    private WPI_TalonFX flywheelMotor = new WPI_TalonFX(RobotMap.flywheelMunchkin);
    private double targetVoltage = 11.5;
    private Servo acqServo1 = new Servo(0);
    private Servo acqServo2 = new Servo(1);
    /**
     * Creates an Object for the flywheel class.
     */
    public FlywheelMunchkin() {
        flywheelMotor.enableVoltageCompensation(true);
        flywheelMotor.setVoltage(targetVoltage);
        setServos(0, 0.33);
    }

    /**
     * Spins the flywheel motor.
     * 
     * @param v The speed at which the flywheel motor turns.
     */
    public void moveWheel(double v) {
        flywheelMotor.set(ControlMode.PercentOutput, v);
    }

    /**
     * Returns the flywheel's voltage output.
     * 
     * @return The flywheel's voltage output.
     */
    public double getVoltage() {
        return flywheelMotor.getMotorOutputVoltage();
    }
    public void setServos(double v1, double v2){
        acqServo1.set(v1);
        acqServo2.set(v2);
        }
}