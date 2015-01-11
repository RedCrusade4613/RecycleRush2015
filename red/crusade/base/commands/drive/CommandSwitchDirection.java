package red.crusade.base.commands.drive;

import red.crusade.base.RobotMap;
import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Author
 */
public class CommandSwitchDirection extends CommandRC
{
	private boolean shouldForward;
	
	public CommandSwitchDirection(boolean forward) {
		super(driver.systemID);
		shouldForward = forward;
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
		driver.isDefaultDirection = shouldForward;
	}

	//Determine the conditions that will stop this command.
	protected boolean isFinished() {
		return true;
	}
}
