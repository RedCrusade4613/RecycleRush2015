package red.crusade.base.subsystems;

import edu.wpi.first.wpilibj.Talon;
import red.crusade.base.OI;
import red.crusade.base.solenoids.VariableSolenoid;
import red.crusade.superclasses.SubsystemRC;
import static red.crusade.base.RobotMap.*;

/**
 * @author Sean Zammit
 */
public class SubsystemTower extends SubsystemRC
{
	//Set up motors and solenoids here. Make sure to use the RobotMap.
	public Talon towerMotor = new Talon(towerMotorID);

	public boolean getPushingSolenoid = false;
	//TODO DS / S
	public VariableSolenoid pushingSolenoid = new VariableSolenoid(pushingSolenoidID, 7, OI.areSolenoidsSingle);
	
	public SubsystemTower() {
		super();
	}

	public void onInit() {
		//Perform anything that needs to be done before the subsystem is used here. 
		//Do not start sensors. Do that in SubsystemSensors.initSensors().
	}
}
