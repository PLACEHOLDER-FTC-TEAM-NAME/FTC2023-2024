package org.firstinspires.ftc.teamcode.config;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.swiftbot.constants.MecanumConstants;
import org.firstinspires.ftc.teamcode.swiftbot.robot.MecanumRobot;

public class NexusMecanumDrive extends MecanumRobot {

    public DcMotor leftFront;
    public DcMotor leftBack;
    public DcMotor rightFront;
    public DcMotor rightBack;

    public DigitalChannel dcParallelDeadWheel1;
    public DigitalChannel dcParallelDeadWheel2;
    public DigitalChannel dcPerpendicularDeadWheel;

    public NexusMecanumDrive(MecanumConstants constants, HardwareMap hardwareMap) {
        super(constants);
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");

        dcParallelDeadWheel1 = hardwareMap.get(DigitalChannel.class, "dcParallelDeadWheel1");
        dcParallelDeadWheel2 = hardwareMap.get(DigitalChannel.class, "dcParallelDeadWheel2");
        dcPerpendicularDeadWheel = hardwareMap.get(DigitalChannel.class, "dcPerpendicularDeadWheel");
    }

    @Override
    public DcMotor getBackLeft() {
        return leftBack;
    }

    @Override
    public DcMotor getBackRight() {
        return rightBack;
    }

    @Override
    public DcMotor getFrontLeft() {
        return leftFront;
    }

    @Override
    public DcMotor getFrontRight() {
        return rightFront;
    }

    @Override
    public DigitalChannel getOdoParallel1() {
        return dcParallelDeadWheel1;
    }

    @Override
    public DigitalChannel getOdoParallel2() {
        return dcParallelDeadWheel2;
    }

    @Override
    public DigitalChannel getOdoPerp2() {
        return dcPerpendicularDeadWheel;
    }
}
