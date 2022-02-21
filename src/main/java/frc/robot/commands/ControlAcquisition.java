/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.Constants;
import frc.robot.subsystems.Acquisition;
import frc.robot.OI;


public class ControlAcquisition extends CommandBase {
    /**
     * reverseSpinButton Which button lowers the tilt of the aquisition.
     * forwardSpinButton Which button spins the aquisition.
     * tiltUpButton Which button lowers the tilt of the aquisition.
     * tiltDownButton Which button spins the aquisition.
     */
    String forwardSpinButton = "LT";
    String reverseSpinButton = "LB";
    String tiltUpButton = "RSYUP";
    String tiltDownButton = "RSYDOWN";
    /**
     * Constants.SPIN_SPEED This is how fast the aquisition spins.
     */
    private Acquisition m_acquisition = RobotContainer.getInstance().getAcquisition();
    /**
     * Creates a ControlAcquisition object.
     */
    public ControlAcquisition() {
        /** Use requires() here to declare subsystem dependencies*/
        addRequirements(m_acquisition);
    }
    //TODO: FILL IN WITH CORRECT STUFF
    private void controlAcqMunchkin() {
        /**
         * if: spin forward (sucks balls in) when forwardSpinButton is pressed.
         * else if: spin backwards (expels balls out) when reverseSpinButton is pressed.
         * else: stop motor from spinning.
         */
        if (OI.getXboxButtonState(forwardSpinButton)) {
            m_acquisition.moveAcq(Constants.SPIN_SPEED);
        } else if (OI.getXboxButtonState(reverseSpinButton)) {
            m_acquisition.moveAcq(-Constants.SPIN_SPEED);
        } else {
            m_acquisition.moveAcq(0);
        }

        /**
         * if: tilt up when tiltUpButton is pressed.
         * else if: tilt down when tiltDownButton is pressed.
         * else: stop motor from spinning.
         */
        if (OI.getXboxButtonState(tiltUpButton)) {
            m_acquisition.moveTilt(Constants.TILT_SPEED);
        } else if (OI.getXboxButtonState(tiltDownButton)) {
            m_acquisition.moveTilt(-Constants.TILT_SPEED);
        } else {
            m_acquisition.moveTilt(0);
        }
    }
    /**
     * Method to spin and tilt acquisition.
     */
    private void controlAcq2020() {
        //control the acqusition wheels
        /**
         * IF: if the aquisition button is pressed, move the aquisition by Constants.SPIN_SPEED.
         * ELSE IF: if the reverse button is pressed, move the aquisition by Constants.SPIN_SPEED in the other direction.
         * ELSE: the aquisition shouldn't spin if either button is not pressed.
         */
        if (OI.getXboxButtonState(forwardSpinButton)) {
            m_acquisition.moveAcq(Constants.SPIN_SPEED);
        } else if (OI.getXboxButtonState(reverseSpinButton)) {
            m_acquisition.moveAcq(-Constants.SPIN_SPEED);
        } else {
            m_acquisition.moveAcq(0);
        }
        /**
         * IF: if the right bumper is pressed, tilt the aquisition up by Constants.TILT_SPEED.
         * ELSE IF: if the left bumper is pressed, tilt the aquisition down by Constants.TILT_SPEED.
         * ELSE: the aquisition shouldn't tilt if either bumper is not pressed.
         */
        if (OI.getXboxButtonState(tiltUpButton)) {
            m_acquisition.moveTilt(Constants.TILT_SPEED);
        } else if (OI.getXboxButtonState(tiltDownButton)) {
            m_acquisition.moveTilt(-Constants.TILT_SPEED);
        } else {
            m_acquisition.moveTilt(0);
        }
    }

    /** Called just before this Command runs the first time*/
    

    

    /** Called repeatedly when this Command is scheduled to run*/
    @Override
    public void execute() {
        /**control the toggle, this will invert inputPosition when "A" is pressed*/
       switch (Constants.CURRENT_ROBOT) {
      case ROBOT2020:
      controlAcq2020();
        break;
        case MUNCHKIN:
        controlAcqMunchkin();
      default:
        break; }
    }

    /** Make this return true when this Command no longer needs to run execute()*/
    @Override
    public boolean isFinished() {
        return false;
    }

    /** Called once after isFinished returns true*/
    

/**
*     Called when another command which requires one or more of the same
*     subsystems is scheduled to run
*/
    
}