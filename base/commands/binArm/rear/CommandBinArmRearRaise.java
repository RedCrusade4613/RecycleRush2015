package red.crusade.base.commands.binArm.rear;

import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Sean Zammit
 */
public class CommandBinArmRearRaise extends CommandRC
{
	public CommandBinArmRearRaise() {
		super(binArmRear);
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
		binArmRear.binArmRearMotor.set(-1);
	}
	
	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return !sensors.binArmRearSwitch.get();
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
		binArmRear.binArmRearMotor.set(0);
	}
}
