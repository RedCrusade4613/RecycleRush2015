package red.crusade.base.subsystems;

import edu.wpi.first.wpilibj.Talon;
import red.crusade.superclasses.SubsystemRC;
import static red.crusade.base.RobotMap.*;

/**
 * @author Sean Zammit
 */
public class SubsystemBinArmRear extends SubsystemRC
{
	//Set up motors and solenoids here. Make sure to use the RobotMap.
	public Talon binArmRearMotor = new Talon(binArmMotorRearID);

	public SubsystemBinArmRear() {
		super();
	}

	public void onInit() {
		//Perform anything that needs to be done before the subsystem is used here. 
		//Do not start sensors. Do that in SubsystemSensors.initSensors().
	}

	//Set up functions using the motors here.
}
