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
        SmartDashboard.putData("Move 3ft", new MoveForward(24, 0.2));
        SmartDashboard.putData("Tilt Acquisition", new TiltAcquisition());
        SmartDashboard.putData("Move to 3ft", new MoveToRange(36));
        SmartDashboard.putData("Turn to Goal", new TurnToGoal());
        SmartDashboard.putData("Rotate Lift Supposedly 10 degrees", new RotateToPosition(10));
        SmartDashboard.putData("Lift Lift to 5 abstract units", new RotateToPosition(5));
        m_container = RobotContainer.getInstance();
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Encoder A", m_container.getRangeFinder().getADistance());
        SmartDashboard.putNumber("Encoder B", m_container.getRangeFinder().getBDistance());
    }
}
