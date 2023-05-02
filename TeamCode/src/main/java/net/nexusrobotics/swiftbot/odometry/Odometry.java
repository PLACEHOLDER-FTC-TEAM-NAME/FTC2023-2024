package net.nexusrobotics.swiftbot.odometry;

import net.nexusrobotics.swiftbot.constants.MecanumConstants;
import net.nexusrobotics.swiftbot.localization.Localization;
import net.nexusrobotics.swiftbot.robot.MecanumRobot;

public class Odometry {
    MecanumRobot robot;
    MecanumConstants constants;
    Localization localization;
    int timederivative = 10;
    float odoDiameter;

    public Odometry(MecanumRobot robot, Localization localization){
        this.constants = robot.constants;
        this.robot = robot;
        this.localization = localization;
        this.odoDiameter = constants.deadwheeldiameter;
    }

    public void init(){
        new Thread(()->{
            int lastPosP1 = robot.getOdoParallel1().getCurrentPosition();
            int lastPosP2 = robot.getOdoParallel2().getCurrentPosition();
            int lastPosPerp = robot.getOdoPerp().getCurrentPosition();
            while(true){
                int dP1 = robot.getOdoParallel1().getCurrentPosition() - lastPosP1;
                int dP2 = robot.getOdoParallel2().getCurrentPosition() - lastPosP2;
                int dPerp = robot.getOdoPerp().getCurrentPosition() - lastPosPerp;

                double odoCircumference = odoDiameter*Math.PI;

                double dOdoPerp = odoCircumference*(dPerp/constants.ticks_per_rotation); // in same unit as diameter (inches)
                double dOdoP1 = odoCircumference*(dP1/constants.ticks_per_rotation); // in same unit as diameter (inches)
                double dOdoP2 = odoCircumference*(dP2/constants.ticks_per_rotation); // in same unit as diameter (inches)

                if((dP1 > 0)&&(dP2 < 0) || (dP2 > 0)&&(dP1 < 0)){ // check if parallel odo wheels are moving in opposite directions
                    // 1 is right, 2 is left
                    int direction = dPerp > 0 ? 2 : 1; // may be debug idk
                    localization.setHeading((float) (localization.currentHeading + (360*(dOdoPerp/(2*constants.odoperptocenter*Math.PI)))));
                }

                lastPosP1 = robot.getOdoParallel1().getCurrentPosition();
                lastPosP2 = robot.getOdoParallel2().getCurrentPosition();
                lastPosPerp = robot.getOdoPerp().getCurrentPosition();
                try {
                    Thread.sleep(timederivative);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
