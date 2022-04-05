package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.LiftRotater;

public class ResetLift extends CommandBase {

	private LiftRotater m_rotater = RobotContainer.getInstance().getRotater();
	private double speed;

	public ResetLift(double speed) {
		this.speed = speed;
		addRequirements(m_rotater);
	}

	/**
	 * Keep moving lift towards E-Board 
	 */
	@Override
	public void execute() {
		System.out.println("reset lift execute");
		m_rotater.rotateLift(this.speed);
	} 

	/**
	 * Finished when limit switch is hit
	 */
	@Override
	public boolean isFinished() {
		return !m_rotater.getFwdLimit();
	}

	/**
	 * At the end reset the encoder value
	 */
	@Override
	public void end(boolean interrupted) {
		m_rotater.rotateLift(0);
		m_rotater.resetEncoders();
	}

}
