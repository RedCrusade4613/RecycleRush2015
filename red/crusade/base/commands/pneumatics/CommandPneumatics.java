package red.crusade.base.commands.pneumatics;

import edu.wpi.first.wpilibj.Relay.Value;
import red.crusade.base.OI;
import red.crusade.base.RobotMap;
import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Author
 */
public class CommandPneumatics extends CommandRC
{
	public CommandPneumatics(int requiredSystem) {
		super(requiredSystem);
	}

	//Code to run when the command starts
	protected void initialize() {
		super.initialize();
		pneumatics.solenoid.set(true);
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
	}
	
	//Code to run when the command finishes
	protected void end() {
		super.end();
		pneumatics.solenoid.set(false);
	}

	//Determine the conditions that will stop this command.
	protected boolean isFinished() {
		return super.isFinished();
	}
}
