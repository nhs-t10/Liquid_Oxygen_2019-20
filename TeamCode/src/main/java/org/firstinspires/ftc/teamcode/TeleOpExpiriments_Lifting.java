package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Do You Even Lift Bro?")
public class TeleOpExpiriments_Lifting extends Library {
    double speedScale = 0.5;
    double stallScale = 0;
    public void init(){
        hardwareInit();
    }
    public void loop(){
        //Start of Omni Drive code
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
        drive(omniValues[0], omniValues[1], omniValues[2], omniValues[3]);
        //end of Omni Drive Code



       // lift();/** This Keybinding is currently set to x and y */
        clawControl(gamepad1.dpad_right);
        lift(gamepad1.dpad_up, gamepad1.dpad_down, stallScale);
        if (gamepad1.a){
            stallScale = stallScale+0.1f;
            waitFor(200);
        }
        if (gamepad1.b){
            stallScale = stallScale-0.1f;
            waitFor(200);
        }
        if (gamepad1.x){
            stallScale = stallScale+0.01f;
            waitFor(200);
        }
        if (gamepad1.y){
            stallScale = stallScale-0.01f;
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
