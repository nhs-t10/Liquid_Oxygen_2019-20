package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Main Code")
public class Primary_TeleOp extends Library {
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
        drive(omniValues[0], omniValues[1], omniValues[2], omniValues[3]);
       // lift();/** This Keybinding is currently set to x and y */
        clawControl(gamepad1.a);
        /*speedUp(gamepad1.right_bumper);
        speedDown(gamepad2.left_bumper);
        parkStickDown(gamepad1.dpad_down);
        parkStickUp(gamepad1.dpad_up);
        parkStickStop(gamepad1.dpad_up, gamepad1.dpad_down);*/
        lift();
        parking(gamepad1.dpad_down, gamepad1.dpad_up);
        hookIn(gamepad1.dpad_right);
        hookOut(gamepad1.dpad_left);
        if (gamepad1.left_bumper){
            speed = 0.25f;
        }
        if (gamepad1.right_bumper){
            speed = 0.75f;
        }
        if (gamepad1.left_bumper && gamepad1.right_bumper){
            speed = 0.5f;
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
