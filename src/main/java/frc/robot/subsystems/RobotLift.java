package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;





public abstract class RobotLift extends SubsystemBase {
    public RobotLift() {
       // this.setDefaultCommand(new LiftControl());
    }

    public abstract void moveLift(double v);
    public abstract void stop();
}