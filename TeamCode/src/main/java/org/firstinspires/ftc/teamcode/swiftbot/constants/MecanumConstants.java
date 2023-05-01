package org.firstinspires.ftc.teamcode.swiftbot.constants;

public class MecanumConstants extends Constants{
    float forward_compensation;
    float side_weight_compensation;
    float accel_time;
    float accel_distance;
    float deadwheeldiameter;

    public MecanumConstants(float deadwheeldiameter){
        this.deadwheeldiameter = deadwheeldiameter;
    }
}
