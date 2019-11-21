package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Test Please")
public class TeleOpExpiriments extends Library {
    public void init(){
        hardwareInit();
    }
    public void loop(){
        float lY = gamepad1.left_stick_y;
        float lX = gamepad1.left_stick_y;
        float rX = gamepad1.right_stick_x;
        omniValues [0] = lY + rX - lX;
        omniValues [1] = lY + rX + lX;
        omniValues [2] = lY - rX - lX;
        omniValues [3] = lY - rX + lX;

        float highest = 0;
        for (int i=0; i<4; i++) {
            if(Math.abs(omniValues[i]) > highest) {
                highest = Math.abs(omniValues[i]);
            }
        }
        if(highest > 1) {
            for (int i = 0; i<4; i++){
                omniValues[i] = omniValues[i] / highest;
            }
        }
        drive(omniValues[0], omniValues[1], omniValues[2], omniValues[3]);
        lift();
        clawControl(gamepad1.a);

        telemetry.addData("LY: ", lY);
        telemetry.addData("LY Input", gamepad1.left_stick_y);
        telemetry.addData("lf power: ", lf.getPower());
        telemetry.addData("lb power: ", lb.getPower());
        telemetry.addData("rf power: ", rf.getPower());
        telemetry.addData("rb power: ", rb.getPower());
    }
}
