package red.crusade.base.commands.belt;

import red.crusade.base.OI;
import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Sean Zammit
 */
public class CommandBeltAnalog extends CommandRC
{
	public CommandBeltAnalog() {
		super(belt);
	}
	
	protected void onStart() {
		belt.speed = 0;
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
		belt.beltMotorLow.set(-OI.stickFunction.getY() * 0.6D);
	}
	
	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return false;
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
		belt.beltMotorLow.set(0);
	}
}
