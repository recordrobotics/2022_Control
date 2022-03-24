package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutoClimb extends SequentialCommandGroup{
    public AutoClimb() {
        addCommands(
            new MoveRotateLift(51, 0.15),
            new MoveCIB(0, 0.5)); //placeholder values
            new MoveRotateLift(0, 0);
    }
    
}
