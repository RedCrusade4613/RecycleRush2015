package red.crusade.base.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import red.crusade.superclasses.SubsystemRC;

/**
 * @author Sean Zammit
 */
public class SubsystemToteArm extends SubsystemRC
{
	//Set up motors and solenoids here. Make sure to use the RobotMap.
	//public Relay toteArmUpRelay = new Relay(toteArmUpRelayID, Direction.kForward);
	//public Relay toteArmDownRelay = new Relay(toteArmDownRelayID, Direction.kForward);
	public DoubleSolenoid toteArmSolenoid = new DoubleSolenoid(6, 7);

	public SubsystemToteArm() {
		super();
	}

	public void onInit() {
		//Perform anything that needs to be done before the subsystem is used here. 
		//Do not start sensors. Do that in SubsystemSensors.initSensors().
	}
}
