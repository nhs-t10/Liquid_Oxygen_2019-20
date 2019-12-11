package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Driving Speed Test")
public class TeleOpExpiriments extends Library {
    public void init(){
        hardwareInit();
    }
    public void loop(){
        updateShortcuts();
        omniValues [0] = lY + rX + lX;
        omniValues [1] = lY + rX - lX;
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
        for (int i = 0; i<4;i++){
            omniValues[i] = omniValues[i]*speed;
        }
        drive(omniValues[0]*speed, omniValues[1]*speed, omniValues[2]*speed, omniValues[3]*speed);


        if (gamepad1.a){
            speed = speed+0.1f;
            waitFor(200);
        }
        if (gamepad1.b){
            speed = speed-0.1f;
            waitFor(200);
        }
        if (gamepad1.x){
            speed = speed+0.01f;
            waitFor(200);
        }
        if (gamepad1.y){
            speed = speed-0.01f;
            waitFor(200);
        }
        telemetry.addData("lf power: ", lf.getPower());
        telemetry.addData("lb power: ", lb.getPower());
        telemetry.addData("rf power: ", rf.getPower());
        telemetry.addData("rb power: ", rb.getPower());
        telemetry.addData("Speed",speed);

        telemetry.update();
    }

    @Override
    public void stop() {
        super.stop();
    }
}
