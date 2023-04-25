package org.firstinspires.ftc.teamcode.opmode.driven;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class GetVelocity extends OpMode {

    @Override
    public void init() {
        BNO055IMU imu= hardwareMap.get(BNO055IMU.class, "imu");
        double velo = Math.sqrt(Math.pow(imu.getVelocity().yVeloc, 2)+Math.pow(imu.getVelocity().xVeloc, 2));
       telemetry.addData("velocity", velo + "");
    }

    @Override
    public void loop() {

    }
}
