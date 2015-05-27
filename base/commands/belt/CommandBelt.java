package red.crusade.base.commands.belt;

import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Sean Zammit
 */
public class CommandBelt extends CommandRC
{
	double speed;
	
	public CommandBelt(double speed) {
		super(belt);
		this.speed = speed;
	}
	
	protected void onStart() {
		belt.speed = speed;
		belt.beltMotorLow.set(speed);
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
	}
}
