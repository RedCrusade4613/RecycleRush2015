package red.crusade.base.commands.drive;

import red.crusade.superclasses.CommandRC;

/**
 * @author Sean Zammit
 */
public class CommandTimedTurn extends CommandRC
{
	double l;
	double r;

	public CommandTimedTurn(double time, double left, double right) {
		super(driver);
		setTimeout(time);
		l = left;
		r = right;
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
		driver.driveFront.tankDrive(l, r);
	}

	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return isTimedOut();
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
	}
}
