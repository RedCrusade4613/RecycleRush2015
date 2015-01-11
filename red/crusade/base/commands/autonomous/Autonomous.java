package red.crusade.base.commands.autonomous;

import red.crusade.superclasses.CommandRC;

/**
 *
 * @author Sean Zammit
 */
public class Autonomous extends CommandRC {

    public Autonomous() {
        super(-1);
    }
    
    //Set up what the robot will do while this command is running.
    protected void execute() {
    }

    //Determine the conditions that will stop this command.
    protected boolean isFinished() {
        return true;
    }
}
