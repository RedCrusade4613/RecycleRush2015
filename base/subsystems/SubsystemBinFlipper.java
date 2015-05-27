package red.crusade.base.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import red.crusade.base.OI;
import red.crusade.base.solenoids.VariableSolenoid;
import red.crusade.superclasses.SubsystemRC;
import static red.crusade.base.RobotMap.*;

/**
 * @author Sean Zammit
 */
public class SubsystemBinFlipper extends SubsystemRC
{
	//Set up motors and solenoids here. Make sure to use the RobotMap.
	public DoubleSolenoid flipper1Solenoid = new DoubleSolenoid(flipperSolenoid1FID, flipperSolenoid1RID);
		
	//TODO DS / S
	public VariableSolenoid flipper2Solenoid = new VariableSolenoid(flipperSolenoid2ID, 6, OI.areSolenoidsSingle);
	public Solenoid binLockSolenoid = new Solenoid(binLockSolenoidID);

	public SubsystemBinFlipper() {
		super();
	}

	public void onInit() {
		//Perform anything that needs to be done before the subsystem is used here. 
		//Do not start sensors. Do that in SubsystemSensors.initSensors().
	}

	//Set up functions using the motors here.
}
