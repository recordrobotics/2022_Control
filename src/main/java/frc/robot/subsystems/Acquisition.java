package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public abstract class Acquisition extends SubsystemBase {
	public abstract boolean getTiltPosition();
	public abstract void setTiltPosition(boolean pos);
	public abstract void moveAcq(double v);
	public abstract void moveTilt(double v);
	public abstract boolean getTiltLimit();
	public abstract boolean isAcqOn();

	public Acquisition() {

	}
	
}
