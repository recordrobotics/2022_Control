package frc.robot.subsystems;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.RobotMap;
import frc.robot.Constants;

public class RobotLiftMunchkin extends RobotLift{
    private CANSparkMax robotLiftVerticalMotorLeft = new CANSparkMax(RobotMap.robotLiftMunchkinLeftMotorPort, MotorType.kBrushless);
    private CANSparkMax robotLiftVerticalMotorRight = new CANSparkMax(RobotMap.robotLiftMunchkinRightMotorPort, MotorType.kBrushless);
    private MotorControllerGroup robotLiftVerticalMotors = new MotorControllerGroup(robotLiftVerticalMotorLeft, robotLiftVerticalMotorRight);
    
    private double targetVoltage = Constants.robotLiftTargetVoltage;
    
    public RobotLiftMunchkin() {
     // robotLiftMotor.enableVoltageCompensation(true);
     // robotLiftMotor.setVoltage(targetVoltage);
    }

    /**
     * robotLiftMotorLeft creates variable for the left lift motor.
     * stop() stops the motor.
     */
    public void stop() {
        robotLiftVerticalMotors.stopMotor();
        robotLiftVerticalMotors.set(0.0);
    }

    public double getPosition() {
        //liftEncoder.get();
        return 0;
    }

    /**
     * moveLift() moves lift up and down.
     * @param v how fast the lift motors spins.
     */
    public void moveLift(double v) {
        robotLiftVerticalMotors.set(v);
    }
}