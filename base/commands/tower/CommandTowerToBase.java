package red.crusade.base.commands.tower;

import red.crusade.base.RobotMap;
import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Sean Zammit
 */
public class CommandTowerToBase extends CommandRC
{
	public CommandTowerToBase() {
		super(tower);
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
		tower.towerMotor.set(-RobotMap.towerSpeed);
	}
	
	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return sensors.getTowerSwitchBase();
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
		if(!(this.commandSequential instanceof CommandTowerTimed)) tower.towerMotor.set(0);
	}
}
