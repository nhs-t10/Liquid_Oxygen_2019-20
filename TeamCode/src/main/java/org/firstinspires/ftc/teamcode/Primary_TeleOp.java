package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Main Code")
public class Primary_TeleOp extends Library {
    public void init(){
        hardwareInit();
        modeBreak();
    }
    public void loop(){
        /**Start of Omni Drive code*/
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
        /**end of Omni Drive Code*/


        aClawController(gamepad1.a);
        //clawControl(gamepad1.a);
        lift(gamepad1.x, gamepad1.y, 0);
        hookIn(gamepad1.dpad_right);
        hookOut(gamepad1.dpad_left);
        speedController();
        if (gamepad1.dpad_up) {
            servo.setPosition(1);
        }
        if (gamepad1.dpad_down) {
            servo.setposition(0);
        }


        telemetry.addData("lf power: ", lf.getPower());
        telemetry.addData("lb power: ", lb.getPower());
        telemetry.addData("rf power: ", rf.getPower());
        telemetry.addData("rb power: ", rb.getPower());
        telemetry.addData("rX", rX);
        telemetry.addData("lX", lX);
        telemetry.addData("lY", lY);
        telemetry.addData("Speed",speed);
        telemetry.update();
    }

    @Override
    public void stop() {
        super.stop();
    }
}
