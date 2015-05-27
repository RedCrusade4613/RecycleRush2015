package red.crusade.base.subsystems;

import edu.wpi.first.wpilibj.*;
import red.crusade.superclasses.SubsystemRC;
import static red.crusade.base.RobotMap.*;

/**
 * @author Sean Zammit
 */
public class SubsystemSensors extends SubsystemRC
{
	//Set up sensors here. Make sure to use the RobotMap.
	public Gyro gyro = new Gyro(gyroID);
	
	public DigitalInput towerSwitchTL = new DigitalInput(towerSwitchTLID);
	public DigitalInput towerSwitchTR = new DigitalInput(towerSwitchTRID);
	public DigitalInput towerSwitchBL = new DigitalInput(towerSwitchBLID);
	public DigitalInput towerSwitchBR = new DigitalInput(towerSwitchBRID);
	public DigitalInput binArmRearSwitch = new DigitalInput(binArmRearSwitchID);
	public DigitalInput binArmFrontBaseSwitch = new DigitalInput(binArmFrontBaseSwitchID);
	public DigitalInput binArmFrontTopSwitch = new DigitalInput(binArmFrontTopSwitchID);
	public DigitalInput lightSensorCentre = new DigitalInput(lightSensorCentreID);
	public DigitalInput lightSensorEdge = new DigitalInput(lightSensorEdgeID);
	
	public Encoder driveEncoderL = new Encoder(driveEncoderL3ID, driveEncoderL1ID);
	public Encoder driveEncoderR = new Encoder(driveEncoderR3ID, driveEncoderR1ID);
	
	public SubsystemSensors() {
		super();
	}

	public final void initSensors() {
		//Start sensors here.
		gyro.reset();
		driveEncoderL.reset();
		driveEncoderR.reset();
	}

	//Set up functions using the sensors here.
	public boolean getTowerSwitchBase() {
		return !towerSwitchBL.get() || !towerSwitchBR.get();
	}

	public boolean getTowerSwitchTop() {
		return !towerSwitchTL.get() || !towerSwitchTR.get();
	}
}
