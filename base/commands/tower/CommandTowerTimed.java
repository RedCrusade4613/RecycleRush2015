package red.crusade.base.commands.tower;

import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Sean Zammit
 */
public class CommandTowerTimed extends CommandRC
{
	public CommandTowerTimed() {
		super(tower);
		this.setTimeout(0.1D);
	}
	
	protected void onStart() {
		tower.towerMotor.set(-0.5D);
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
	}
	
	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return isTimedOut();
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
		tower.towerMotor.set(0);
	}
}
