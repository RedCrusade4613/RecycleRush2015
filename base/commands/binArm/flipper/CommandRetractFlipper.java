package red.crusade.base.commands.binArm.flipper;

import red.crusade.base.commands.CommandDoubleSolenoid;
import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Sean Zammit
 */
public class CommandRetractFlipper extends CommandRC
{
	public CommandRetractFlipper() {
		super(binFlipper);
	}

	protected void onStart() {
		new CommandDoubleSolenoid(binFlipper.flipper1Solenoid, true).start();
		binFlipper.flipper2Solenoid.set(false);
		binFlipper.binLockSolenoid.set(false);
	}
	
	//Set up what the robot will do while this command is running.
	protected void execute() {
	}
	
	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return true;
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {	
	}
}
