package frc.robot.subsystems;

import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj2.command.SubsystemBase;





public abstract class RobotLift extends SubsystemBase {
    public RobotLift() {
        
    }

    public abstract void moveLift(double v);
    public abstract void stop();
    public abstract double getPosition();
    public abstract void resetEncoder();
    public abstract double getVelocity();
}