package red.crusade.base.commands.drive;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import red.crusade.base.OI;
import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Sean Zammit
 */
public class CommandDrive extends CommandRC
{
	public CommandDrive() {
		super(driver);
	}

	boolean arcadeDrive = false;
	double lSpeed;
	double rSpeed;
	
	final double maxChange = 0.1D;

	//Set up what the robot will do while this command is running.
	protected void execute() {
		if(arcadeDrive) {
			double stickX = OI.stickDriver1.getX();
			double stickY = OI.stickDriver1.getY();

			if(OI.d1_T.get()) stickY /= 2;
			stickX *= Math.abs(stickX);

			double speed = driver.isDefaultDirection ? -stickY : stickY;
			double rotation = stickX;

			/*speed = speed > driver.currentSpeed ?
					Math.min(speed, driver.currentSpeed + driver.allowedChange) :
					Math.max(speed, driver.currentSpeed - driver.allowedChange);
			rotation = rotation > driver.currentRotation ?
					Math.min(rotation, driver.currentRotation + driver.allowedChange) :
					Math.max(rotation, driver.currentRotation - driver.allowedChange);*/

			driver.driveFront.arcadeDrive(speed, rotation);
		}
		else {
			double leftInput = driver.isDefaultDirection ? OI.stickDriver1.getY() : -OI.stickDriver2.getY();
			double rightInput = driver.isDefaultDirection ? OI.stickDriver2.getY() : -OI.stickDriver1.getY();
			
			if(lSpeed + maxChange < leftInput) lSpeed += maxChange;
			else if(lSpeed - maxChange > leftInput) lSpeed -= maxChange;
			else lSpeed = leftInput;
			
			if(rSpeed + maxChange < rightInput) rSpeed += maxChange;
			else if(rSpeed - maxChange > rightInput) rSpeed -= maxChange;
			else rSpeed = rightInput;
			
			driver.driveFront.tankDrive(lSpeed, rSpeed);
			SmartDashboard.putNumber("Left Speed", lSpeed);
			SmartDashboard.putNumber("Right Speed", rSpeed);
		}
	}

	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return false;
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
		lSpeed = 0;
		rSpeed = 0;
	}
}
