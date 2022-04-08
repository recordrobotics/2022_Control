package frc.robot.subsystems;
import frc.robot.RobotMap;  

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import frc.robot.commands.*;

public class LiftMonolith extends RobotLift{
/**
* Put methods for controlling this subsystem
*     here. Call these from Commands.
*/
    
    /**Lift for Monolith. Should work.*/
    /**
     * motor Motor for the lift.
     * topLimit The top of the lift.
     * bottomLimit The bottom of the lift.
     */
    Talon motor = new Talon(RobotMap.liftPortMonolith);
    
    DigitalInput topLimit = new DigitalInput(1);
    DigitalInput bottomLimit = new DigitalInput(2);

    public void initDefaultCommand() {
        setDefaultCommand(new ButtonLiftControl());
    }
    /**
     * Moves the lift up and down.
     */
    public void moveLift(double v)
    {
       /* if ((v < 0 & bottomLimit.get()) || (v > 0 & topLimit.get()))
        {
            motor.set(v);
        }*/
    }
    public double getPosition(){
        return 0;
    }
    public void resetEncoder(){
    }
    /**
     * Stops the lift from moving.
     */
    public void stop()
    {
    	motor.stopMotor();
    	motor.set(0.0);
    }
    @Override
    public void moveLeft(double v) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void moveRight(double v) {
        // TODO Auto-generated method stub
        
    }
}