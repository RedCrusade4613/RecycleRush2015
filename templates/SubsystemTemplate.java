package red.crusade.templates;

import red.crusade.superclasses.SubsystemRC;

/**
 * @author Author
 */
public class SubsystemTemplate extends SubsystemRC
{
	//Set up motors here. Make sure to use the RobotMap.

	public SubsystemTemplate(int id) {
		super(id);
	}

	public void onInit() {
		//Perform anything that needs to be done before the subsystem is used here. 
		//Do not start sensors. Do that in SubsystemSensors.initSensors().
	}

	//Set up functions using the motors here.
}
