package red.crusade.base.commands;

import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Sean Zammit
 */
public class CommandPullInTotes extends CommandRC
{
	final double
		time1 = 1,
		time2 = 3,
		power1 = 0.8D,
		power2 = 1.0D,
		power3 = 0.9D;
	
	public CommandPullInTotes() {
		super(driver);
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
		if(this.timeSinceInitialized() < time1) belt.totePullingMotor.set(-power1);
		else if(this.timeSinceInitialized() < time1 + time2) belt.totePullingMotor.set(-power2);
		else belt.totePullingMotor.set(-power3);
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
