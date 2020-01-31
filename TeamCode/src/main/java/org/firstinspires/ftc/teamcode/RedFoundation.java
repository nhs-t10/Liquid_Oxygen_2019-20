package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import static java.lang.Thread.sleep;

@Autonomous (name = "Red Foundation parkNear")
public class RedFoundation extends Library {
    float[] omniValues = new float[4];
    public void delay(double delay){
        double endTime = timer.milliseconds()+delay;
        while(timer.milliseconds() <= endTime){
            //Be patient
        }
    }
    //waiting vars
    ElapsedTime timer, tracker, tracker2;
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
            case(2):
                //go to foundation
                drive(-0.5f, -0.5f, -0.5f, -0.5f);
                delay(1500);
                brake();
                hookOut(true);
                delay(50);
            case(3):
                //pull foundation forward
                drive(0.5f,0.5f,0.5f,0.5f);
                delay(2000);
                brake();
                hookIn(true);
                delay(50);
                step++;
                break;
            case (4):
                //go to parkNear
                clockwise();
                delay(100);
                drive(0.5f,0.5f,0.5f,0.5f);
                delay(1800);
                brake();
                step++;
                break;
            case(5):
                telemetry.addLine("Autonomous Complete");
                telemetry.addData("time", timer.milliseconds());
                telemetry.addData("Step #", step);
                telemetry.update();
        }
    }
}

