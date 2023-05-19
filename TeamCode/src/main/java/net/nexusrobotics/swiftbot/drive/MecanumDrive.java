package net.nexusrobotics.swiftbot.drive;

import net.nexusrobotics.swiftbot.odometry.Odometry;
import net.nexusrobotics.swiftbot.robot.MecanumRobot;

import java.util.HashMap;

public class MecanumDrive {
    Odometry odometry;
    MecanumRobot robot;
    float targetX;
    float targetY;
    float targetHeading;
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
            float toRotate = targetHeading - odometry.localization.currentHeading;
            float toX = targetX - odometry.localization.currentX;
            float toY = targetY - odometry.localization.currentY;

            float forwardX = getOneFromForward(odometry.localization.currentHeading).get("x");
            float forwardY = getOneFromForward(odometry.localization.currentHeading).get("y");
            float rightX = getOneFromForward(odometry.localization.currentHeading + 90).get("x");
            float rightY = getOneFromForward(odometry.localization.currentHeading + 90).get("y");

            if(toRotate > 0){

            }else if(toX > 0 || toY > 0){

            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    HashMap<String, Float> getOneFromForward(float heading){
        heading = (float) Math.toRadians(heading);
        HashMap<String, Float> map = new HashMap<>();
        map.put("x", (float)Math.sin(heading));
        map.put("y", (float)Math.cos(heading));
        return map;
    }
}
