package red.crusade.base.solenoids;

import red.crusade.base.commands.CommandDoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SolenoidBase;

public class VariableSolenoid
{
	public SolenoidBase solenoid;
	
	public VariableSolenoid(int port1, int port2, boolean isSingle) {
		solenoid = isSingle ? new Solenoid(port1) : new DoubleSolenoid(port1, port2);
	}
	
	public void set(boolean on) {
		if(solenoid instanceof Solenoid) ((Solenoid) solenoid).set(on);
		else if(solenoid instanceof DoubleSolenoid) new CommandDoubleSolenoid((DoubleSolenoid) solenoid, on).start();
	}
}
