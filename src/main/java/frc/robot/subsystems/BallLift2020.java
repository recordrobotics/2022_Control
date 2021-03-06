package frc.robot.subsystems;

import frc.robot.RobotMap;  
import edu.wpi.first.wpilibj.DigitalInput;
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;
/**
 * Creates an instance of the ball lift motor
 */
public class BallLift2020 extends BallLift {
  private WPI_VictorSPX ballLiftMotor = new WPI_VictorSPX(RobotMap.ballLiftMotorPort);


  /**array of limit switches that are triggered when a ball occupies it's slot*/
  private DigitalInput[] ballLimits = new DigitalInput[3];
  
  public BallLift2020() {

    
    /**instance of limit switches*/
    int offset = 4;
    for (int i = 0; i < ballLimits.length; i++){
      ballLimits[i] = new DigitalInput(i + offset);
      
    }
   }
  
  
  /**
   * Runs the ball lift at speed v
   * @param v the speed at which the ball lift runs
   */
  public void moveBallLift(double v){
    ballLiftMotor.set(ControlMode.PercentOutput, v);
  }

  /**
   * goes through limit switches starting from the bottom until it finds a full slot
   * @return Number of lowest full slot
   */
  public int lowestFullSlot(){
    int lowest = ballLimits.length - 1;
    for(int i = ballLimits.length - 1; i >= 0; i--){
      if (ballLimits[i].get()){
        lowest = i;
      }
    }
    return lowest; 
  }
  /**
   * goes through limit switches starting from the top until it finds a full slot
   * @return number of highest full slot
   */
  public int highestFullSlot(){
    int highest = 0;
    for(int i = 0; i < ballLimits.length; i++){
      if (ballLimits[i].get()){
        highest = i;
      }
    }
    return highest;
  }
  /**
   * checks each limit switch and check for the total number of full slots
   * @return number of full slots
   */
  public int countBall(){
    int count = 0;

    for (DigitalInput limit : ballLimits){
      if (limit.get()){
        count++;
      }
    }

    return count;
  }  
/**
 * Checks if a given slot is full
 * @param slot the slot being checked
 * @return whether a slot is full or not
 */
  public boolean getSlot(int slot){
    return ballLimits[slot].get();
  }
}
