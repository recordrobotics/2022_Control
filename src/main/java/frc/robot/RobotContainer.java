// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private static RobotContainer m_RobotContainer;

  // Robot Subsystems
  private DriveTrain m_driveTrain = null;
  private RobotLift m_robotLift = null;
  private Gyroscope m_gyro = null;
  private Acquisition m_acquisition = null;
  private OI m_oi = null;
  private Flywheel m_flywheel = null;
  private BallLift m_ballLift = null;
  private LiftSpool m_liftSpool = null;
  private RangeFinder m_rangeFinder = null;
  private Dashboard m_dashboard = null;
  private CamStream m_camStream = new CamStream(2);

  //private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    switch (Robot.currentRobot) {
      case ROBOT2020:
        this.init2020();
        break;
      case MONOLITH:
        this.initMonolith();
        break;
      case MONTY:
        this.initMonty();
        break;
    }

    // Configure the button bindings
    configureButtonBindings();
  }

  private void init2020() {
    m_driveTrain = new Drive2020();
    m_driveTrain.setDefaultCommand(new ManualDrive());
    m_gyro = new Gyro2020();
    // TODO: move gyroInit();
    // gyroInit();
    m_acquisition = new Acquisition2020();
    m_acquisition.setDefaultCommand(new ControlAcquisition());
    m_flywheel = new Flywheel2020();
    m_flywheel.setDefaultCommand(new ControlFlywheel());
    m_ballLift = new BallLift2020();
    m_ballLift.setDefaultCommand(new BeltControl());
    //spool = new LiftSpool();
    //lift = new RobotLift2020();
    m_rangeFinder = new RangeFinder2020();
    //dash = new Dashboard2020();
  }

  // Legacy code for monolith
  private void initMonolith() {
    // TODO: implement
  }

  // Legacy code for monty
  private void initMonty() {
    // TODO: implement
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return Robot.m_autonomousCommand;
  }

  public static RobotContainer getInstance() {
    if (m_RobotContainer == null) m_RobotContainer = new RobotContainer();
    return m_RobotContainer;
  } 
}
