package red.crusade.base.commands.drive;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import red.crusade.superclasses.CommandRC;

/**
 * @author Sean Zammit
 */
public class CommandPDMove extends CommandRC
{
	double maxSpeed;
	int pulses;
	int directionMultiplier;
	
	double ld;
	double rd;
	
	final double
		a = 0.0025D,
		c = 0.25D;

	public CommandPDMove(int pulses, double maxSpeed) {
		super(driver);
		this.pulses = pulses;
		this.maxSpeed = Math.abs(maxSpeed);
		this.directionMultiplier = maxSpeed > 0 ? 1 : -1;
	}
	
	protected void onStart() {
		sensors.driveEncoderL.reset();
		sensors.driveEncoderR.reset();
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
		double lp = pulses - Math.abs(sensors.driveEncoderL.get());
		ld = Math.max(Math.min(lp * a - ld * c + 0.4D, maxSpeed), 0);
		
		double rp = pulses - Math.abs(sensors.driveEncoderR.get());
		rd = Math.max(Math.min(rp * a - rd * c + 0.4D, maxSpeed), 0);
		
		driver.driveFront.tankDrive(ld * directionMultiplier, rd * directionMultiplier);
		SmartDashboard.putNumber("Left Speed", ld);
		SmartDashboard.putNumber("Right Speed", rd);
	}

	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return Math.abs(sensors.driveEncoderL.get()) > pulses && Math.abs(sensors.driveEncoderR.get()) > pulses; 
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
		ld = 0;
		rd = 0;
	}
}
