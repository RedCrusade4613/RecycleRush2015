package red.crusade.base.commands.toteArm;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Sean Zammit
 */
public class CommandToteArmUp extends CommandRC
{
	public CommandToteArmUp() {
		super(toteArm);
		this.setTimeout(0.1D);
	}
	
	protected void onStart() {
		//toteArm.toteArmUpRelay.set(Value.kOn);
		toteArm.toteArmSolenoid.set(Value.kForward);
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
	}
	
	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return isTimedOut();
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
		//toteArm.toteArmUpRelay.set(Value.kOff);
		toteArm.toteArmSolenoid.set(Value.kOff);
	}
}