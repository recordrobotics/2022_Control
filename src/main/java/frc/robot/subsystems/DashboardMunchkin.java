package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.*;
import frc.robot.RobotContainer;

public class DashboardMunchkin extends Dashboard {
    
    private RobotContainer m_container;
    
    /**
    * Creates buttons to execute each of the specified commands at the specified values
    */
    public DashboardMunchkin(){
        SmartDashboard.putData("Tilt Acquisition", new TiltAcquisition());
        SmartDashboard.putData("Move to 3ft", new MoveToRange(36));
        SmartDashboard.putData("Turn to Goal", new TurnToGoal());
        m_container = RobotContainer.getInstance();

    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Range Finder Right ", m_container.getRangeFinder().getADistance());
        SmartDashboard.putNumber("Range Finder Left ", m_container.getRangeFinder().getBDistance());

        SmartDashboard.putNumber("Left Drive Encoders", m_container.getDriveTrain().getLeftEncoder());
        SmartDashboard.putNumber("Right Drive Encoders", m_container.getDriveTrain().getRightEncoder());

        SmartDashboard.putBoolean("Ball in Flywheel", m_container.getFlywheel().getBallDetector());
    }
}
