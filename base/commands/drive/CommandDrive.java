package red.crusade.base.commands.drive;

import red.crusade.base.OI;
import red.crusade.base.subsystems.SubsystemRC;
import red.crusade.superclasses.CommandRC;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author Sean Zammit
 */
public class CommandDrive extends CommandRC
{
	public CommandDrive(int requiredSystem) {
		super(requiredSystem);
	}

	Joystick primaryStick = OI.stickDriver;
	double stickX;
	double stickY;

	//Set up what the robot will do while this command is running.
	protected void execute() {
		/*if(OI.pivotSwitch.get()) {
		    double rotation = primaryStick.getTwist() * 2 - 1;
		    driver.driveFront.arcadeDrive(0, rotation);
		    driver.driveRear.arcadeDrive(0, rotation);
		}
		else*/{
			stickX = primaryStick.getX();
			stickY = primaryStick.getY();

			if(OI.trigger.get()) {
				stickY /= 2;
			}
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
	}

	//Determine the conditions that will stop this command.
	protected boolean isFinished() {
		return false;
	}
}
