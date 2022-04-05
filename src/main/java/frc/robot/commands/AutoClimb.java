package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutoClimb extends SequentialCommandGroup {

    private static final double CIB_TARGET = 10;
    private static final double ROTATE_TARGET = 25;

    public AutoClimb() {
        addCommands(
            // reset lift
            new ResetLift(0.5),
            // pull up CIB
            new PullUpCIB(0.5),
            // rotate lift to target
            new LiftToPosition(-42)
            // lift to bar

            // get hooks off bar

            // rotate lift to target

            // extend hooks to target

            // rotate lift to bar

            // pull up hooks

            // goto 20

            // new MoveRotateLift(51, 0.15),
            // new MoveCIB(0, 0.5)); //placeholder values
            // new MoveRotateLift(0, 0);
        );
    }
    
}
