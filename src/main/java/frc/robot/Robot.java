/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
/**
*  Instances for all subsystems.
*  Refer to these objects when interacting with any subsystem object.
*/
//   public static DriveTrain driveTrain;
//   public static RobotLift lift;
//   public static Gyroscope gyro;
//   public static Acquisition acq;
//   public static OI m_oi;
//   public static Flywheel flywheel;
//   public static BallLift belt;
//   public static LiftSpool spool;
//   public static RangeFinder rangeFinder;
//  // public static CamStream camStream = new CamStream(2);
//   public static Dashboard dash;
//   /**Autonomous command setup*/
//   public static Command m_autonomousCommand;
//   SendableChooser<Command> m_chooser = new SendableChooser<>();

//   /**Network table setup*/
//   public static NetworkTableInstance inst;
//   public static NetworkTable table;
//   public static NetworkTableEntry testEntry;
  // TODO: Remove code above

  private RobotContainer m_container;

  public Robot() {
    m_container = RobotContainer.getInstance();
  }

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_oi = new OI();
    m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
    /** chooser.addOption("My Auto", new MyAutoCommand());*/
    SmartDashboard.putData("Auto mode", m_chooser);

    /**select which init method to use based on the currently selected robot*/
    switch(Constants.CURRENT_ROBOT){
      case MONOLITH:
        monolithInit();
        break;
      case MONTY:
        montyInit();
        break;
      case ROBOT2020:
        robot2020Init();
        break;
    }

    networkInit();
  }

  /**calibrate gyroscope*/
  boolean recalibrateGyro = true;

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */

  private boolean prevLampState = false;

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    // m_autonomousCommand = new MoveToFire(shootingDistance); 

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    /** schedule the autonomous command (example)*/
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
/**
*     This makes sure that the autonomous stops running when
*     teleop starts running. If you want the autonomous to
*     continue until interrupted by another command, remove
*     this line or comment it out.
*/
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    CommandScheduler.getInstance().run();
  // System.out.println("forward value" + OI.getForward());

  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
