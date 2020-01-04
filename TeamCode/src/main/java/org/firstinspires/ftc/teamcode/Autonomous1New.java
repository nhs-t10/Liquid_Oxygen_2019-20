package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous (name = "Forward about a foot")
public class Autonomous1New extends Library {
    float [] omniValues = new float [4];
    int step = 1;
    public boolean isYellow(){
        return false;
    }
    public void init() {
        hardwareInit();
    }
    public void loop() {
        forward(inchConversion(12));
        waitFor(30000);
       /** switch (step) {
            case (1):
                right (inchConversion(  29));
                openClaw();
                step++;
                break;
            case (2):
                back (inchConversion( 60));
                if (isYellow() == false){
                    drive (0, 0, 0, 0);
                    step++;
                    break;
                }
            case (3):
                back (inchConversion(25));
                step++;
                break;
            case (4):
                right (inchConversion(6));
                step++;
                break;
            case (5):
                forward (inchConversion(2));
                step++;
                break;
            case (6):
                closeClaw();
                step++;
                break;
            case (7):
                left (inchConversion(12));
                step++;
                break;
            case (8):
                forward (inchConversion(96));
                step++;
                break;
        }

        telemetry.addData("Step ", step);
        telemetry.addData("Yellow? ", isYellow());

        telemetry.update();
*/

    }
}

