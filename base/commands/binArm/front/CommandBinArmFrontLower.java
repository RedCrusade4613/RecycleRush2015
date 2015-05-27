package red.crusade.base.commands.binArm.front;

import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Sean Zammit
 */
public class CommandBinArmFrontLower extends CommandRC
{
	public CommandBinArmFrontLower() {
		super(binArmFront);
		this.setTimeout(5);
	}
	
	protected void onStart() {
		binArmFront.binArmFrontSolenoid.set(false);
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
		binArmFront.binArmFrontMotor.set(-1D);
	}
	
	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return !sensors.binArmFrontBaseSwitch.get() || (isTimedOut() && !sensors.binArmFrontTopSwitch.get());
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
		binArmFront.binArmFrontMotor.set(0);
		binArmFront.binArmFrontSolenoid.set(true);
	}
}
