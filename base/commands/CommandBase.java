package red.crusade.base.commands;

import java.util.ArrayList;

import red.crusade.base.OI;
import red.crusade.base.commands.autonomous.Autonomous;
import red.crusade.base.commands.drive.CommandDrive;
import red.crusade.base.subsystems.SubsystemCamera;
import red.crusade.base.subsystems.SubsystemDriver;
import red.crusade.base.subsystems.SubsystemPneumatics;
import red.crusade.base.subsystems.SubsystemSensors;
import red.crusade.superclasses.CommandRC;
import red.crusade.superclasses.SubsystemRC;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * DO NOT EXTEND THIS CLASS. Use CommandRC instead.
 *
 * CommandBase creates and stores each subsystem. To access a subsystem elsewhere in your code in your code use either: CommandBase.SUBSYSTEM or CommandBase.subsystemList[SUBSYSTEM.systemID]
 * 
 * @author Sean Zammit
 */
public abstract class CommandBase extends Command
{
	public static OI oi;

	public static ArrayList<SubsystemRC> subsystemList = new ArrayList<SubsystemRC>();

	//Create an instance of each subsystem here.
	//Just as a note, this method of subsystem setup is quite experimental, so be wary of bugs.
	private static int id = 0;
	public static SubsystemRC sensors = (SubsystemRC) setupNewSubsystem(new SubsystemRC(id), new CommandReadSensors(id));
	public static SubsystemDriver driver = (SubsystemDriver) setupNewSubsystem(new SubsystemDriver(id), new CommandDrive(id));
	public static SubsystemPneumatics pneumatics = (SubsystemPneumatics) setupNewSubsystem(new SubsystemPneumatics(id), new CommandDoNothing(id));
	public static SubsystemCamera camera = (SubsystemCamera) setupNewSubsystem(new SubsystemCamera(id), new CommandDoNothing(id));

	public static Autonomous autonomous;

	public static void init() {
		//Don't move or change this. EVER.
		oi = new OI();

		//Set the sequence of commands run by autonomous here.
		autonomous = new Autonomous();

		//Calls the method in SubsystemRC that starts all sensors. Do not remove.
		SubsystemSensors.initSensors();

		//Not completely sure what this does. Leave it alone as it isn't necessary.
		SmartDashboard.putData(camera);
	}

	public CommandBase(String name) {
		super(name);
	}

	public CommandBase() {
		super();
	}

	/**
	 * Handles necessary procedures when creating a new subsystem.
	 */
	private static SubsystemRC setupNewSubsystem(SubsystemRC subsystem, CommandRC command) {
		subsystem.setDefCommand(command);
		id++;
		return subsystemList.get(subsystem.systemID);
	}
}
