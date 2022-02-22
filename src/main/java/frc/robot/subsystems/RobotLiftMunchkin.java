/*Info on Robot Lift:
1 CIM - + and - (circular) direction, possible neutral (spins freely)
1 MINI CIM - + and - (circular) direction
Both motor control different systems
Possible thought of combining both lifts
package frc.robot.subsystems;*/
package frc.robot.subsystems;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.AnalogEncoder;
import com.ctre.phoenix.motorcontrol.*;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.RobotMap;
import frc.robot.Constants;

public class RobotLiftMunchkin extends RobotLift{
    private CANSparkMax robotLiftRotateMotorLeft = new CANSparkMax(RobotMap.robotLiftLeftMotorPort, MotorType.kBrushless);
    private CANSparkMax robotLiftRotateMotorRight = new CANSparkMax(RobotMap.robotLiftLeftMotorPort, MotorType.kBrushless);
    private CANSparkMax robotLiftVerticalMotorLeft = new CANSparkMax(RobotMap.robotLiftLeftMotorPort, MotorType.kBrushless);
    private CANSparkMax robotLiftVerticalMotorRight = new CANSparkMax(RobotMap.robotLiftLeftMotorPort, MotorType.kBrushless);
    private double targetVoltage = Constants.robotLiftTargetVoltage;
    private MotorControllerGroup robotLiftRotateMotors = new MotorControllerGroup(robotLiftRotateMotorLeft, robotLiftRotateMotorRight);
    private MotorControllerGroup robotLiftVerticalMotors = new MotorControllerGroup(robotLiftVerticalMotorLeft, robotLiftVerticalMotorRight);
    public RobotLiftMunchkin(){
     // robotLiftMotor.enableVoltageCompensation(true);
     // robotLiftMotor.setVoltage(targetVoltage);
    }
    /**
     * robotLiftMotorLeft creates variable for the left lift motor.
     * stop() stops the motor.
     */
  

    public void stop() {

        robotLiftRotateMotors.stopMotor();
        robotLiftVerticalMotors.stopMotor();

        robotLiftRotateMotors.set(0.0);
        robotLiftVerticalMotors.set(0.0);
    }
    public double getPosition(){
        return liftEncoder.get();
    }
    /**
     * moveLift() moves lift up and down.
     * @param v how fast the left lift motor spins.
     */
    public void moveLift(double v) {

    }
}