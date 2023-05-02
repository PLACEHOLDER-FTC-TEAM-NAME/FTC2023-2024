package org.firstinspires.ftc.teamcode.opmode.test;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import net.nexusrobotics.swiftbot.localization.Localization;
import net.nexusrobotics.swiftbot.odometry.Odometry;

import org.firstinspires.ftc.teamcode.config.DriveConstants;
import org.firstinspires.ftc.teamcode.config.NexusMecanumDrive;

public class AutoTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        NexusMecanumDrive robot = new NexusMecanumDrive(new DriveConstants(), hardwareMap);
        Localization localization = new Localization(10, 10, 0, 0, 0);
        Odometry odometry = new Odometry(robot, localization);

        waitForStart();

    }
}
