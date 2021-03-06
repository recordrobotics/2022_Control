/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.RobotMap;
import frc.robot.commands.ControlAcquisition; // in commented-out code
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;

public class Acquisition2020 extends Acquisition {
    /**
     * aquireMotor tiltMotor Creating variables for the acquisition's motors.
     * tiltLimit The maximum angle the acquisition can be at (to avoid unwanted accidents with the acquisition hitting something).
     * tiltPostition Whether the aquisition is up or down.
     */

    private WPI_VictorSPX acquireMotor = new WPI_VictorSPX(RobotMap.acquireMotorPort);
    private WPI_VictorSPX tiltMotor = new WPI_VictorSPX(RobotMap.tiltMotorPort);
    private double aquireMotorVoltage = Constants.Acq2020AcquireMotorVoltage;
    private double tiltMotorVoltage = Constants.Acq2020TiltMotorVoltage;
    DigitalInput tiltLimit;


    boolean tiltPosition = true;  /**true is up, false is down*/
    /**
     * Creates an acquisition object with a specific tilt limit.
     */
    public Acquisition2020(){
        tiltLimit = new DigitalInput(7);
    }
    /**
     * Gets where the acquisition is in its tilt path.
     * @return returns said position.
     */
    public boolean getTiltPosition() {
        return tiltPosition;
    }
    /**
     * Sets the acquisition's tilt.
     * @param pos whether the tilt should be up or down.
     */
    public void setTiltPosition(boolean pos){
        tiltPosition = pos;
    }
    /**
     * Spins the acquisition motor.
     * @param v speed to spin the acquisition at.
     */
    public void moveAcq(double v) {
        acquireMotor.set(ControlMode.PercentOutput, v);
    }
    /**
     * Moves the acquisition up and down.
     * @param v speed of the motor.
     */
    public void moveTilt(double v) {
        tiltMotor.set(ControlMode.PercentOutput, v);
    }
    /**
     * Returns how far the acquisition can tilt.
     * @return how far the acquisition can tilt.
     */
    public boolean getTiltLimit(){
        return tiltLimit.get();
     }
     /*
    public double getAngle(){
        return acqEncoder.get() * 360/174.9;
    }
    */
    /**
     * Returns if the acqusition is spinning.
     * @return is the motor running.
     */
    public boolean isAcqOn(){
        return acquireMotor.get() > 0;
    }
    
    
    public double getAcquireVoltage(){
        return acquireMotor.getMotorOutputVoltage();
    }
    public double getTiltVoltage(){
        return tiltMotor.getMotorOutputVoltage();
    }
}