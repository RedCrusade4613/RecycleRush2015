package red.crusade.base;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    //PWMs (0 - 9)
    public static final int
    	driveMotorLID = 0,
    	driveMotorRID = 1,
    	towerMotorID = 2,
    	binArmMotorFrontID = 3,
    	binArmMotorRearID = 4,
    	totePullingMotorID = 5,
    	beltMotorLowID = 6;
  
    //Solenoids (0 - 7)
    public static final int
		binLockSolenoidID = 0,
		pushingSolenoidID = 1,
		flipperSolenoid2ID = 2,
		flipperSolenoid1RID = 3,
		flipperSolenoid1FID = 4,
		binArmFrontSolenoidID = 5;
        
    //Digital I/Os (0 - 9)
    public static final int
    	driveEncoderL3ID = 4,
    	driveEncoderL1ID = 5,
    	driveEncoderR3ID = 6,
    	driveEncoderR1ID = 7;
    
    //More Board for PWMs and DIOs (10 - 25)
    public static final int
		towerSwitchTLID = 11,
		towerSwitchTRID = 10,
		towerSwitchBLID = 12,
		towerSwitchBRID = 13,
		binArmRearSwitchID = 14,
		binArmFrontBaseSwitchID = 15,
		binArmFrontTopSwitchID = 17,		
		lightSensorCentreID = 16,
		lightSensorEdgeID = 18;
    
    //Analog Inputs (0 - 3)
    public static final int
    	gyroID = 0;
    
    //Relays (0 - 3)
    public static final int
		exampleRelayID = 0;
    
    //Put all 'magic numbers' here. Just putting them in the code makes it hard to fix things when they go wrong.
    public static final int
		autoDistance1 = 410,//To tote 2
		autoDistance2 = 420,//To bin 3
		autoDistance3 = 660,//To tote 3
		autoDistance4 = 300,//120,//Over step
		autoDistance5 = 850//Direct to auto zone
		;
    
    public static final double
    	polycordSpeedForward = 0.6D,
    	polycordSpeedReverse = 1;

	public static double 
		towerSpeed = 1D,
		flipperTime = 2.0D;
}