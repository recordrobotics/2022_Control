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
        SmartDashboard.putData("Rotate Lift Supposedly 10 degrees", new RotateToPosition(10));
        SmartDashboard.putData("Lift Lift to 5 abstract units", new RotateToPosition(5));
        SmartDashboard.putData("Reset CIB Encoder", new ResetCIBEncoder());
        SmartDashboard.putData("Run Full Lift Auto Sequence (without traversal)", new AutoClimb(ClimbEnum.HIGH));
        SmartDashboard.putData("Run Full Lift Auto Sequence (with traversal)", new AutoClimb(ClimbEnum.TRAVERSAL));
        m_container = RobotContainer.getInstance();

    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Range Finder Right ", m_container.getRangeFinder().getADistance());
        SmartDashboard.putNumber("Range Finder Left ", m_container.getRangeFinder().getBDistance());

        SmartDashboard.putNumber("Left Drive Encoders", m_container.getDriveTrain().getLeftEncoder());
        SmartDashboard.putNumber("Right Drive Encoders", m_container.getDriveTrain().getRightEncoder());
        SmartDashboard.putNumber("Lift Encoder Value", m_container.getRotater().getPosition());
        SmartDashboard.putNumber("CIB Encoder Value", m_container.getRobotLift().getPosition());
        SmartDashboard.putBoolean("Ball in Flywheel", m_container.getFlywheel().getBallDetector());
    }

    public double getCIB() {
        return SmartDashboard.getNumber("CIB RESET (0 = both, 1 = left, 2 = right)", 0.0);
    }
}
