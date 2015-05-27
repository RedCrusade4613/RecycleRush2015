package red.crusade.base.commands.tower;

import red.crusade.base.OI;
import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Sean Zammit
 */
public class CommandTowerVertical extends CommandRC
{
	public CommandTowerVertical() {
		super(tower);
	}

	protected void onStart() {
	}
	
	//Set up what the robot will do while this command is running.
	protected void execute() {
		double speed = OI.stickFunction.getPOV() == 0 ? 1 : OI.stickFunction.getPOV() == 180 ? -1 : 0;
		if((!sensors.getTowerSwitchTop() || speed < 0) && (!sensors.getTowerSwitchBase() || speed > 0)) tower.towerMotor.set(speed);
		else tower.towerMotor.set(0);
	}
	
	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return false;
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
		tower.towerMotor.set(0);
	}
}
