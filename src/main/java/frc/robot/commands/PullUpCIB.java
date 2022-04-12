package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.RobotLift;

public class PullUpCIB extends CommandBase {
	
	private RobotLift m_cib = RobotContainer.getInstance().getRobotLift();
	private double speed;

	public PullUpCIB(double speed) {
		this.speed = speed;
		addRequirements(m_cib);
	}

	/**
	 * Move lift towards 0
	 */
	@Override
	public void execute() {
		m_cib.moveLift(this.speed);
	}

	/**
	 * Finished when encoder value reaches 0
	 */
	@Override
	public boolean isFinished() {
		return (m_cib.getPosition() >= 0);
	}

	/**
	 * Stop the CIBs
	 */
	@Override
	public void end(boolean interrupted) {
		m_cib.moveLift(0);
	}

}
