package red.crusade.base.commands.tower;

import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Sean Zammit
 */
public class CommandWaitForTote extends CommandRC
{
	public CommandWaitForTote() {
		super(null);
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
		if(!sensors.getTowerSwitchTop()) tower.towerMotor.set(1);
		else tower.towerMotor.set(0);
	}
	
	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return sensors.lightSensorCentre.get() && sensors.lightSensorEdge.get();
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
		tower.towerMotor.set(0);
	}
}
