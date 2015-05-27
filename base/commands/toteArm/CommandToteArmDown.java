package red.crusade.base.commands.toteArm;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Sean Zammit
 */
public class CommandToteArmDown extends CommandRC
{
	public CommandToteArmDown() {
		super(toteArm);
		this.setTimeout(0.1D);
	}
	
	protected void onStart() {
		//toteArm.toteArmDownRelay.set(Value.kOn);
		toteArm.toteArmSolenoid.set(Value.kReverse);
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
		//toteArm.toteArmDownRelay.set(Value.kOff);
		toteArm.toteArmSolenoid.set(Value.kOff);
	}
}