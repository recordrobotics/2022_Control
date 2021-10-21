// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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

  private static RobotContainer m_robotContainer;

  // Robot Subsystems
  private DriveTrain m_driveTrain;
  private RobotLift m_robotLift;
  private Gyroscope m_gyro;
  private Acquisition m_acquisition;
  private OI m_oi;
  private Flywheel m_flywheel;
  private BallLift m_ballLift;
  private LiftSpool m_liftSpool;
  private RangeFinder m_rangeFinder;
  private Dashboard m_dashboard;
  private CamStream m_camStream = new CamStream(2);
  private Command m_autonomousCommand;
  private SendableChooser<Command> m_chooser = new SendableChooser<>();

  // Network table setup
  private NetworkTableInstance m_netTableInst;
  private NetworkTable m_netTable;
  private NetworkTableEntry m_netTableEntry;

  //private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    m_oi = new OI();
    m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
    /** chooser.addOption("My Auto", new MyAutoCommand());*/
    SmartDashboard.putData("Auto mode", m_chooser);
    
    // Init based on the current robot
    switch (Constants.CURRENT_ROBOT) {
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
    this.configureButtonBindings();
  }

  /**
   * Init function for robot 2020
   * Makes instnaces of all 2020-specific subsystems and assigns them to appropriate variables
   */
  private void init2020() {
    m_driveTrain = new Drive2020();
    m_driveTrain.setDefaultCommand(new ManualDrive());
    m_gyro = new Gyro2020();
    this.gyroInit();
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

  // Legacy code for Monolith
  /**
   * Init function for Monolith
   * Makes instnaces of all Monolith-specific subsystems and assigns them to appropriate variables
   */
  private void initMonolith() {
    m_driveTrain = new DriveMonolith();
    System.out.println("Monolith Initialized");
    /**Lift constructor*/
    m_robotLift = new LiftMonolith();
    /**gyro*/
    m_gyro = new GyroMonolith();  
    this.gyroInit();
    //dash = new DashboardMonolith();
  }

  // Legacy code for Monty
  /**
   * Init function for Monty
   * Makes instnaces of all Monty subsystems and assigns them to appropriate variables
   */
  private void initMonty() {
    m_driveTrain = new DriveMonty();
  }

  /**
   * Setup for Gyroscope. Zero the gyroscope, and calibrate it
   */
  private void gyroInit(){
    m_gyro.gyroCalib();
    System.out.println("Please wait... Calibrating Gyroscope");
    Timer.delay(5);
    System.out.println("Calibration Complete");
    m_gyro.gyroReset();
  }

  /**
   * Make new instance of the DataTable used
   * Get the main entry in the data
   */
  private void networkInit(){
    m_netTableInst = NetworkTableInstance.getDefault();
    m_netTable = m_netTableInst.getTable("datatable");
    m_netTableEntry = m_netTable.getEntry("Test");
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return m_autonomousCommand;
  }

  // Return container instance. Create if doesn't exist
  public static RobotContainer getInstance() {
    if (m_robotContainer == null) m_robotContainer = new RobotContainer();
    return m_robotContainer;
  } 
}
