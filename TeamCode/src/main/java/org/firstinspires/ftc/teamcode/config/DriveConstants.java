package org.firstinspires.ftc.teamcode.config;

import net.nexusrobotics.swiftbot.constants.MecanumConstants;

public class DriveConstants extends MecanumConstants {
    static float deadwheeldiameter = 3;
    static int ticks_per_rotation = 360;
    public DriveConstants() {
        super(deadwheeldiameter, ticks_per_rotation);
    }
}
