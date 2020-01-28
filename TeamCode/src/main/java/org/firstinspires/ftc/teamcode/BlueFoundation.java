package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name = "Blue Foundation [WIP]")
public class BlueFoundation extends Library {
    ElapsedTime timer;
    float[] omniValues = new float[4];
    int step = 1;
    public void init() {
        hardwareInit();
    }
    public void loop() {
        switch (step) {
            case(1):
                timer = new ElapsedTime();
                step++;
                break;
            case (2):

            case (3):
                hook.setPosition(0.6);
                if (timer.milliseconds() > 3000){
                    step++;
                    break;
                }
            case (4):
                // forward(inchConversion(31));
                drive(0.7f,0.7f,0.7f,0.7f);
                if (timer.milliseconds() > 5500){
                    drive(0,0,0,0);
                    step++;
                    break;
                }
            case (5):
                hook.setPosition(0.1);
                if (timer.milliseconds() > 6000) {
                    step++;
                    break;
                }
            case (6):
                // right(inchConversion(52 / 1.5f));
                drive(0.6f, -0.6f, -0.6f, 0.6f);
                if (timer.milliseconds() > 10000) {
                    step++;
                    break;
                }
            case(7):
                telemetry.addLine("Autonomous Complete");
                telemetry.update();
        }
    }

}

