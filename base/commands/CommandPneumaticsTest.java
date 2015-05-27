package red.crusade.base.commands;

import edu.wpi.first.wpilibj.Solenoid;
import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Sean Zammit
 */
public class CommandPneumaticsTest extends CommandRC
{
	public Solenoid solenoid;
	public boolean on;
	
	public CommandPneumaticsTest(Solenoid sol, boolean on) {
		super(null);
		solenoid = sol;
		this.on = on;
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
	}
	
	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return true;
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
		solenoid.set(on);
	}
}
