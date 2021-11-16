package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;





public abstract class RobotLift extends SubsystemBase {
    public RobotLift() {
        
    }

    public abstract void moveLift(double v);
    public abstract void stop();
}