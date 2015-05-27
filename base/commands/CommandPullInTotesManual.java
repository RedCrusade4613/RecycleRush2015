package red.crusade.base.commands;

import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Sean Zammit
 */
public class CommandPullInTotesManual extends CommandRC
{
	public CommandPullInTotesManual() {
		super(driver);
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
		belt.totePullingMotor.set(-0.75D);
	}
	
	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return false;
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
		belt.totePullingMotor.set(0);
	}
}
