package net.nexusrobotics.swiftbot.robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareDevice;

import net.nexusrobotics.swiftbot.constants.MecanumConstants;

import java.nio.ByteBuffer;
import java.util.HashMap;

public abstract class MecanumRobot {
    public MecanumConstants constants;
    public HashMap<String, HardwareDevice> customParts = new HashMap<>();

    public MecanumRobot(MecanumConstants constants){
        this.constants = constants;
    }

    public abstract DcMotor getBackLeft();
    public abstract DcMotor getBackRight();
    public abstract DcMotor getFrontLeft();
    public abstract DcMotor getFrontRight();
    public abstract DcMotorEx getOdoParallel1();
    public abstract DcMotorEx getOdoParallel2();
    public abstract DcMotorEx getOdoPerp();
    public abstract HardwareDevice getCustomPartCast(Class<? extends HardwareDevice> partClass, String part);
    public abstract HardwareDevice getCustomPart(String part);

    public void registerPart(String name, HardwareDevice part){
        customParts.put(name, part);
    }
}
