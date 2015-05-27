package red.crusade.base.commands.binArm.front;

import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Sean Zammit
 */
public class CommandBinArmFrontRaise extends CommandRC
{
	public CommandBinArmFrontRaise() {
		super(binArmFront);
		//this.setSequential(new CommandBinArmFrontHoldUp());
	}
	
	protected void onStart() {
		binArmFront.binArmFrontMotor.set(1D);
		//binArmFront.binArmFrontSolenoid.set(true);
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
	}
	
	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return !sensors.binArmFrontTopSwitch.get();
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
		binArmFront.binArmFrontMotor.set(0);
	}
}
