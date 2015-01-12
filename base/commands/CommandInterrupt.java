package red.crusade.base.commands;

import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Sean Zammit
 */
public class CommandInterrupt extends CommandRC
{
	public CommandInterrupt() {
		super(-1);
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
	}

	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return true;
	}

	//Called once after the command is finished.
	protected void end() {
		//Hasn't been tested.
		for(int a = 0; a < subsystemList.size(); a++) {
			subsystemList.get(a).getCurrentCommand().cancel();
		}
	}
}
