package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import static java.lang.Thread.sleep;
@Autonomous (name = "Forward about a foot")
public class Autonomous1New extends Library {
    float [] omniValues = new float [4];
    int step = 1;
    ElapsedTime timer;
    public boolean isYellow(){
        return false;
    }
    public void init() {
        hardwareInit();

    }
    public void loop() {
        switch (step){
            case (1):
                timer = new ElapsedTime();
                step++;
                break;
            case(2):
                drive(0.7f,0.7f,0.7f,0.7f);
                if (timer.milliseconds() > 500){
                   drive(0,0,0,0);
                   step++;
                   break;
                }
            case(3):
                telemetry.addLine("Autonomous Complete");
                telemetry.update();
        }
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
    @Override
    public void stop(){
        super.stop();
    }
}

