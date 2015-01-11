package red.crusade.base;

import red.crusade.base.commands.CommandBase;
import red.crusade.base.commands.camera.CommandCamera;
import red.crusade.base.commands.drive.CommandSwitchDirection;
import red.crusade.base.commands.pneumatics.CommandPneumatics;
import red.crusade.superclasses.CommandRC;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator interface to the commands and command groups that allow control of the robot.
 */
@SuppressWarnings("unused")
public class OI
{
	//Set up joysticks and buttons here.
	public static final Joystick stickDriver = new Joystick(0);
	public static final Button trigger = new JoystickButton(stickDriver, 1);
	public static final Button button2 = new JoystickButton(stickDriver, 2);
	public static final Button button3 = new JoystickButton(stickDriver, 3);
	public static final Button button4 = new JoystickButton(stickDriver, 4);
	public static final Button button7 = new JoystickButton(stickDriver, 7);

	public static final Joystick stickFunction = new Joystick(2);

	public OI() {
		//Set what commands will run when buttons are pressed/held/released here.
		whenHeld(button2, new CommandPneumatics(CommandBase.pneumatics.systemID));
		whenPressed(button3, new CommandSwitchDirection(true));
		whenPressed(button4, new CommandSwitchDirection(false));
		//button7.whenPressed(new CommandCamera(CommandBase.camera.systemID).setWhenHeld(button7));
	}

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
