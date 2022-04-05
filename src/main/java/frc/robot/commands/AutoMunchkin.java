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
      // new MoveToRange(LOW_TARGET),
      // new MoveForward(40, 0.5),
      // new FlywheelAutoRun(),
      // new TiltAcquisition(),
      // new ResetLift(0.5)
      // new PullUpCIB(0.5)
      new ResetLift(0.5),
      new LiftToPosition(-42)
    );
      //TODO: Set the distance the robot shoots from
        // new MoveToRange(LOW_TARGET),
        //TODO: Test the flywheel running command properly
        // new FlywheelAutoRun(),
  }

}
