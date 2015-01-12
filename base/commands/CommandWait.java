package red.crusade.base.commands;

import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Sean Zammit
 */
public class CommandWait extends CommandRC
{
	public CommandWait(double timeout) {
		super(-1);
		setTimeout(timeout);
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
	}

	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return isTimedOut();
	}
}
