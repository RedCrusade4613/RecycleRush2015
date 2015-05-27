package red.crusade.base.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import red.crusade.superclasses.SubsystemRC;
import static red.crusade.base.RobotMap.*;

/**
 * @author Sean Zammit
 */
public class SubsystemBinArmFront extends SubsystemRC
{
	//Set up motors and solenoids here. Make sure to use the RobotMap.
	public Talon binArmFrontMotor = new Talon(binArmMotorFrontID);
	public Solenoid binArmFrontSolenoid = new Solenoid(binArmFrontSolenoidID);

	public SubsystemBinArmFront() {
		super();
	}

	public void onInit() {
		//Perform anything that needs to be done before the subsystem is used here. 
		//Do not start sensors. Do that in SubsystemSensors.initSensors().
	}

	//Set up functions using the motors here.
}
