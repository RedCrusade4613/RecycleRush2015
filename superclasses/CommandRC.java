package red.crusade.superclasses;

import edu.wpi.first.wpilibj.buttons.Button;
import red.crusade.base.Main;
import red.crusade.base.commands.CommandBase;
import red.crusade.base.commands.CommandInterrupt;

/**
 * Creates a standard setup for all commands. All commands should extend CommandRC.
 * 
 * @author Sean Zammit
 */
public abstract class CommandRC extends CommandBase
{
	//Command to run when this command is started
	protected CommandRC commandParallel;

	//Command to run when this command is finished
	protected CommandRC commandSequential;
	
	public boolean startedInAuto = false;

	private boolean isWhileHeld = false;
	private Button button;

	public CommandRC(SubsystemRC requiredSystem) {
		super();
		CommandInterrupt.comList.add(this);
		if(requiredSystem != null) requires(requiredSystem);
	}

	protected abstract void execute();

	protected abstract boolean isDone();

	protected abstract void onCompletion();

	protected void onStart() {
	}

	protected void interrupted() {
		this.end();
	}

	protected final void initialize() {
		if(commandParallel != null) commandParallel.start();
		this.startedInAuto = Main.isAuto;
		this.onStart();
	}

	protected final boolean isFinished() {
		return (isWhileHeld && !button.get()) || isDone();
	}

	protected final void end() {
		if(commandSequential != null && !(this.startedInAuto && !Main.isAuto)) {
			commandSequential.start();
		}
		this.onCompletion();
	}

	public final CommandRC setParallel(CommandRC... commands) {
		if(commands.length > 1) {
			CommandRC[] newCommands = new CommandRC[commands.length - 1];
			for(int a = 1; a < commands.length; a++)
				newCommands[a - 1] = commands[a];
			if(commandParallel != null) commandParallel.setParallel(commands[0].setSequential(newCommands));
			else commandParallel = commands[0].setSequential(newCommands);
		}
		else if(commandParallel != null) commandParallel.setParallel(commands[0]);
		else commandParallel = commands[0];
		return this;
	}

	public final CommandRC setSequential(CommandRC... commands) {
		if(commands.length > 1) {
			CommandRC[] newCommands = new CommandRC[commands.length - 1];
			for(int a = 1; a < commands.length; a++)
				newCommands[a - 1] = commands[a];
			if(commandSequential != null) commandSequential.setParallel(commands[0].setSequential(newCommands));
			else commandSequential = commands[0].setSequential(newCommands);
		}
		else if(commandSequential != null) commandSequential.setParallel(commands[0]);
		else commandSequential = commands[0];
		return this;
	}

	public final CommandRC setCancelWhenReleased(Button button) {
		isWhileHeld = true;
		this.button = button;
		return this;
	}
}
