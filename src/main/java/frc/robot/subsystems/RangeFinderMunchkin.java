/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Ultrasonic;
import frc.robot.Constants;


/**
 * Subsystem class for the RangeFinder
 */
public class RangeFinderMunchkin extends RangeFinder {
	private Ultrasonic rf = new Ultrasonic(0, 1);

  /**
   * Method that enables the rangefinder
   */
	public RangeFinderMunchkin() {
		rf.setEnabled(true);
		rf.setAutomaticMode(true);
	}

	/**
	*
	* @return range returned in inches
	*/
	public double getDistance() {
	    return rf.getRangeInches();
	}
}
