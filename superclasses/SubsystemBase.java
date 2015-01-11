package red.crusade.superclasses;

import red.crusade.base.commands.CommandBase;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Sean Zammit
 */
public class SubsystemBase extends Subsystem {
    public int systemID;
    
    public SubsystemBase(int id) {
        super();
        systemID = id;
        CommandBase.addToSubsystemList(this);
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
