package red.crusade.base.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import red.crusade.base.OI;
import red.crusade.base.RobotMap;
import red.crusade.base.helpers.SmartDashboardHelper;
import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Sean Zammit
 */
public class CommandReadSensors extends CommandRC
{
	public CommandReadSensors() {
		super(sensors);
	}
	
	int tick = 0;

	//Set up what the robot will do while this command is running.
	protected void execute() {
		SmartDashboard.putNumber("Tick", tick++);
		SmartDashboard.putNumber("Totes", OI.currentTotes);
		
		//Put any code here needed to handle readings from sensors.
		SmartDashboard.putNumber("Heading", sensors.gyro.getAngle());
		
		SmartDashboard.putBoolean("Tower TR", !sensors.towerSwitchTR.get());
		SmartDashboard.putBoolean("Tower TL", !sensors.towerSwitchTL.get());
		SmartDashboard.putBoolean("Tower BR", !sensors.towerSwitchBR.get());
		SmartDashboard.putBoolean("Tower BL", !sensors.towerSwitchBL.get());
		SmartDashboard.putNumber("Drive Encoder L", sensors.driveEncoderL.get());
		SmartDashboard.putNumber("Drive Encoder R", sensors.driveEncoderR.get());
		SmartDashboard.putBoolean("Rear Bin Arm", !sensors.binArmRearSwitch.get());
		SmartDashboard.putBoolean("Front Bin Arm Top", !sensors.binArmFrontTopSwitch.get());
		SmartDashboard.putBoolean("Front Bin Arm Base", !sensors.binArmFrontBaseSwitch.get());
		SmartDashboard.putString("Centre Light", sensors.lightSensorCentre.get() ? "Dark" : "Light");
		SmartDashboard.putString("Edge Light", sensors.lightSensorEdge.get() ? "Dark" : "Light");
		
		SmartDashboard.putBoolean("Finger Solenoid", binArmFront.binArmFrontSolenoid.get());
		SmartDashboard.putBoolean("Locker Solenoid", binFlipper.binLockSolenoid.get());
		SmartDashboard.putBoolean("Pusher Solenoid", tower.getPushingSolenoid);
		
		RobotMap.towerSpeed = (double) SmartDashboardHelper.getAndPutInfo("Tower Speed", 1D);
		RobotMap.flipperTime = (double) SmartDashboardHelper.getAndPutInfo("Flip Time", 1.6D);
		/*RobotMap.towerSpeed = SmartDashboard.getNumber("Tower Speed", 1D);
		SmartDashboard.putNumber("Tower Speed", RobotMap.towerSpeed);
		
		RobotMap.flipperTime = SmartDashboard.getNumber("Flip Time", 2.0D);
		SmartDashboard.putNumber("Flip Time", RobotMap.flipperTime);*/
	}

	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return false;
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
	}
}
