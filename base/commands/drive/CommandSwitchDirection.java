package red.crusade.base.commands.drive;

import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Sean Zammit
 */
public class CommandSwitchDirection extends CommandRC
{
	private boolean shouldForward;

	public CommandSwitchDirection(boolean forward) {
		super(driver);
		shouldForward = forward;
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
		driver.isDefaultDirection = shouldForward;
	}
	
	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return true;
	}
}
