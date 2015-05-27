package red.crusade.base.commands.tower;

import red.crusade.base.OI;
import red.crusade.base.RobotMap;
import red.crusade.base.commands.CommandWait;
import red.crusade.base.commands.belt.CommandBelt;
import red.crusade.superclasses.CommandRC;

/**
 * @author Sean Zammit
 */
public class CommandAutomaticStack extends CommandRC
{
	public CommandAutomaticStack() {
		super(tower);
	}
	
	protected void onStart() {
		new CommandBelt(RobotMap.polycordSpeedForward).start();
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
		if(sensors.getTowerSwitchTop() && sensors.lightSensorCentre.get() && sensors.lightSensorEdge.get()) {
			OI.currentTotes++;
			new CommandWait(0.2D).setSequential(new CommandTowerToBase(), new CommandAutomaticStack()).start();
			this.cancel();
		}
		
		else if(!sensors.getTowerSwitchTop() && OI.currentTotes < 6) tower.towerMotor.set(1);
		else tower.towerMotor.set(0);
	}
	
	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return OI.currentTotes >= 6;
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
		tower.towerMotor.set(0);
	}
}
