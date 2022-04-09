package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutoClimb extends SequentialCommandGroup {

    private static final double CIB_TARGET = 10;
    private static final double ROTATE_TARGET = 25;

    public AutoClimb(ClimbEnum type) {
        System.out.println("AUTOCLIMB STARTS!!! ");
        switch (type) {
            case HIGH:
                addCommands(
                    // reset lift
                    new ResetLift(0.5),
                    // pull up CIB
                    new PullUpCIB(0.7),
                    // rotate lift to target
                    new LiftToPosition(-42),
                    // lift to bar
                    new MoveCIB(-50, -0.7),
                    // rotate lift to target
                    new LiftToPosition(-96),
                    // extend hooks to target
                    new MoveCIB(-390, -0.7),
                    // rotate lift to bar
                    new LiftToPosition(-83),
                    // pull up hooks
                    new MoveCIB(-250, -0.7),
                    // pull up rotator
                    new ResetLift(0.5),
                    new PullUpCIB(0.7),
                    new LiftToPosition(-42),
                    new MoveCIB(-50, -0.7)

                    // new MoveRotateLift(51, 0.15),
                    // new MoveCIB(0, 0.5)); //placeholder values
                    // new MoveRotateLift(0, 0);
                );
                break;
            case TRAVERSAL:
                addCommands(
                    // reset lift
                    new ResetLift(0.5),
                    // pull up CIB
                    new PullUpCIB(0.7),
                    // rotate lift to target
                    new LiftToPosition(-42),
                    // lift to bar
                    new MoveCIB(-50, -0.7),
                    // rotate lift to target
                    new LiftToPosition(-96),
                    // extend hooks to target
                    new MoveCIB(-390, -0.7),
                    // rotate lift to bar
                    new LiftToPosition(-83),
                    // pull up hooks
                    new MoveCIB(-250, -0.7),
                    // pull up rotator
                    new ResetLift(0.7),
                    new PullUpCIB(0.7),
                    new LiftToPosition(-42),
                    new MoveCIB(-50, -0.7),
                    new LiftToPosition(-42),
                    // lift to bar
                    new MoveCIB(-50, -0.2),
                    // rotate lift to target
                    new LiftToPosition(-96),
                    // extend hooks to target
                    new MoveCIB(-380, -0.2),
                    // rotate lift to bar
                    new LiftToPosition(-83),
                    // pull up hooks
                    new MoveCIB(-250, -0.2),
                    // pull up rotator
                    new ResetLift(0.4),
                    new PullUpCIB(0.2),
                    new LiftToPosition(-42),
                    new MoveCIB(-50, -0.2)
                    // new MoveRotateLift(51, 0.15),
                    // new MoveCIB(0, 0.5)); //placeholder values
                    // new MoveRotateLift(0, 0);
                );
                break;
            default:
                break;
        }
    }
    
}
