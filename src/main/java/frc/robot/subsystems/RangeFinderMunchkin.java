/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Ultrasonic;
import frc.robot.Constants;
import frc.robot.RobotMap;


/**
 * Subsystem class for the RangeFinder
 */
public class RangeFinderMunchkin extends RangeFinder {
	private Ultrasonic rangeFinderA = new Ultrasonic(RobotMap.rangeFinderAPing, RobotMap.rangeFinderAEcho);
	private Ultrasonic rangeFinderB = new Ultrasonic(RobotMap.rangeFinderBPing, RobotMap.rangeFinderBEcho);
	//TODO: Rename rangeFinder's to left and right here and in robotmap
	
  	/**
     * Method that enables the rangefinder
     */
	public RangeFinderMunchkin() {
		System.out.println("range finder");
		rangeFinderA.setEnabled(true);
		rangeFinderB.setEnabled(true);
		Ultrasonic.setAutomaticMode(true);
	}

	/**
	 *
	 * @return range returned in inches
	 */
	public double getDistance() {
		return (rangeFinderA.getRangeMM() + rangeFinderB.getRangeMM())/2;
	}
    /**
     * TODO: Make right and left right and left
     * @return range finder A 
     */
    public double getADistance(){
        return rangeFinderA.getRangeMM();
    }
    /**
     * TODO: Make right and left right and left
     * @return range finder B 
     */
    public double getBDistance(){
        return rangeFinderB.getRangeMM();
    }

}
