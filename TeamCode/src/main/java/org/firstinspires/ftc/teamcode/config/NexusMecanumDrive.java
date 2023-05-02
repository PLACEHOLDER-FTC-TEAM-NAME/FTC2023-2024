package org.firstinspires.ftc.teamcode.config;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.HardwareMap;

import net.nexusrobotics.swiftbot.constants.MecanumConstants;
import net.nexusrobotics.swiftbot.robot.MecanumRobot;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.robotcore.external.hardware.camera.Camera;

public class NexusMecanumDrive extends MecanumRobot {

    public DcMotor leftFront;
    public DcMotor leftBack;
    public DcMotor rightFront;
    public DcMotor rightBack;

    public DcMotorEx dcParallelDeadWheel1;
    public DcMotorEx dcParallelDeadWheel2;
    public DcMotorEx dcPerpendicularDeadWheel;

    public Camera camera;

    public NexusMecanumDrive(MecanumConstants constants, HardwareMap hardwareMap) {
        super(constants);
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");

        dcParallelDeadWheel1 = hardwareMap.get(DcMotorEx.class, "dcParallelDeadWheel1");
        dcParallelDeadWheel2 = hardwareMap.get(DcMotorEx.class, "dcParallelDeadWheel2");
        dcPerpendicularDeadWheel = hardwareMap.get(DcMotorEx.class, "dcPerpendicularDeadWheel");
        dcParallelDeadWheel2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        dcParallelDeadWheel1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        dcPerpendicularDeadWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        camera = hardwareMap.get(Camera.class, "camera");
        registerPart("camera", (HardwareDevice) camera);
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
    public DcMotorEx getOdoParallel1() {
        return dcParallelDeadWheel1;
    }

    @Override
    public DcMotorEx getOdoParallel2() {
        return dcParallelDeadWheel2;
    }

    @Override
    public DcMotorEx getOdoPerp() {
        return dcPerpendicularDeadWheel;
    }

    @Override
    public HardwareDevice getCustomPartCast(Class<? extends HardwareDevice> partClass, String part){
        return partClass.cast(customParts.get(part));
    }

    @Override
    public HardwareDevice getCustomPart(String part){
        return customParts.get(part);
    }
}
