package red.crusade.base.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import red.crusade.base.RobotMap;
import red.crusade.superclasses.SubsystemRC;

/**
 * @author Sean Zammit
 */
public class SubsystemPneumatics extends SubsystemRC
{
	//Set up motors and solenoids here. Make sure to use the RobotMap.
	public Solenoid solenoid = new Solenoid(RobotMap.testSolenoidID);
	public Compressor compressor = new Compressor();

	public SubsystemPneumatics(int id) {
		super(id);
	}

	public void onInit() {
		//Perform anything that needs to be done before the subsystem is used here. 
		//Do not start sensors. Do that in SubsystemSensors.initSensors().
	}

	//Set up functions using the motors and solenoids here.
}
