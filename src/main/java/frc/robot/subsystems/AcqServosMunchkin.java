/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class AcqServosMunchkin extends SubsystemBase {
/**
*   Put methods for controlling this subsystem
*   here. Call these from Commands.
*/
    private Servo acqServo1 = new Servo(1);
    private Servo acqServo2 = new Servo(2);
    public AcqServosMunchkin(){
    }
    public void setServos(double v){
    acqServo1.set(v);
    acqServo2.set(v);
    }
  
}
