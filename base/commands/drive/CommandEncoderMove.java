package red.crusade.base.commands.drive;

import red.crusade.superclasses.CommandRC;

/**
 * @author Sean Zammit
 */
public class CommandEncoderMove extends CommandRC
{
	double speed;
	int pulses;

	public CommandEncoderMove(int pulses, double sp) {
		super(driver);
		this.pulses = pulses;
		speed = sp;
	}
	
	protected void onStart() {
		sensors.gyro.reset();
		sensors.driveEncoderL.reset();
		sensors.driveEncoderR.reset();
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
		double rotation = 0;
		driver.driveFront.arcadeDrive(speed, rotation/* - (sensors.gyro.getAngle() / 30)*/);
	}

	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return Math.abs(sensors.driveEncoderL.get()) > pulses && Math.abs(sensors.driveEncoderR.get()) > pulses; 
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
	}
}
