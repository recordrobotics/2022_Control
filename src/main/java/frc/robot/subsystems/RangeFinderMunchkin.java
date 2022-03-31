// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

// package frc.robot.subsystems;

// import edu.wpi.first.wpilibj.Ultrasonic;
// import frc.robot.Constants;


// /**
//  * Subsystem class for the RangeFinder
//  */
// public class RangeFinderMunchkin extends RangeFinder {
//   /**
//    * factor to convert sensor values to a distance in inches
//    */
//   private Ultrasonic[] rangeFinders = new Ultrasonic[2];
//   /**
//    * Method that enables the rangefinder
//    */
//   public RangeFinderMunchkin() {
//     for (Ultrasonic rf : rangeFinders) {
//       rf.setEnabled(true);
//       rf.setAutomaticMode(true);
//   }

//   /**
//    * @return the range from 0-4095 that is scaled to CM
//    */
//   public double getDistance() {
//     /** System.out.println(m_ultrasonic.getRangeInches()); */
//     return (rangeFinders[0].getRangeMM() + rangeFinders[1].getRangeMM())/200;
//   }
//   /**
//    * 
//    * @param i which rangefinder to use
//    * @return range returned in cm
//    */
//   public double getDistance(int i) {
//     return rangeFinders[i].getRangeMM() / 100;
//   }
//   public double getAngle() {
//     return Math.atan(Constants.DISTANCE_BETWEEN_RANGE_FINDERS / Math.abs(getDistance(0) - getDistance(1)));
//   }

// }
