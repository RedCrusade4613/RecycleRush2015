package red.crusade.base.commands.binArm.front;

import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Sean Zammit
 */
public class CommandBinArmFrontLowerSafety extends CommandRC
{
	public CommandBinArmFrontLowerSafety() {
		super(binArmFront);
		this.setTimeout(0.25D);
	}
	
	protected void onStart() {
		binArmFront.binArmFrontMotor.set(-0.65D);
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
	}
	
	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return !sensors.binArmFrontBaseSwitch.get() || isTimedOut();
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
		binArmFront.binArmFrontMotor.set(0);
		//binArmFront.binArmFrontSolenoid.set(true);
	}
}
