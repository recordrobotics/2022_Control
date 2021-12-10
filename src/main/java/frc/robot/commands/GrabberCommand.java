package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.RobotContainer;
import frc.robot.subsystems.AcquisitionMonolith;

public class GrabberCommand extends CommandBase{
    private AcquisitionMonolith m_aquisition = (AcquisitionMonolith) RobotContainer.getInstance().getAcquisition();

    public GrabberCommand() {
      addRequirements(m_aquisition);
    }
    
    /** Called just before this Command runs the first time */
    @Override
    public void initialize() {
      
    }
  
    /** Called repeatedly when this Command is scheduled to run */
    @Override
    public void execute() {
    }
  
    /** Make this return true when this Command no longer needs to run execute() */
    @Override
    public boolean isFinished() {
      return false;
    }
  
    /** Called once after isFinished returns true */
    @Override
    public void end(boolean interrupted) {
    }
}
