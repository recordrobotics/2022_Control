package frc.robot.subsystems;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.RobotMap;
import frc.robot.Constants;

public class LiftRotater extends SubsystemBase {
    private CANSparkMax robotLiftRotateMotorLeft = new CANSparkMax(RobotMap.robotLiftRotaterLeftMotorPort, MotorType.kBrushless);
    private CANSparkMax robotLiftRotateMotorRight = new CANSparkMax(RobotMap.robotLiftRotaterRightMotorPort, MotorType.kBrushless);
    private double targetVoltage = Constants.liftRotaterTargetVoltage;
    private RelativeEncoder robotLiftRotaterLeftEncoder = robotLiftRotateMotorLeft.getEncoder();

    // true/1 = not pressed; false/0 = pressed
    // When pressed, should stop lift going into that direction
    private DigitalInput forwardLimit = new DigitalInput(RobotMap.rotateLiftForwardLimitSwitch);
    private DigitalInput backwardLimit = new DigitalInput(RobotMap.rotateLiftBackwardLimitSwitch);

    public LiftRotater(){
     // robotLiftMotor.enableVoltageCompensation(true);
     // robotLiftMotor.setVoltage(targetVoltage);
    }
  
    /**
     * Stop the motors
     */
    public void stop() {
        robotLiftRotateMotorLeft.set(0.0);
        robotLiftRotateMotorRight.set(0.0);
    }

    /**
     * Get position from encoder
     * @return position
     */
    public double getPosition(){
        return robotLiftRotaterLeftEncoder.getPosition();
    }

    /**
     * Reset the encoder
     */
    public void resetLeftRotateEncoder(){
        robotLiftRotaterLeftEncoder.setPosition(0);
    }

    /**
     * Rotates lift forward and backwards
     * @param v speed
     */
    public void RotateLift(double v) {
        // System.out.println("LIMIT SWITCH 1: " + forwardLimit.get());
        // System.out.println("LIMIT SWITCH 2: " + backwardLimit.get());

        // System.out.println("left encoder: " + robotLiftRotaterLeftEncoder.getPosition());

        // Positive v = moving towards E-Board
        // Negative v = moving towards Acquisition
        if ((v > 0 && forwardLimit.get()) || (v < 0 && backwardLimit.get())) {
            robotLiftRotateMotorLeft.set(v);
            robotLiftRotateMotorRight.set(-v);
        } else {
            stop();
        }

    }
}