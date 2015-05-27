package red.crusade.base.commands.drive;

import red.crusade.superclasses.CommandRC;

/**
 * @author Sean Zammit
 */
public class CommandTimedMove extends CommandRC
{
	double speed;

	public CommandTimedMove(double time, double sp) {
		super(driver);
		setTimeout(time);
		speed = sp;
	}
	
	protected void onStart() {
		sensors.gyro.reset();
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
		double rotation = 0;
		driver.driveFront.arcadeDrive(speed, rotation + (sensors.gyro.getAngle() / 90));
	}

	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return isTimedOut();
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
	}
}
