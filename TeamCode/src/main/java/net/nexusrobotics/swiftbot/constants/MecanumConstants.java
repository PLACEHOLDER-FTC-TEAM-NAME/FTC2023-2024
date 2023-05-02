package net.nexusrobotics.swiftbot.constants;

public class MecanumConstants extends Constants{
    public float forward_compensation;
    public float side_weight_compensation;
    public float accel_time;
    public float accel_distance;
    public float deadwheeldiameter;
    public int ticks_per_rotation;
    public float odoperptocenter;

    public MecanumConstants(float deadwheeldiameter, int ticks_per_rotation){
        this.deadwheeldiameter = deadwheeldiameter;
        this.ticks_per_rotation = ticks_per_rotation;
    }
}
