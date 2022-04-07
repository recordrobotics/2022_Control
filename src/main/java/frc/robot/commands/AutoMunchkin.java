/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutoMunchkin extends SequentialCommandGroup {
  
  private static final double LOW_TARGET = 15.0;

  public AutoMunchkin() {
    addCommands(
      //move to distance to shoot
      new MoveToRange(LOW_TARGET),
      // run the flywheel to shoot
      new FlywheelAutoRun(),
      // move the robot backwards to get out of the way
      new MoveForward(-120, 0.4),
      // move the acquisition down
      new TiltAcquisition()
    );
      //TODO: Set the distance the robot shoots from
        // new MoveToRange(LOW_TARGET),
  }

}
