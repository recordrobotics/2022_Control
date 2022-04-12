/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class GetBallMunchkin extends SequentialCommandGroup {
  /**
   * distanceToBall the distance the ball is from the robot's starting position (front of base); will be refined on Saturday. TODO: set this
   */
  private final double distanceToBall = 0;


  /**
   * GetBallMunchkin() Moves the robot to a ball.
   */
  public GetBallMunchkin(){





    addCommands(
      new TiltAcquisition(),
      new MoveToRange(distanceToBall)
    );
  }

}
