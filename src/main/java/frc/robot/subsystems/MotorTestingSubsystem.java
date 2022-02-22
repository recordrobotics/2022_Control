/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class MotorTestingSubsystem extends SubsystemBase {
/**
*   Put methods for controlling this subsystem
*   here. Call these from Commands.
*/ 

CANSparkMax dr1 = new CANSparkMax(1, CANSparkMax.MotorType.kBrushless);



public void motorTestingSubsysytem(){
   
}

public void stopTestMotor(){
    dr1.stopMotor();
    dr1.set(0);
}

public void testMotors(double amount){
    
    System.out.println("testMotor() called with " + amount);
    dr1.set(amount);
    
};

  
}
