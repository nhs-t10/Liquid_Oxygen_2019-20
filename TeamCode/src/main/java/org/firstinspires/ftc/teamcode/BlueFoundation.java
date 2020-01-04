package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous (name = "Blue Foundation [WIP]")
public class BlueFoundation extends Library {
    float[] omniValues = new float[4];
    int step = 1;

    public void init() {
        hardwareInit();
    }

    public void loop() {
        switch (step) {
            case (1):
                backwards(inchConversion(31));
                step++;
                break;
            case (2):
                hook.setPosition(0.6);
                step++;
                break;
            case (3):
                forward(inchConversion(31));
                step++;
                break;
            case (4):
                hook.setPosition(0.1);
                step++;
                break;
            case (5):
                left(inchConversion(52 / 1.5f));
                step++;
                break;

        }
    }
}

