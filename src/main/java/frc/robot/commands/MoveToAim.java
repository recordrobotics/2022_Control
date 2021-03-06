/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class MoveToAim extends SequentialCommandGroup {
    /**
     * Constants.CAMERA_OFF_CENTER How far away the camera is from the center of the robot.
     * targetAngle The angle the robot needs to face in order to shoot at the goal.
     */
    double targetAngle;
    /**
     * MoveToAim() Moves the robot so that it can fire.
     * @param firingDistance How far we have to stand in order to shoot the ball into the slot.
     */
    public MoveToAim(double firingDistance){


        if (Constants.CAMERA_OFF_CENTER != 0){
            targetAngle = (90 - Math.toDegrees(Math.atan(firingDistance / Constants.CAMERA_OFF_CENTER)));
            targetAngle = (int)(targetAngle + 0.5);

            if (targetAngle > 0){
                targetAngle = -targetAngle;
            }
            System.out.println(targetAngle);
        }
        else {
            targetAngle = 0;
        }

        addCommands(
            new TurnToGoal(targetAngle),
            new TurnToGoal(targetAngle),
            new MoveToRange(firingDistance),
            new TurnToGoal(targetAngle)
        );
        
    }
}