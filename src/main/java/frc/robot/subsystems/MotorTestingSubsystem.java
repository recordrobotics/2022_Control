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
public void motorTestingSubsysytem(){
    dr1.stopMotor();
    dr2.stopMotor();
    dr3.stopMotor();
}
CANSparkMax dr1 = new CANSparkMax(1, CANSparkMax.MotorType.kBrushed);
CANSparkMax dr2 = new CANSparkMax(2, CANSparkMax.MotorType.kBrushed);
CANSparkMax dr3 = new CANSparkMax(3, CANSparkMax.MotorType.kBrushed);
public void testMotors(double amount){
dr1.set(amount);
dr2.set(amount);
dr3.set(amount);
};

  
}
