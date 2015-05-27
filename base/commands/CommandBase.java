package red.crusade.base.commands;

import java.util.ArrayList;

import red.crusade.base.OI;
import red.crusade.base.commands.binArm.rear.CommandBinArmRearAnalog;
import red.crusade.base.commands.drive.CommandDrive;
import red.crusade.base.subsystems.*;
import red.crusade.superclasses.SubsystemRC;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * DO NOT EXTEND THIS CLASS. Use CommandRC instead.
 *
 * CommandBase creates and stores each subsystem. To access a subsystem elsewhere in your code use either: CommandBase.SUBSYSTEM or CommandBase.subsystemList[SUBSYSTEM.systemID]
 * 
 * @author Sean Zammit
 */
public abstract class CommandBase extends Command
{
	public static OI oi;

	public static ArrayList<SubsystemRC> subsystemList = new ArrayList<SubsystemRC>();

	//Do not remove. Is used to set up each subsystem.
	public static int id = 0;

	//Create an instance of each subsystem here.
	public static SubsystemSensors sensors = new SubsystemSensors();
	public static SubsystemDriver driver = new SubsystemDriver();
	public static SubsystemTower tower = new SubsystemTower();
	public static SubsystemBelt belt = new SubsystemBelt();
	public static SubsystemToteArm toteArm = new SubsystemToteArm();
	public static SubsystemBinArmFront binArmFront = new SubsystemBinArmFront();
	public static SubsystemBinArmRear binArmRear = new SubsystemBinArmRear();
	public static SubsystemBinFlipper binFlipper = new SubsystemBinFlipper();
	public static SubsystemBinHook binHook = new SubsystemBinHook();
	
	public static void init() {
		sensors.setDefCommand(new CommandReadSensors());
		driver.setDefCommand(new CommandDrive());
		tower.setDefCommand(new CommandDoNothing(tower));
		belt.setDefCommand(new CommandDoNothing(belt));
		toteArm.setDefCommand(new CommandDoNothing(toteArm));
		binArmFront.setDefCommand(new CommandDoNothing(binArmFront));
		binArmRear.setDefCommand(new CommandBinArmRearAnalog());
		binFlipper.setDefCommand(new CommandDoNothing(binFlipper));
		binHook.setDefCommand(new CommandDoNothing(binHook));
		
		//Don't move or change this. EVER.
		oi = new OI();

		//Calls the method in SubsystemSensors that starts all sensors. Do not remove.
		sensors.initSensors();

		//Adds information from all subsystems to the dashboard.
		for(int a = 0; a < subsystemList.size(); a++) SmartDashboard.putData(subsystemList.get(a));
		SmartDashboard.putNumber("Number of subsystems", id);
	}

	public CommandBase(String name) {
		super(name);
	}

	public CommandBase() {
		super();
	}
}
