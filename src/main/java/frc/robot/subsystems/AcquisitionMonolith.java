package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import frc.robot.RobotMap;

public class AcquisitionMonolith extends Acquisition {

    private Spark rightMotor = new Spark(RobotMap.grabberRightMotoMonolith);
    private Spark leftMotor = new Spark(RobotMap.grabberLeftMotorMonolith);

    // TODO This parameters are null!!! Someone add values!!!!
    private DoubleSolenoid grabSolenoid = new DoubleSolenoid(RobotMap.grabSolenoidModuleNumber, RobotMap.grabSolenoidForwardPort, RobotMap.grabSolenoidBackwardPort);
    private DoubleSolenoid extendSolenoid = new DoubleSolenoid(RobotMap.extendSolenoidModuleNumber, RobotMap.extendSolenoidForwardPort, RobotMap.extendSolenoidBackwardPort);

    public AcquisitionMonolith(){
        setGrabSolenoidOff();
        setExtendSolenoidOff();
    }

    @Override
    public double getTiltSpeed() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean getTiltPosition() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setTiltPosition(boolean pos) {
        // TODO Auto-generated method stub

    }

    @Override
    public void moveAcq(double v) {
        // TODO Auto-generated method stub

    }

    @Override
    public void moveTilt(double v) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean getTiltLimit() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isAcqOn() {
        // TODO Auto-generated method stub
        return false;
    }

    public void setGrabSolenoidOff() {
        grabSolenoid.set(DoubleSolenoid.Value.kOff);
    }
    
    public void setGrabSolenoidForward() {
        grabSolenoid.set(DoubleSolenoid.Value.kForward);
    }

    public void setGrabBackward(){
        grabSolenoid.set(DoubleSolenoid.Value.kReverse);
    }

    public void setExtendSolenoidOff() {
        extendSolenoid.set(DoubleSolenoid.Value.kOff);
    }
    
    public void setExtendSolenoidForward() {
        extendSolenoid.set(DoubleSolenoid.Value.kForward);
    }

    public void setExtendSolenoidBackward(){
        extendSolenoid.set(DoubleSolenoid.Value.kReverse);
    }

    // SUCC
	public void succ(double speed) {
        setMotors(speed, -speed);
    }

	public void adjust(double speed, boolean direction) {
        if (direction) {
            setMotors(speed, speed);
        }
        else {
            setMotors(-speed, -speed);
        }
    }

	public void setMotors(double left, double right){
        leftMotor.set(left);
        rightMotor.set(right);
    }

	public void stopMotors(){
        setMotors(0d, 0d);
    }
}
