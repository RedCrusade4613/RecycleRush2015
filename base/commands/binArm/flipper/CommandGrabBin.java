package red.crusade.base.commands.binArm.flipper;

import red.crusade.base.commands.CommandDoubleSolenoid;
import red.crusade.base.commands.CommandWait;
import red.crusade.base.commands.binArm.front.CommandBinArmFrontLowerSafety;
import red.crusade.base.commands.binArm.front.CommandBinArmFrontRaise;
import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Sean Zammit
 */
public class CommandGrabBin extends CommandRC
{
	public CommandGrabBin() {
		this(false);
	}
	
	public CommandGrabBin(boolean hold) {
		super(binFlipper);
		this.setTimeout(0.5D);
		this.setSequential(new CommandWait(1D), new CommandFlipBin(/*!hold*/true).setParallel(new CommandBinArmFrontLowerSafety()));
	}
	
	protected void onStart() {
		new CommandDoubleSolenoid(binFlipper.flipper1Solenoid, true).start();
		binFlipper.flipper2Solenoid.set(false);
		binFlipper.binLockSolenoid.set(false);
		
		if(!sensors.binArmFrontTopSwitch.get()) new CommandBinArmFrontLowerSafety().setSequential(new CommandBinArmFrontRaise()).start();
		new CommandBinArmFrontRaise().start();
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
	}
	
	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return !sensors.binArmFrontTopSwitch.get() && isTimedOut();
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
		binFlipper.binLockSolenoid.set(true);
		/*binArmFront.binArmFrontSolenoid.set(false);*/
	}
}