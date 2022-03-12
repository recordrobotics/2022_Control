package frc.robot.subsystems;

import frc.robot.RobotMap;  
import edu.wpi.first.wpilibj.DigitalInput;
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
/**
 * Creates an instance of the ball lift motor
 */
public class BallLiftMunchkin extends BallLift {
  private CANSparkMax ballLiftMotor = new CANSparkMax(RobotMap.ballLiftMotorPort, MotorType.kBrushed);

  
  public BallLiftMunchkin() {

    
   }
  
  
  /**
   * Runs the ball lift at speed v
   * @param v the speed at which the ball lift runs
   */
  public void moveBallLift(double v){
    ballLiftMotor.set(v);
  }

  /**
   * goes through limit switches starting from the bottom until it finds a full slot
   * @return Number of lowest full slot
   */
  public int lowestFullSlot(){
    return 0;
  }
  /**
   * goes through limit switches starting from the top until it finds a full slot
   * @return number of highest full slot
   */
  public int highestFullSlot(){
    return 0;
  }
  /**
   * checks each limit switch and check for the total number of full slots
   * @return number of full slots
   */
  public int countBall(){
    return 0;
  }  
/**
 * Checks if a given slot is full
 * @param slot the slot being checked
 * @return whether a slot is full or not
 */
  public boolean getSlot(int slot){
    return false;
  }
}
