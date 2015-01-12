package red.crusade.base.commands;

import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Author
 */
public class CommandDoNothing extends CommandRC
{
	public CommandDoNothing(int requiredSystem) {
		super(requiredSystem);
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
	}
}
