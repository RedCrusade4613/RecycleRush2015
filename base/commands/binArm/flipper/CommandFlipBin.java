package red.crusade.base.commands.binArm.flipper;

import red.crusade.base.commands.CommandDoubleSolenoid;
import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Sean Zammit
 */
public class CommandFlipBin extends CommandRC
{
	boolean shouldFlip = true;
	
	public CommandFlipBin() {
		super(binFlipper);
		this.setTimeout(1D);
	}
	
	public CommandFlipBin(boolean flip) {
		this();
		shouldFlip = flip;
	}

	protected void onStart() {
		binFlipper.binLockSolenoid.set(true);
		binArmFront.binArmFrontSolenoid.set(false);
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
		if(shouldFlip) {
			new CommandDoubleSolenoid(binFlipper.flipper1Solenoid, false).start();
			binFlipper.binLockSolenoid.set(true);
		}
	}
}
