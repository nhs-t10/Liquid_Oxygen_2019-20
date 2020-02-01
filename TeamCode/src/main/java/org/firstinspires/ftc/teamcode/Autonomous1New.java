package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name = "Red Foundation Far")
public class Autonomous1New extends Library {
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
        switch (step) {
            case(1):
                timer = new ElapsedTime();
                step++;
                break;
//            case(99):
//                if ( timer.milliseconds() >= 15000){
//                    step = 2;
//                    break;
//                }
//                else{
//                    step = 99;
//                }
            case(2):
                drive(-0.5f,0.5f,0.5f,-0.5f);
                delay(750);
                brake();
                delay(100);
                step++;
                break;
            case(3):
                //go to foundation
                drive(-0.5f, -0.5f, -0.5f, -0.5f);
                delay(2500);
                brake();
                hookOut(true);
                delay(50);
            case(4):
                //pull foundation forward
                drive(0.5f,0.5f,0.5f,0.5f);
                delay(3000);
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
                drive(0.5f,-0.5f,-0.5f,0.5f);
                delay(3000);
                brake();
                step++;
                break;
            case(7):
                drive(-0.5f,-0.5f,-0.5f,-0.5f);
                delay(1000);
                brake();
                delay(200);
                drive(0.5f, -0.5f, -0.5f, 0.5f);
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
    @Override
    public void stop(){
        super.stop();
    }
}

