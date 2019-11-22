package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "linear Test", group = "Testing code")
public class linearTest extends Library{
    @Override
    public void init() {
        hardwareInit();
    }

    @Override
    public void loop() {
        updateShortcuts();
        drive(-lY, -lY, -lY, -lY);
    }
}
