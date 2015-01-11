package red.crusade.base.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.Solenoid;
import red.crusade.base.RobotMap;
import red.crusade.base.subsystems.SubsystemRC;

/**
 * @author Sean Zammit
 */
public class SubsystemPneumatics extends SubsystemRC {
    //Set up motors here. Make sure to use the RobotMap.
	//public Relay spike = new Relay(RobotMap.testSpikeID, Direction.kForward);
    public Solenoid solenoid = new Solenoid(0, 7);
    public Compressor compressor = new Compressor();
	
    public SubsystemPneumatics(int id) {
        super(id);
    }
    
    public void onInit() {
        //Perform anything that needs to be done before the subsystem is used here. 
        //Do not start sensors. Do that in SubsystemRC.initSensors().
    }
    
    //Set up functions using the motors here.
}
