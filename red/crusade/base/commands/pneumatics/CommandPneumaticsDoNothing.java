package red.crusade.base.commands.pneumatics;

import red.crusade.base.RobotMap;
import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Author
 */
public class CommandPneumaticsDoNothing extends CommandRC
{
	public CommandPneumaticsDoNothing(int requiredSystem) {
		super(requiredSystem);
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {

	}

	//Determine the conditions that will stop this command.
	protected boolean isFinished() {
		return false;
	}
}
