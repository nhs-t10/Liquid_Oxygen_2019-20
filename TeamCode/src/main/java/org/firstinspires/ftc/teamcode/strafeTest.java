package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "strafing Test", group = "Testing code")
public class strafeTest extends Library {
    @Override
    public void init() {
        hardwareInit();
    }

    @Override
    public void loop() {
        updateShortcuts();
        drive(-lX, lX, lX, -lX);
        telemetry.addData("LY: ", lY);
        telemetry.addData("LX: ", lX);
        telemetry.addData("LX Input", gamepad1.left_stick_x);
        telemetry.addData("lf power: ", lf.getPower());
        telemetry.addData("lb power: ", lb.getPower());
        telemetry.addData("rf power: ", rf.getPower());
        telemetry.addData("rb power: ", rb.getPower());
    }

}
