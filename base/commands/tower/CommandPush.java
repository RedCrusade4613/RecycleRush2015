package red.crusade.base.commands.tower;

import red.crusade.base.OI;
import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Sean Zammit
 */
public class CommandPush extends CommandRC
{
	public CommandPush() {
		super(null);
		setTimeout(2.5D);
	}

	protected void onStart() {
		tower.pushingSolenoid.set(true);
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
		tower.pushingSolenoid.set(false);
		OI.currentTotes = 0;
	}
}
