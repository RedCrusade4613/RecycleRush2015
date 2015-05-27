/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008-2012. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package red.crusade.base.buttons;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Button;

/**
 *
 * @author bradmiller, Sean Zammit
 */
public class JoystickPOVButton extends Button {

    GenericHID m_joystick;
    int m_angle;

    /**
     * Create a joystick POV 'button' for triggering commands
     * @param joystick The GenericHID object that has the button (e.g. Joystick, KinectStick, etc)
     * @param angle The required angle for the POV
     */
    public JoystickPOVButton(GenericHID joystick, int angle) {
        m_joystick = joystick;
        m_angle = angle;
    }

    /**
     * Gets the value of the joystick button
     * @return Whether the POV is at a certain angle
     */
    public boolean get() {
        return m_joystick.getPOV() == m_angle;
    }
}
