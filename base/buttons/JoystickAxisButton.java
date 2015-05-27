/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008-2012. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package red.crusade.base.buttons;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.buttons.Button;

/**
 *
 * @author bradmiller, Sean Zammit
 */
public class JoystickAxisButton extends Button {

    GenericHID m_joystick;
    int m_axis;
    boolean m_negative;
    double m_triggerPoint;

    /**
     * Create a joystick axis 'button' for triggering commands
     * @param joystick The GenericHID object that has the button (e.g. Joystick, KinectStick, etc)
     * @param angle The required angle for the POV
     */
    public JoystickAxisButton(GenericHID joystick, AxisType axis, boolean negative, double triggerPoint) {
        m_joystick = joystick;
        m_axis = axis.value;
        m_negative = negative;
        m_triggerPoint = triggerPoint;
    }

    /**
     * Gets the value of the joystick button
     * @return Whether the axis is at a certain position
     */
    public boolean get() {
        return m_negative ? m_joystick.getRawAxis(m_axis) < -m_triggerPoint : m_joystick.getRawAxis(m_axis) > m_triggerPoint;
    }
}
