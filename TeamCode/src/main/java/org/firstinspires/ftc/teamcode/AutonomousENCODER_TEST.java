package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name = "ENCODER_TEST")
public class AutonomousENCODER_TEST extends Library {
    float [] omniValues = new float [4];
    int step = 1;
    ElapsedTime timer;
    public boolean isYellow(){
        return false;
    }
    public void init() {
        hardwareInit();
        lb.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        lf.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rf.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rb.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    public void loop() {
        switch (step){
            case (1):
                timer = new ElapsedTime();
                step++;
                break;
            case (2):
                lf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                lb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                rf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                rb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                lf.setTargetPosition(1000);
                lb.setTargetPosition(1000);
                rf.setTargetPosition(1000);
                rb.setTargetPosition(1000);
                step++;
                break;
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

