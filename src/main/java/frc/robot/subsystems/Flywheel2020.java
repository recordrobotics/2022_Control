/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class Flywheel2020 extends Flywheel {
    /**
     * flywheelMotor Creates a motor object for the flywheel motor. targetVoltage
     * The target voltage of the flywheel.
     */
    private int falcon500port = 12;
    private WPI_TalonFX flywheelMotor = new WPI_TalonFX(falcon500port);
    private double targetVoltage = 11.5;

    /**
     * Creates an Object for the flywheel class.
     */
    public Flywheel2020() {
        flywheelMotor.enableVoltageCompensation(true);
        flywheelMotor.setVoltage(targetVoltage);
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

}
