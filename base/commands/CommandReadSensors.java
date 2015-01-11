package red.crusade.base.commands;

import red.crusade.base.OI;
import red.crusade.base.subsystems.SubsystemRC;
import red.crusade.superclasses.CommandRC;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author Sean Zammit
 */
public class CommandReadSensors extends CommandRC {
    
    public CommandReadSensors(int requiredSystem) {
        super(requiredSystem);
    }

    //Set up what the robot will do while this command is running.
    protected void execute() {
        //Put any code here needed to handle readings from sensors.
    }

    //Determine the conditions that will stop this command.
    protected boolean isFinished() {
        return false;
    }
}
