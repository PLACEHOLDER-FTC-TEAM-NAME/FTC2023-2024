package org.firstinspires.ftc.teamcode.swiftbot.robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;

import org.firstinspires.ftc.teamcode.swiftbot.constants.MecanumConstants;

public abstract class MecanumRobot {
    public MecanumConstants constants;
    public MecanumRobot(MecanumConstants constants){
        this.constants = constants;
    }

    public abstract DcMotor getBackLeft();
    public abstract DcMotor getBackRight();
    public abstract DcMotor getFrontLeft();
    public abstract DcMotor getFrontRight();
    public abstract DigitalChannel getOdoParallel1();
    public abstract DigitalChannel getOdoParallel2();
    public abstract DigitalChannel getOdoPerp2();
}
