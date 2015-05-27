package red.crusade.base.commands;

import edu.wpi.first.wpilibj.command.Command;
import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Sean Zammit
 */
public class CommandInterruptCommand extends CommandRC
{
	Command comToInterrupt;
	
	public CommandInterruptCommand(Command command) {
		super(null);
		comToInterrupt = command;
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
	}
	
	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return true;
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
		comToInterrupt.cancel();
	}
}
