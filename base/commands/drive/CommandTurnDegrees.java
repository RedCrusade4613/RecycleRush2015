package red.crusade.base.commands.drive;

import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Sean Zammit
 */
public class CommandTurnDegrees extends CommandRC
{
	int degreesToTurn;
	double leftValue;
	double rightValue;
	
	double originalDegrees;
	
	public CommandTurnDegrees(int degrees, double l, double r) {
		super(driver);
		degreesToTurn = degrees;
		leftValue = l;
		rightValue = r;
		this.setTimeout(0.1D);
	}
	
	protected void onStart() {
		sensors.gyro.reset();
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
		driver.driveFront.tankDrive(leftValue, rightValue);
	}
	
	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return Math.abs(sensors.gyro.getAngle()) > degreesToTurn && isTimedOut();
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
	}
}
