package red.crusade.base.commands.binArm.front;

import red.crusade.superclasses.CommandRC;

/**
 * @author Sean Zammit
 */
public class CommandBinArmFrontHoldUp extends CommandRC
{
	public CommandBinArmFrontHoldUp() {
		super(binArmFront);
	}
	
	//Set up what the robot will do while this command is running.
	protected void execute() {
		if(sensors.binArmFrontTopSwitch.get()) binArmFront.binArmFrontMotor.set(0.5D);
		else binArmFront.binArmFrontMotor.set(0);
	}
	
	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return false;
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
		binArmFront.binArmFrontMotor.set(0);
	}
}
