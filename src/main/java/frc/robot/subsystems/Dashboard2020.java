package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI; // in commented-out code
import frc.robot.commands.*;
import frc.robot.Robot;
import frc.robot.control.ButtonMap; // in commented-out code
import frc.robot.RobotContainer;
import frc.robot.control.ButtonMap;

public class Dashboard2020 extends Dashboard {
    
    private RobotContainer m_container;
    
    /**
    * Creates buttons to execute each of the specified commands at the specified values
    */
    public Dashboard2020(){
        SmartDashboard.putData("Move 3ft", new MoveForward(24, 0.2));
        SmartDashboard.putData("Turn Left", new AutoTurn(-90));
        SmartDashboard.putData("Turn Right", new AutoTurn(90));
        SmartDashboard.putData("Tilt Acquisition", new TiltAcquisition());
        SmartDashboard.putData("Move to 3ft", new MoveToRange(36));
        SmartDashboard.putData("Turn to Goal", new TurnToGoal());
        m_container = RobotContainer.getInstance();
    }

    @Override
    public void periodic() {
        /**
        *   SmartDashboard.putNumber("Right Encoder", Robot.driveTrain.getRightEncoder());
        *   SmartDashboard.putNumber("Left Encoder", Robot.driveTrain.getLeftEncoder());
        */
        SmartDashboard.putNumber("Gyro Angle", m_container.getGyro().getDeg());
        /**SmartDashboard.putNumber("Flywheel Speed", Robot.flywheel.getSpeed());*/
        
        SmartDashboard.putNumber("Range Found", m_container.getRangeFinder().getDistance());
        /**
        *    SmartDashboard.putBoolean("Green Button", OI.getPanelButtonState(ButtonMap.liftRaise));
        *    SmartDashboard.putBoolean("Bottom Ball Lift", Robot.belt.getSlot(0));
        *   SmartDashboard.putBoolean("Middle Ball Lift", Robot.belt.getSlot(1));
        *    SmartDashboard.putBoolean("Top Ball Lift", Robot.belt.getSlot(2));
        */
    
        SmartDashboard.putNumber("Flywheel Voltage", m_container.getFlywheel().getVoltage());
       /** SmartDashboard.putNumber("Balls In Lift", Robot.belt.countBall());*/
    }
}
