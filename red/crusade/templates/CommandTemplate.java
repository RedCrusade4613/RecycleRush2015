package red.crusade.templates;

import red.crusade.base.RobotMap;
import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Author
 */
public class CommandTemplate extends CommandRC
{
	public CommandTemplate(int requiredSystem) {
		super(requiredSystem);
	}

	//Code to run when the command starts
	protected void initialize() {
		super.initialize();
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
	}
	
	//Code to run when the command finishes
	protected void end() {
		super.end();
	}

	//Determine the conditions that will stop this command.
	protected boolean isFinished() {
		return super.isFinished();
	}
}
