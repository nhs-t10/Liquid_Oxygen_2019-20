package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import static java.lang.Thread.sleep;

@Autonomous (name = "Red Foundation [WIP]")
public class RedFoundation extends Library {
    float[] omniValues = new float[4];

    //waiting vars
    ElapsedTime timer;
    int timesWaitCalled = 0;
    double timeWaitFirstWasCalled;

    int step = 1;
    @Override
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
                telemetry.addData("time", timer.milliseconds());
                telemetry.update();
                drive(-0.6f, -0.6f, -0.6f, -0.6f);
                if (timer.milliseconds() > 1000){
                    drive(0,0,0,0);
                    step++;
                    break;
                }
            case (3):
                telemetry.addData("time", timer.milliseconds());
                telemetry.update();
                hook.setPosition(0.6);
                if (timer.milliseconds() > 1500){
                    step++;
                    break;
                }
            case (4):
                telemetry.addData("time", timer.milliseconds());
                telemetry.update();
               // forward(inchConversion(31));
                drive(0.6f,0.6f,0.6f,0.6f);
                if (timer.milliseconds() > 2500){
                    drive(0,0,0,0);
                    step++;
                    break;
                }
            case (5):
                telemetry.addData("time", timer.milliseconds());
                telemetry.update();
                hook.setPosition(0.1);
                if (timer.milliseconds() > 3000) {
                    step++;
                    break;
                }
            case (6):
                telemetry.addData("time", timer.milliseconds());
                telemetry.update();
               // right(inchConversion(52 / 1.5f));
                drive(0.6f, -0.6f, -0.6f, 0.6f);
                if (timer.milliseconds() > 4000) {
                    step++;
                    break;
                }
            case(7):
                telemetry.addLine("Autonomous Complete");
                telemetry.addData("time", timer.milliseconds());
                telemetry.update();
        }
    }
}

