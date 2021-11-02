// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    /**
    * The robot currently selected
    */
    public final static RobotModel CURRENT_ROBOT = RobotModel.ROBOT2020;

    public static final double RESTING_VOLTAGE = 12.5d;
    public static final double SHOOTING_DISTANCE = 122d;
    public static final double FLYWHEEL_SPEED = 0.85d;
    //for AutoTurn.java
    public static final double PRECISION = 0.5d;
    //for BallUpOne.java
    public static final double MOVE_TIME = 0.1d;
    //for BeltAutoRun.java
    public static final double BALL_TIMEOUT = 5.0d;
    //for CamControl.java
    public static final String SWITCH_BUTTON = "Y";
    //for ControlAcquisition.java
    public static final double ACQ_SPEED = -0.5d;
    //for ControlFlywheel.java
    public static final boolean USE_XBOX_CONTROLLER = true;
    public static final String XBOX_BUTTON = "X";
    public static final int PANEL_BUTTON = 6;
    //for ControlSpool.java
    public static final double SPOOL_SPEED = 0.5d;
    //for LiftControl.java
    public static final double SPEED = 0.8d;
    //for ManualDrive.java
    public static final double TURN_MULTIPLIER = 0.67d;
    public static final double FORWARD_MULTIPLIER = 0.6d;
    //for MoveToAim.java, MoveToFire.java
    public static final double CAMERA_OFF_CENTER = 5.25d;
    //for MoveToRange.java, TurnToAngle.java, TurnToGoal.java
    public static final double TOLERANCE = 3.0d;
    public static final double KI = 0.0d, KD = 0.0d;
    //for TiltAcquisition.java
    public static final double ACQ_MOVE_TIME = 2.5d;
}
