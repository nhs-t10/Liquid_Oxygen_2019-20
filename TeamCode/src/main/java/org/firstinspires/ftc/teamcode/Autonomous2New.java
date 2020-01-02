package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class Autonomous1New extends Library {
    float [] omniValues = new float [4];
    int step = 1;
    public boolean isYellow(){
        return false;
    }
    public float inchConversion(float inches){
        return inches/4;
    }
    public void drive(float x, float y, float h, float k){
        lf.setPower(-x);
        lb.setPower(-y);
        rf.setPower(h);
        rb.setPower(k);
    }
    public void forward (float rotations) {
        int position = lf.getCurrentPosition();
        while (lf.getCurrentPosition() < position - (rotations * 560)) {
            lf.setPower(-1);
            lb.setPower(-1);
            rf.setPower(1);
            rb.setPower(1);
        }
        lf.setPower(0);
        lb.setPower(0);
        rf.setPower(0);
        rb.setPower(0);
    }
    public void right (float rotations) {
        int position = lf.getCurrentPosition();
        while (lf.getCurrentPosition() < position - (rotations * 560)) {
            lf.setPower(-1);
            lb.setPower(-1);
            rf.setPower(-1);
            rb.setPower(-1);
        }
        lf.setPower(0);
        lb.setPower(0);
        rf.setPower(0);
        rb.setPower(0);
    }
    public void left (float rotations) {
        int position = lf.getCurrentPosition();
        while (lf.getCurrentPosition() < position + (rotations * 560)) {
            lf.setPower(1);
            lb.setPower(1);
            rf.setPower(1);
            rb.setPower(1);
        }
        lf.setPower(0);
        lb.setPower(0);
        rf.setPower(0);
        rb.setPower(0);
    }
    public void back (float rotations) {
        int position = lf.getCurrentPosition();
        while (lf.getCurrentPosition() < position + (rotations * 560)) {
            lf.setPower(1);
            lb.setPower(1);
            rf.setPower(-1);
            rb.setPower(-1);
        }
        lf.setPower(0);
        lb.setPower(0);
        rf.setPower(0);
        rb.setPower(0);
    }

    public void init() {
        hardwareInit();
    }
    public void loop() {
        switch (step) {
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


    }
}

