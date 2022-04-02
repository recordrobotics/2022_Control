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
    // Target Voltage
    private double targetVoltage = 11.5;

    // Servo positions for shoot and reset
    private final double RIGHT_SERVO_SHOOT = 0.0;
    private final double LEFT_SERVO_SHOOT = 0.33;
    private final double RIGHT_SERVO_RESET = 0.33;
    private final double LEFT_SERVO_RESET = 0.0;

    // Hardware
    private WPI_TalonFX flywheelMotor = new WPI_TalonFX(RobotMap.flywheelMunchkin);
    private Servo rightServo = new Servo(0);
    private Servo leftServo = new Servo(1);

    /**
     * Creates an Object for the flywheel class.
     */
    public FlywheelMunchkin() {
        flywheelMotor.enableVoltageCompensation(true);
        flywheelMotor.setVoltage(targetVoltage);
        setWheelSpeed(0);
        reset();
        setWheelSpeed(0);
    }

    /**
     * Spins the flywheel motor.
     * 
     * @param v The speed at which the flywheel motor turns.
     */
    @Override
    public void setWheelSpeed(double v) {
        flywheelMotor.set(ControlMode.PercentOutput, v);
    }

    /**
     * Activates the server to push the ball into the flywheel
     */
    @Override
    public void shoot() {
        rightServo.set(RIGHT_SERVO_SHOOT);
        leftServo.set(LEFT_SERVO_SHOOT);
    }

    @Override
    public void reset() {
        rightServo.set(RIGHT_SERVO_RESET);
        leftServo.set(LEFT_SERVO_RESET);
    }

    /**
     * Returns the flywheel's voltage output.
     * 
     * @return The flywheel's voltage output.
     */
    public double getVoltage() {
        return flywheelMotor.getMotorOutputVoltage();
    }
}