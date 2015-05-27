package red.crusade.base.commands.binHook;

import edu.wpi.first.wpilibj.Relay.Value;
import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Sean Zammit
 */
public class CommandBinHook extends CommandRC
{
	public CommandBinHook() {
		super(binHook);
	}
	
	protected void onStart() {
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
		binHook.binGrabberRelay.set(Value.kOn);
	}
	
	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return false;
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
	}
}
