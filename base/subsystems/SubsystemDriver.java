package red.crusade.base.subsystems;

import red.crusade.base.RobotMap;
import red.crusade.superclasses.SubsystemRC;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * @author Author
 */
public class SubsystemDriver extends SubsystemRC
{
	public double currentSpeed = 0;
	public double currentRotation = 0;

	public final double allowedChange = 2;

	public boolean isDefaultDirection;

	//Set up motors and solenoids here. Make sure to use the RobotMap.
	public RobotDrive driveFront = new RobotDrive(RobotMap.driveMotorLID, RobotMap.driveMotorRID);

	public SubsystemDriver(int id) {
		super(id);
		isDefaultDirection = true;
	}

	public void onInit() {
		//Perform anything that needs to be done before the subsystem is used here. 
		//Do not start sensors. Do that in SubsystemSensors.initSensors().
		driveFront.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
	}

	//Set up functions using the motors and solenoids here.
}
