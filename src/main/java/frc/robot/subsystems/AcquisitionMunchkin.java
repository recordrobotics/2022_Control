/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.RobotMap;
//import frc.robot.Constants;

//import com.ctre.phoenix.motorcontrol.*;
//import com.ctre.phoenix.motorcontrol.can.*;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class AcquisitionMunchkin extends Acquisition {
    /**
     * aquireMotor tiltMotor Creating variables for the acquisition's motors.
     * tiltLimit The maximum angle the acquisition can be at (to avoid unwanted accidents with the acquisition hitting something).
     * tiltPostition Whether the aquisition is up or down.
     */

    private CANSparkMax acquireMotor = new CANSparkMax(RobotMap.acqSpinMotorPort, MotorType.kBrushless);
    private CANSparkMax tiltMotor = new CANSparkMax(RobotMap.acqTiltMotorPort, MotorType.kBrushed);
    //private double aquireMotorVoltage = Constants.Acq2020AcquireMotorVoltage;
    //private double tiltMotorVoltage = Constants.Acq2020TiltMotorVoltage;

    private CANSparkMax ballChannelMotor = new CANSparkMax(RobotMap.ballChannelMotorPort, MotorType.kBrushless);

    DigitalInput tiltLimit = new DigitalInput(RobotMap.acqTiltLimitSwitch);;

    boolean tiltPosition = true;  /**true is up, false is down*/
    
    /**
     * Creates an acquisition object with a specific tilt limit.
     */
    public AcquisitionMunchkin(){
        ballChannelMotor.set(0);
        acquireMotor.set(0);
        tiltMotor.set(0);
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
        ballChannelMotor.set(-v * 5 / 3);
        acquireMotor.set(v);
    }

    /**
     * Moves the acquisition up and down.
     * @param v speed of the motor.
     */
    public void moveTilt(double v) {
        System.out.println(tiltLimit.get());
        // if ((v < 0 && tiltLimit.get()) || v > 0 ) {
            tiltMotor.set(v);
        // } else {
            // tiltMotor.set(0);
        // }
    }

    /**
     * Returns how far the acquisition can tilt.
     * @return the value of the acq limit switch
     */
    public boolean getTiltLimit(){
        // return tiltLimit.get();
        return true;
     }

    /**
     * Returns if the acqusition is spinning.
     * @return is the motor running.
     */
    public boolean isAcqOn(){
        return acquireMotor.get() > 0;
    }
    
    //TODO: make sure these get the proper value if we use them
    public double getAcquireVoltage(){
        return acquireMotor.getVoltageCompensationNominalVoltage();
    }

    public double getTiltVoltage(){
        return tiltMotor.getVoltageCompensationNominalVoltage();
    }
}
