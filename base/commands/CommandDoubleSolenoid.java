package red.crusade.base.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Sean Zammit
 */
public class CommandDoubleSolenoid extends CommandRC
{
	boolean on;
	DoubleSolenoid solenoid;
	
	public CommandDoubleSolenoid(DoubleSolenoid sol, boolean on) {
		super(null);
		this.on = on;
		this.solenoid = sol;
		this.setTimeout(0.1D);
	}
	
	public void onStart() {
		solenoid.set(on ? Value.kForward : Value.kReverse);
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
	}
	
	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return isTimedOut();
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
		solenoid.set(Value.kOff);
	}
}
