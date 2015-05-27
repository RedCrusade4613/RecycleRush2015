package red.crusade.base.commands;

import red.crusade.base.solenoids.VariableSolenoid;
import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Sean Zammit
 */
public class CommandVariablePneumaticsTest extends CommandRC
{
	public VariableSolenoid solenoid;
	public boolean on;
	
	public CommandVariablePneumaticsTest(VariableSolenoid sol, boolean on) {
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
