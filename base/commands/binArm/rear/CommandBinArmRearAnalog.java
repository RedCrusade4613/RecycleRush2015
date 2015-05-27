package red.crusade.base.commands.binArm.rear;

import red.crusade.base.OI;
import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Sean Zammit
 */
public class CommandBinArmRearAnalog extends CommandRC
{
	public CommandBinArmRearAnalog() {
		super(binArmRear);
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
		binArmRear.binArmRearMotor.set(OI.stickFunction.getY() > 0.1D ? OI.stickFunction.getY() : 0);
	}
	
	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return false;
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
	}
}
