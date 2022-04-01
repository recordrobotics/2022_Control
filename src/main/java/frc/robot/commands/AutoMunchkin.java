/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutoMunchkin extends SequentialCommandGroup {
  public AutoMunchkin() {
    /** Use robot container to declare the subsytem's default command */
    addCommands(
        new MoveForward(40, 0.2),
        new TiltAcquisition(),
        new FlywheelAutoRun() // Literally just to test if this works 
        // TODO: Someone should *probably* actually implement proper distance detection along with proper implementation
        );
  }

}
