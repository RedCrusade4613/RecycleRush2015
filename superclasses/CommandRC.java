package red.crusade.superclasses;

import edu.wpi.first.wpilibj.buttons.Button;
import red.crusade.base.commands.CommandBase;

/**
 * Creates a standard setup for all commands. All commands should extend CommandRC.
 * 
 * @author Sean Zammit
 */
public abstract class CommandRC extends CommandBase
{
	//Command to run when this command is started
	private CommandRC commandParallel;

	//Command to run when this command is finished
	private CommandRC commandSequential;
	
	private boolean isWhileHeld = false;
	private Button button;

	public CommandRC(int requiredSystem) {
		super();
		if(requiredSystem != -1) {
			requires(subsystemList[requiredSystem]);
		}
	}

	protected void initialize() {
		if(commandParallel != null) {
			commandParallel.start();
		}
	}

	protected abstract void execute();

	protected boolean isFinished() {
		return isWhileHeld ? !button.get() : false;
	}

	protected void end() {
		if(commandSequential != null) {
			commandSequential.start();
		}
	}

	protected void interrupted() {
	}
	
	public final CommandRC setParallel(CommandRC command) {
		commandParallel = command;
		return this;
	}
	
	public final CommandRC setSequential(CommandRC command) {
		commandSequential = command;
		return this;
	}
	
	public final CommandRC setCancelWhenReleased(Button button) {
		isWhileHeld = true;
		this.button = button;
		return this;
	}
}
