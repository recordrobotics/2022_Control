package frc.robot.subsystems;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.RobotMap;
import frc.robot.Constants;

public class LiftRotater extends SubsystemBase{
    private CANSparkMax robotLiftRotateMotorLeft = new CANSparkMax(RobotMap.robotLiftRotaterLeftMotorPort, MotorType.kBrushless);
    private CANSparkMax robotLiftRotateMotorRight = new CANSparkMax(RobotMap.robotLiftRotaterRightMotorPort, MotorType.kBrushless);
    private double targetVoltage = Constants.liftRotaterTargetVoltage;
    private RelativeEncoder robotLiftRotaterLeftEncoder = robotLiftRotateMotorLeft.getEncoder();
    public LiftRotater(){
     // robotLiftMotor.enableVoltageCompensation(true);
     // robotLiftMotor.setVoltage(targetVoltage);
    }
    /**
     * robotLiftMotorLeft creates variable for the left lift motor.
     * stop() stops the motor.
     */
  

    public void stop() {

        robotLiftRotateMotorLeft.stopMotor();
        robotLiftRotateMotorLeft.set(0.0);
        robotLiftRotateMotorRight.stopMotor();
        robotLiftRotateMotorRight.set(0.0);
    }
    public double getPosition(){
        return robotLiftRotaterLeftEncoder.getPosition();
    }
    public void resetLeftRotateEncoder(){
        robotLiftRotaterLeftEncoder.setPosition(0);
    }
    /**
     * moveLift() moves lift up and down.
     * @param v how fast the left lift motor spins.
     */
    public void RotateLift(double v) {
        robotLiftRotateMotorLeft.set(v);
        robotLiftRotateMotorRight.set(-v);
    }
}