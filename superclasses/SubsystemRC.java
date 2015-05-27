package red.crusade.superclasses;

import red.crusade.base.commands.CommandBase;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Sean Zammit
 */
public class SubsystemRC extends Subsystem
{
	public int systemID;

	public SubsystemRC() {
		super();
		systemID = CommandBase.id;
		CommandBase.subsystemList.add(this);
		CommandBase.id++;
	}

	public final void initDefaultCommand() {
		onInit();
	}

	public void onInit() {
	}

	public void setDefCommand(CommandRC command) {
		setDefaultCommand(command);
	}
}
