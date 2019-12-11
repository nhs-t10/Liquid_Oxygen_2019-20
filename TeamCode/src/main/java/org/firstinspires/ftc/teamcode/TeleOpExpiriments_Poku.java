package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import static java.lang.Thread.sleep;

@TeleOp(name = "Main Code")
public class TeleOpExpiriments_Poku extends Library {
    public void init(){
        hardwareInit();
    }
    public void loop(){
        drive(1*speed, 1*speed, 1*speed, 1*speed);
        try {
            sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        drive(-1*speed, -1*speed, -1*speed, -1*speed);
        try {
            sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
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
