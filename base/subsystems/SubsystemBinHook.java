package red.crusade.base.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Direction;
import red.crusade.superclasses.SubsystemRC;

/**
 * @author Sean Zammit
 */
public class SubsystemBinHook extends SubsystemRC
{
	//Set up motors and solenoids here. Make sure to use the RobotMap.
	public Relay binGrabberRelay = new Relay(0, Direction.kForward);
	
	public SubsystemBinHook() {
		super();
	}

	public void onInit() {
		//Perform anything that needs to be done before the subsystem is used here. 
		//Do not start sensors. Do that in SubsystemSensors.initSensors().
	}
}
