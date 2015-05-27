package red.crusade.base.commands;

import edu.wpi.first.wpilibj.command.Subsystem;
import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Sean Zammit
 */
public class CommandInterruptSubsystem extends CommandRC
{
	Subsystem subsystem;
	
	public CommandInterruptSubsystem(Subsystem sub) {
		super(null);
		subsystem = sub;
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
		subsystem.getCurrentCommand().cancel();
	}
}
