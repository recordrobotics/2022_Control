package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public abstract class BallLift extends SubsystemBase {
    
    public BallLift() {
        
    }

    public abstract void moveBallLift(double v);
    public abstract int lowestFullSlot();
    public abstract int highestFullSlot();
    public abstract int countBall();
    public abstract boolean getSlot(int slot);
}