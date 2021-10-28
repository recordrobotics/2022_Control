package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


public abstract class Dashboard extends SubsystemBase {

    /**
    * displays a certain value on the dashboard under a certain name
    */
    public abstract void periodic();
}