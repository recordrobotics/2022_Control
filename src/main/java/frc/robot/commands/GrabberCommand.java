package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.RobotContainer;
import frc.robot.subsystems.AcquisitionMonolith;

public class GrabberCommand extends CommandBase{

    private AcquisitionMonolith m_aquisition = (AcquisitionMonolith) RobotContainer.getInstance().getAcquisition();
    private OI m_oi = RobotContainer.getInstance().getOi();

    public GrabberCommand() {
      addRequirements(m_aquisition);
    }
    
    /** Called just before this Command runs the first time */
    @Override
    public void initialize() {
      m_aquisition.stopMotors();
      m_aquisition.setGrabSolenoidOff();
    }
  
    /** Called repeatedly when this Command is scheduled to run */
    @Override
    public void execute() {
      double maxGrabberSpeed = 1d;

      // TODO: implement
    }
  
    /** Make this return true when this Command no longer needs to run execute() */
    @Override
    public boolean isFinished() {
      return false;
    }
  
    /** Called once after isFinished returns true */
    @Override
    public void end(boolean interrupted) {
      m_aquisition.stopMotors();
      m_aquisition.setGrabSolenoidOff();
    }
}
