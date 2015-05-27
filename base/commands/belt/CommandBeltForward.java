package red.crusade.base.commands.belt;

import red.crusade.base.RobotMap;
import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Sean Zammit
 */
public class CommandBeltForward extends CommandRC
{
	double speed;
	
	public CommandBeltForward() {
		super(belt);
	}
	
	protected void onStart() {
		this.speed = belt.speed != RobotMap.polycordSpeedForward ? RobotMap.polycordSpeedForward : 0;
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
