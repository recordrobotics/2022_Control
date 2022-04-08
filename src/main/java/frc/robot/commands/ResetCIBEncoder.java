package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.RobotLift;

public class ResetCIBEncoder extends CommandBase {
	
	private RobotLift m_cib = RobotContainer.getInstance().getRobotLift();

	public ResetCIBEncoder() {
		addRequirements(m_cib);
	}

	@Override
	public void execute() {}

	@Override
	public boolean isFinished() {
		return true;
	}

	@Override
	public void end(boolean interrupted) {
		m_cib.resetEncoder();
	}

}
