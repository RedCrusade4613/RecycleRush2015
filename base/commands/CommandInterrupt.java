package red.crusade.base.commands;

import java.util.ArrayList;

import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Sean Zammit
 */
public class CommandInterrupt extends CommandRC
{
	public static ArrayList<CommandRC> comList = new ArrayList<CommandRC>();
	
	public CommandInterrupt() {
		super(null);
		this.setTimeout(1D);
	}

	//Set up what the robot will do while this command is running.
	protected void execute() {
		/*for(int a = 0; a < comList.size(); a++)
			if(comList.get(a) != this) comList.get(a).cancel();*/
	}

	//Determine the conditions that will stop this command.
	protected boolean isDone() {
		return true;//isTimedOut();
	}

	//Turn off your motors or solenoids used in this command.
	protected void onCompletion() {
		for(int a = 0; a < comList.size(); a++)
			if(comList.get(a) != this) comList.get(a).cancel();
	}
}
