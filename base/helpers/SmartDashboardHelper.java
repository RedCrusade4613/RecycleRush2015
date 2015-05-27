package red.crusade.base.helpers;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SmartDashboardHelper
{
	public static Object getAndPutInfo(String key, Object defaultValue) {
		if(defaultValue instanceof Integer || defaultValue instanceof Double) {
			double a = SmartDashboard.getNumber(key, (double) defaultValue);
			SmartDashboard.putNumber(key, a);
			return a;
		}
		else if(defaultValue instanceof Boolean) {
			boolean a = SmartDashboard.getBoolean(key, (boolean) defaultValue);
			SmartDashboard.putBoolean(key, a);
			return a;
		}

		Sendable a = SmartDashboard.getData(key);
		SmartDashboard.putData(key, a);
		return a;
	}
}
