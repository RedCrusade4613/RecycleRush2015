package red.crusade.base.subsystems;

import edu.wpi.first.wpilibj.Talon;
import red.crusade.superclasses.SubsystemRC;
import static red.crusade.base.RobotMap.*;

/**
 * @author Sean Zammit
 */
public class SubsystemBelt extends SubsystemRC
{
	//Set up motors and solenoids here. Make sure to use the RobotMap.
	public Talon beltMotorLow = new Talon(beltMotorLowID);
	public Talon totePullingMotor = new Talon(totePullingMotorID);
	
	public double speed;
	
	public SubsystemBelt() {
		super();
	}

	public void onInit() {
		//Perform anything that needs to be done before the subsystem is used here. 
		//Do not start sensors. Do that in SubsystemSensors.initSensors().
	}
}
