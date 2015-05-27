package red.crusade.base.commands.autonomous;

import static red.crusade.base.RobotMap.*;
import red.crusade.base.commands.CommandInterruptCommand;
import red.crusade.base.commands.CommandPneumaticsTest;
import red.crusade.base.commands.CommandPullInTotes;
import red.crusade.base.commands.CommandWait;
import red.crusade.base.commands.belt.CommandBelt;
import red.crusade.base.commands.binArm.flipper.CommandGrabBin;
import red.crusade.base.commands.binArm.rear.CommandBinArmRearRaise;
import red.crusade.base.commands.binHook.CommandBinHook;
import red.crusade.base.commands.drive.CommandPDMove;
import red.crusade.base.commands.drive.CommandTurnDegrees;
import red.crusade.base.commands.toteArm.CommandToteArmUp;
import red.crusade.base.commands.tower.CommandPush;
import red.crusade.base.commands.tower.CommandTowerToBase;
import red.crusade.base.commands.tower.CommandTowerToReset;
import red.crusade.base.commands.tower.CommandWaitForTote;
import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Sean Zammit
 */
public class Autonomous extends CommandRC
{
	public Autonomous() {super(null);}
	protected void execute() {}
	protected boolean isDone() {return true;}
	protected void onCompletion() {}
	
	public static Autonomous[] autonomous = new Autonomous[5];
	
	public static void initAutonomous() {
		//Set the sequence of commands run by each version of autonomous here.
		
		//Do nothing
		autonomous[0] = new Autonomous();

		CommandPullInTotes cpit = new CommandPullInTotes();

		//String auto
		autonomous[1] = (Autonomous) new Autonomous().setSequential(
				new CommandTowerToBase().setParallel(
						new CommandBinArmRearRaise().setParallel(
								new CommandGrabBin(true).setParallel(
										new CommandWait(0.5D).setParallel(
												new CommandWait(1D),
												new CommandPneumaticsTest(binArmFront.binArmFrontSolenoid, true)
										),
										cpit
								)
						)
				),
				new CommandWait(1.5D).setParallel(
						new CommandBelt(polycordSpeedForward)
				),
				new CommandTowerToReset(),
				new CommandWaitForTote(), 
				new CommandTowerToBase(), 
				new CommandTowerToReset(), 
				new CommandWaitForTote(), 
				new CommandTowerToBase().setParallel(
						new CommandToteArmUp(),
						new CommandTurnDegrees(45, 1D, -1D),
						new CommandPDMove(1250, -0.7D),
						new CommandTurnDegrees(45, -1D, 1D),
						new CommandTowerToBase(),
						new CommandPush().setParallel(
								new CommandWait(0.5D), 
								new CommandPDMove(300, -0.7D)
						)
				), 
				new CommandInterruptCommand(cpit),
				new CommandBelt(0)
		);
		
		autonomous[2] = (Autonomous) new Autonomous().setSequential(
				new CommandTowerToBase().setParallel(
						new CommandBinArmRearRaise().setParallel(
								new CommandGrabBin(true).setParallel(
										new CommandWait(0.5D).setParallel(
												new CommandWait(1D),
												new CommandPneumaticsTest(binArmFront.binArmFrontSolenoid, true)
										),
										cpit
								)
						)
				),
				new CommandWait(1.5D).setParallel(
						new CommandBelt(polycordSpeedForward)
				),
				new CommandTowerToReset(),
				new CommandWaitForTote(), 
				new CommandTowerToBase(), 
				new CommandTowerToReset(), 
				new CommandWaitForTote(), 
				new CommandTowerToBase().setParallel(
						new CommandToteArmUp(),
						new CommandTurnDegrees(45, -1D, 1D),
						new CommandPDMove(1400, 0.7D),
						new CommandTowerToBase(),
						new CommandPush().setParallel(
								new CommandWait(0.5D), 
								new CommandPDMove(300, -0.7D)
						)
				), 
				new CommandInterruptCommand(cpit),
				new CommandBelt(0)
		);
		
		autonomous[3] = (Autonomous) new Autonomous().setSequential(
				new CommandBinHook().setParallel(
						new CommandWait(0.5D),
						new CommandPDMove(1000, 1D)
				)
		);
		
		autonomous[4] = (Autonomous) new Autonomous().setSequential(
				new CommandBinHook()
		);
	}
}
