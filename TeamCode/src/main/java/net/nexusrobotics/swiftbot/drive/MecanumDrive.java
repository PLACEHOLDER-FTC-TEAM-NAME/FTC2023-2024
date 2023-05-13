package net.nexusrobotics.swiftbot.drive;

import net.nexusrobotics.swiftbot.odometry.Odometry;
import net.nexusrobotics.swiftbot.robot.MecanumRobot;

public class MecanumDrive {
    Odometry odometry;
    MecanumRobot robot;
    float targetX;
    float targetY;
    public MecanumDrive(Odometry odometry, MecanumRobot robot){
        this.odometry = odometry;
        this.robot = robot;
    }
    public void init(){
        odometry.init();
        targetX = odometry.localization.currentX;
        targetY = odometry.localization.currentY;
        loop();
    }

    void loop(){
        new Thread(()->{
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
