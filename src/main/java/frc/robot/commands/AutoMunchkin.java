/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;

public class AutoMunchkin extends SequentialCommandGroup {
  public AutoMunchkin() {
    /** Use robot container to declare the subsytem's default command */
    addCommands(
      //TODO: Set the distance the robot shoots from
        new MoveToRange(Constants.MUNCHKIN_SHOOTING_DISTANCE),
        //TODO: Test the flywheel running command properly
        new FlywheelAutoRun(),
        new TiltAcquisition());
  }

}
