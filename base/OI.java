package red.crusade.base;

import java.io.File;

import red.crusade.base.buttons.JoystickAxisButton;
import red.crusade.base.buttons.JoystickPOVButton;
import red.crusade.base.commands.*;
import red.crusade.base.commands.autonomous.Autonomous;
import red.crusade.base.commands.belt.CommandBelt;
import red.crusade.base.commands.belt.CommandBeltAnalog;
import red.crusade.base.commands.belt.CommandBeltBackward;
import red.crusade.base.commands.belt.CommandBeltForward;
import red.crusade.base.commands.binArm.flipper.CommandFlipBin;
import red.crusade.base.commands.binArm.flipper.CommandGrabBin;
import red.crusade.base.commands.binArm.flipper.CommandRetractFlipper;
import red.crusade.base.commands.binArm.flipper.CommandStackBin;
import red.crusade.base.commands.binArm.front.CommandBinArmFrontLower;
import red.crusade.base.commands.binArm.front.CommandBinArmFrontRaise;
import red.crusade.base.commands.binArm.front.CommandWaitForBinArmDown;
import red.crusade.base.commands.binArm.rear.CommandBinArmRearAnalog;
import red.crusade.base.commands.binArm.rear.CommandBinArmRearLower;
import red.crusade.base.commands.binArm.rear.CommandBinArmRearRaise;
import red.crusade.base.commands.binHook.CommandBinHook;
import red.crusade.base.commands.binHook.CommandBinHookRetract;
import red.crusade.base.commands.drive.*;
import red.crusade.base.commands.toteArm.*;
import red.crusade.base.commands.tower.*;
import red.crusade.superclasses.CommandRC;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.buttons.*;
import edu.wpi.first.wpilibj.communication.FRCNetworkCommunicationsLibrary;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import static red.crusade.base.commands.CommandBase.*;
import static red.crusade.base.RobotMap.*;

/**
 * This class is the glue that binds the controls on the physical operator interface to the commands and command groups that allow control of the robot.
 *
 * @author Sean Zammit
 */
@SuppressWarnings("unused")
public class OI
{
	private static final int teamNumber = 4613;
	
	public static int currentTotes = 0;
	@SuppressWarnings("all")
	public static final boolean areSolenoidsSingle = teamNumber == 4613 ? true : false;
	public static DriverStation ds = DriverStation.getInstance();
	
	public OI() {
		currentTotes = 0;
		Autonomous.initAutonomous();
		
		//Set what commands will run when buttons are pressed/held/released here.
		whenPressed(f_X, new CommandBinArmFrontLower());
		whenPressed(f_Y, new CommandBinArmFrontRaise());
		
		whenPressed(d2_11, new CommandInterrupt());

		whenPressed(f_RB, new CommandGrabBin());
		whenPressed(f_RT, new CommandStackBin());

		whenPressed(f_B, new CommandBeltForward());		
		whenPressed(f_A, new CommandBeltBackward());
		//whenPressed(f_LStick, new CommandBeltAnalog());

		whenPressed(f_Start, new CommandPush());
		//whenPressed(f_Back, new CommandAutomaticStack());
		whenPressed(f_Back, new CommandBinHook());
		whenReleased(f_Back, new CommandBinHookRetract());
		
		//FIXME Revert
		whenPressed(f_POV_U, new CommandTowerToReset());
		whenPressed(f_POV_D, new CommandTowerToBase());
		whenPressed(f_POV_L, new CommandDoNothing(tower));
		whenPressed(f_POV_R, new CommandDoNothing(tower));
		
		//FIXME Remove pneumatics test
		/*whenPressed(d1_6, new CommandDoubleSolenoid(binFlipper.flipper1Solenoid, true));
		whenPressed(d1_7, new CommandDoubleSolenoid(binFlipper.flipper1Solenoid, false));
		whenPressed(d1_8, new CommandVariablePneumaticsTest(binFlipper.flipper2Solenoid, true));
		whenPressed(d1_9, new CommandVariablePneumaticsTest(binFlipper.flipper2Solenoid, false));		
		whenPressed(d1_10, new CommandPneumaticsTest(binFlipper.binLockSolenoid, true));
		whenPressed(d1_11, new CommandPneumaticsTest(binFlipper.binLockSolenoid, false));
		
		whenPressed(d2_8, new CommandPneumaticsTest(binArmFront.binArmFrontSolenoid, true));
		whenPressed(d2_9, new CommandPneumaticsTest(binArmFront.binArmFrontSolenoid, false));*/

		whenPressed(f_YAxis_D, new CommandBinArmRearAnalog());
		whenPressed(f_YAxis_U, new CommandBinArmRearRaise());
				
		whenPressed(f_LB, new CommandToteArmDown());		
		whenPressed(f_LT, new CommandToteArmUp());
		
		/*whenPressed(f_RStick, new CommandTowerToReset()
		.setParallel(new CommandBinArmFrontLower()
		.setParallel(new CommandDoubleSolenoid(binFlipper.flipper1Solenoid, false))));*/
		
		whenHeld(d1_3, new CommandPullInTotesManual());
	}

	//Set up joysticks and buttons here.
	public static final Joystick stickDriver1 = new Joystick(0);
	public static final Button d1_T = new JoystickButton(stickDriver1, 1);
	public static final Button d1_2 = new JoystickButton(stickDriver1, 2);
	public static final Button d1_3 = new JoystickButton(stickDriver1, 3);
	public static final Button d1_4 = new JoystickButton(stickDriver1, 4);
	public static final Button d1_5 = new JoystickButton(stickDriver1, 5);
	public static final Button d1_6 = new JoystickButton(stickDriver1, 6);
	public static final Button d1_7 = new JoystickButton(stickDriver1, 7);
	public static final Button d1_8 = new JoystickButton(stickDriver1, 8);
	public static final Button d1_9 = new JoystickButton(stickDriver1, 9);
	public static final Button d1_10 = new JoystickButton(stickDriver1, 10);
	public static final Button d1_11 = new JoystickButton(stickDriver1, 11);

	public static final Joystick stickDriver2 = new Joystick(1);
	public static final Button d2_T = new JoystickButton(stickDriver2, 1);
	public static final Button d2_2 = new JoystickButton(stickDriver2, 2);
	public static final Button d2_3 = new JoystickButton(stickDriver2, 3);
	public static final Button d2_4 = new JoystickButton(stickDriver2, 4);
	public static final Button d2_5 = new JoystickButton(stickDriver2, 5);
	public static final Button d2_6 = new JoystickButton(stickDriver2, 6);
	public static final Button d2_7 = new JoystickButton(stickDriver2, 7);
	public static final Button d2_8 = new JoystickButton(stickDriver2, 8);
	public static final Button d2_9 = new JoystickButton(stickDriver2, 9);
	public static final Button d2_10 = new JoystickButton(stickDriver2, 10);
	public static final Button d2_11 = new JoystickButton(stickDriver2, 11);

	public static final Joystick stickFunction = new Joystick(2);
	public static final Button f_X = new JoystickButton(stickFunction, 1);
	public static final Button f_A = new JoystickButton(stickFunction, 2);
	public static final Button f_B = new JoystickButton(stickFunction, 3);
	public static final Button f_Y = new JoystickButton(stickFunction, 4);
	public static final Button f_LB = new JoystickButton(stickFunction, 5);
	public static final Button f_RB = new JoystickButton(stickFunction, 6);
	public static final Button f_LT = new JoystickButton(stickFunction, 7);
	public static final Button f_RT = new JoystickButton(stickFunction, 8);
	public static final Button f_Back = new JoystickButton(stickFunction, 9);
	public static final Button f_Start = new JoystickButton(stickFunction, 10);
	public static final Button f_LStick = new JoystickButton(stickFunction, 11);
	public static final Button f_RStick = new JoystickButton(stickFunction, 12);

	public static final Button f_POV_U = new JoystickPOVButton(stickFunction, 0);
	public static final Button f_POV_R = new JoystickPOVButton(stickFunction, 90);
	public static final Button f_POV_D = new JoystickPOVButton(stickFunction, 180);
	public static final Button f_POV_L = new JoystickPOVButton(stickFunction, 270);

	public static final Button f_YAxis_U = new JoystickAxisButton(stickFunction, AxisType.kY, true, 0.9D);
	public static final Button f_YAxis_D = new JoystickAxisButton(stickFunction, AxisType.kY, false, 0.9D);

	private void whenPressed(Button button, CommandRC command) {
		button.whenPressed(command);
	}

	private void whenHeld(Button button, CommandRC command) {
		button.whenPressed(command.setCancelWhenReleased(button));
	}

	private void whenReleased(Button button, CommandRC command) {
		button.whenReleased(command);
	}

	private void cancelWhenPressed(Button button, CommandRC command) {
		button.cancelWhenPressed(command);
	}

	private void toggleWhenPressed(Button button, CommandRC command) {
		button.toggleWhenPressed(command);
	}

	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// Another type of button you can create is a DigitalIOButton, which is
	// a button or switch hooked up to the cypress module. These are useful if
	// you want to build a customized operator interface.
	// Button button = new DigitalIOButton(1);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Start the command repeatedly while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released  and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
