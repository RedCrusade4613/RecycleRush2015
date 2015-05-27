package red.crusade.base.commands.binArm.front;

import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Sean Zammit
 */
public class CommandWaitForBinArmDown extends CommandRC
{
	public CommandWaitForBinArmDown() {
		super(null);
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
	}

	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return !sensors.binArmFrontBaseSwitch.get();
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
	}
}
