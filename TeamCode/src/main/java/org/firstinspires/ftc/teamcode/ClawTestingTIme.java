package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;

@TeleOp(name = "Main Code")
public class ClawTestingTIme extends Library {
    CRServo Claw;
    double clawSpeed = 0.5;
    public void init(){
        hardwareInit();
        Claw = hardwareMap.crservo.get("Claw");
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


        lift(gamepad1.x, gamepad1.y, 0);
        if (gamepad1.dpad_up){
            Claw.setPower(clawSpeed);
        }
        if (gamepad1.dpad_down){
            Claw.setPower(-clawSpeed);
        }
        if (!gamepad1.dpad_down && !gamepad1.dpad_up){
            Claw.setPower(0);
        }
        if (gamepad1.dpad_right){
            clawSpeed = clawSpeed + 0.1;
        }
        if (gamepad1.dpad_left){
            clawSpeed = clawSpeed - 0.1;
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
