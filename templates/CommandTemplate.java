package red.crusade.templates;

import red.crusade.superclasses.CommandRC;
import red.crusade.superclasses.SubsystemRC;

/**
 *
 * @author Author
 */
public class CommandTemplate extends CommandRC
{
	public CommandTemplate(SubsystemRC requiredSystem) {
		super(requiredSystem);
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
	}
	
	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return false;
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
	}
}
