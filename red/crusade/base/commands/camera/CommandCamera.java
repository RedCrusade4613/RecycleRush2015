package red.crusade.base.commands.camera;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.vision.AxisCamera;
import red.crusade.base.RobotMap;
import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Sean Zammit
 */
public class CommandCamera extends CommandRC
{
	public CommandCamera(int requiredSystem) {
		super(requiredSystem);
	}

	//Code to run when the command starts
	protected void initialize() {
		super.initialize();
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
		camera.axisCamera.getImage(camera.frame);
		CameraServer.getInstance().setImage(camera.frame);
	}
	
	//Code to run when the command finishes
	protected void end() {
		super.end();
	}

	//Determine the conditions that will stop this command.
	protected boolean isFinished() {
		return super.isFinished();
	}
}
