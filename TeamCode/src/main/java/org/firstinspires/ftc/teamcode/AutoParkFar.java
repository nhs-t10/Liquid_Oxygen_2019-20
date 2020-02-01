package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name = "Red Park Far")
public class AutoParkFar extends Library {
    float [] omniValues = new float [4];
    int step = 1;
    ElapsedTime timer;
    public void delay(double delay){
        double endTime = timer.milliseconds()+delay;
        while(timer.milliseconds() <= endTime){
            //Be patient
        }
    }

    public void init() {
        hardwareInit();
    }
    public void loop() {
        switch (step){
            case (1):
                timer = new ElapsedTime();
                step++;
                break;
            case (2):
                drive(0.5f,0.5f,0.5f,0.5f);
                delay(1300);
                brake();
                delay(100);
                drive(0.5f, -0.5f, -0.5f, 0.5f);
                delay(1250);
                brake();
                step++;
                break;
            case(3):
                telemetry.addLine("Autonomous Complete");
                telemetry.addData("Time: ", timer.milliseconds());
                telemetry.update();
        }
    }
    @Override
    public void stop(){
        super.stop();
    }
}

