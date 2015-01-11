package red.crusade.base.subsystems;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.vision.AxisCamera;
import red.crusade.base.RobotMap;

/**
 * @author Author
 */
public class SubsystemCamera extends SubsystemRC {
    //Set up motors here. Make sure to use the RobotMap.
    public SubsystemCamera(int id) {
        super(id);
    }
    
    public AxisCamera axisCamera;
    public Image frame;
    
	public void onInit() {
        //Perform anything that needs to be done before the subsystem is used here. 
        //Do not start sensors. Do that in SubsystemRC.initSensors().

		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);

        // open the camera at the IP address assigned. This is the IP address that the camera
        // can be accessed through the web interface.
        axisCamera = new AxisCamera("10.46.13.20");
    }
    
    //Set up functions using the motors here.
}
