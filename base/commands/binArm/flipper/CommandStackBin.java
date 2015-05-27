package red.crusade.base.commands.binArm.flipper;

import red.crusade.base.RobotMap;
import red.crusade.base.commands.CommandDoubleSolenoid;
import red.crusade.base.commands.CommandWait;
import red.crusade.base.commands.binArm.front.CommandBinArmFrontLowerSafety;
import red.crusade.superclasses.CommandRC;

/**
 * @author Sean Zammit
 */
public class CommandStackBin extends CommandRC
{
	public CommandStackBin() {
		super(binFlipper);
		this.setTimeout(RobotMap.flipperTime);
		this.setParallel(new CommandBinArmFrontLowerSafety());
		this.setSequential(new CommandWait(2D), new CommandRetractFlipper());
	}

	protected void onStart() {
		this.setTimeout(RobotMap.flipperTime);
		new CommandDoubleSolenoid(binFlipper.flipper1Solenoid, false).start();
		binFlipper.flipper2Solenoid.set(true);
		binFlipper.binLockSolenoid.set(true);
	}
	
	//Set up what the robot will do while this command is running.
	protected void execute() {
	}
	
	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return isTimedOut();
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
		binFlipper.binLockSolenoid.set(false);		
	}
}
