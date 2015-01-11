package red.crusade.base;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    //Motors
    public static final int 
        driveMotorLID = 1,
        driveMotorRID = 0;
    
    //Spikes
    public static int
    	testSpikeID = 0;
        
    //Sensors
    public static final int
        exampleSensor = 0;
    
    //Put all 'magic numbers' here. Just putting them in the code makes it hard to fix things when they go wrong.
}