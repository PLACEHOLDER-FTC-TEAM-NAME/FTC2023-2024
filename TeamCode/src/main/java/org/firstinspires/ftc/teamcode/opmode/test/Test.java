package org.firstinspires.ftc.teamcode.opmode.test;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.config.DriveConstants;
import org.firstinspires.ftc.teamcode.config.NexusMecanumDrive;
import org.firstinspires.ftc.teamcode.swiftbot.robot.MecanumRobot;

public class Test extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        MecanumRobot robot = new NexusMecanumDrive(new DriveConstants(), hardwareMap);
        robot.getBackLeft();
    }
}
