package red.crusade.base.subsystems;

import red.crusade.superclasses.SubsystemRC;
import edu.wpi.first.wpilibj.RobotDrive;
import static red.crusade.base.RobotMap.*;

/**
 * @author Sean Zammit
 */
public class SubsystemDriver extends SubsystemRC
{
	/*public double currentSpeed = 0;
	public double currentRotation = 0;

	public final double allowedChange = 0.2D;*/

	public boolean isDefaultDirection;

	//Set up motors and solenoids here. Make sure to use the RobotMap.
	public RobotDrive driveFront = new RobotDrive(driveMotorLID, driveMotorRID);

	public SubsystemDriver() {
		super();
		isDefaultDirection = false;
	}

	public void onInit() {
		//Perform anything that needs to be done before the subsystem is used here. 
		//Do not start sensors. Do that in SubsystemSensors.initSensors().
		driveFront.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
	}

	//Set up functions using the motors and solenoids here.
}
