package frc.robot.subsystems;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;


import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.RobotMap;
import frc.robot.Constants;

public class CIBMunchkin extends RobotLift{
    private CANSparkMax cibMotorLeft = new CANSparkMax(RobotMap.cibLeftMotorPort, MotorType.kBrushless);
    private CANSparkMax cibMotorRight = new CANSparkMax(RobotMap.cibRightMotorPort, MotorType.kBrushless);
    private MotorControllerGroup cibMotors = new MotorControllerGroup(cibMotorLeft, cibMotorRight);
    private RelativeEncoder cibEncoder = cibMotorLeft.getEncoder();
    private double targetVoltage = Constants.robotLiftTargetVoltage;

    public CIBMunchkin(){
    
     // robotLiftMotor.enableVoltageCompensation(true);
     // robotLiftMotor.setVoltage(targetVoltage);
    }

    /**
     * robotLiftMotorLeft creates variable for the left lift motor.
     * stop() stops the motor.
     */
    public void stop() {
        cibMotors.stopMotor();
        cibMotors.set(0.0);
    }

    public double getPosition(){
        return cibEncoder.getPosition();
    }
    public void resetEncoder(){
        cibEncoder.setPosition(0);
    }

    /**
     * moveLift() moves lift up and down.
     * @param v how fast the lift motors spins.
     */
    public void moveLift(double v) {
        cibMotors.set(v);
    }
}