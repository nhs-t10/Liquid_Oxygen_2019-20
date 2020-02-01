package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name = "Blue Foundation Far")
public class BlueFoundationFar extends Library {
    public void delay(double delay){
        double endTime = timer.milliseconds()+delay;
        while(timer.milliseconds() <= endTime){
            //Be patient
        }
    }
    ElapsedTime timer;
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
                drive(0.5f,-0.5f,-0.5f,0.5f);
                delay(750);
                brake();
                delay(100);
                step++;
                break;
            case(3):
                //go to foundation
                drive(-0.5f, -0.5f, -0.5f, -0.5f);
                delay(1500);
                brake();
                hookOut(true);
                delay(50);
            case(4):
                //pull foundation forward
                drive(0.5f,0.5f,0.5f,0.5f);
                delay(2000);
                brake();
                step++;
                break;
            case(5):
                delay(200);
                hookIn(true);
                delay(50);
                step++;
                break;
            case (6):
                //go to parkNear
//                clockwise();
//                delay(100);
                drive(-0.5f,0.5f,0.5f,-0.5f);
                delay(3000);
                brake();
                step++;
                break;
            case(7):
                drive(-0.5f,-0.5f,-0.5f,-0.5f);
                delay(1000);
                brake();
                delay(200);
                drive(-0.5f, 0.5f, 0.5f, -0.5f);
                delay(650);
                brake();
                step++;
                break;
            case(8):
                telemetry.addLine("Autonomous Complete");
                telemetry.addData("time", timer.milliseconds());
                telemetry.addData("Step #", step);
                telemetry.update();
        }
    }
}
    
