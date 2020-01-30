package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import static java.lang.Thread.sleep;

@Autonomous (name = "Red Foundation [WIP]")
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

    public void encodeStrafe(float power, int distance){
        lf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lf.setTargetPosition(distance);
        lb.setTargetPosition(-distance);
        rf.setTargetPosition(-distance);
        rb.setTargetPosition(distance);
        lb.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        lf.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rf.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rb.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        drive(power, power, power, power);
        while (Math.abs(lf.getCurrentPosition()) < Math.abs(distance) /**&& rb.getCurrentPosition() < distance*/){
            telemetry.addData("lf Busy?", lf.isBusy());
            telemetry.addData("rb Busy?", rb.isBusy());
            telemetry.addData("Porgress", lf.getCurrentPosition());
            telemetry.addData("Progress", rb.getCurrentPosition());
            telemetry.update();
            //Wait patiently
        }
        modeBreak();
        drive(0,0,0,0);

    }
    public void encodeRotate(float power, int distance){
        lf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lf.setTargetPosition(distance);
        lb.setTargetPosition(distance);
        rf.setTargetPosition(distance);
        rb.setTargetPosition(distance);
        lb.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        lf.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rf.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rb.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        drive(-power, -power, power, power);
        while (Math.abs(lf.getCurrentPosition()) < Math.abs(distance) /**&& rb.getCurrentPosition() < distance*/){
            telemetry.addData("lf Busy?", lf.isBusy());
            telemetry.addData("rb Busy?", rb.isBusy());
            telemetry.addData("Porgress", lf.getCurrentPosition());
            telemetry.addData("Progress", rb.getCurrentPosition());
            telemetry.update();
            //Wait patiently
        }
        modeBreak();
        drive(0,0,0,0);

    }
    public void encodeLinear(float power, int distance){
        lf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lf.setTargetPosition(-distance);
        lb.setTargetPosition(-distance);
        rf.setTargetPosition(distance);
        rb.setTargetPosition(distance);
        lb.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        lf.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rf.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rb.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        drive(power, power, power, power);
        while (lf.getCurrentPosition() < distance /**&& rb.getCurrentPosition() < distance*/){
            telemetry.addData("lf Busy?", lf.isBusy());
            telemetry.addData("rb Busy?", rb.isBusy());
            telemetry.addData("Porgress", lf.getCurrentPosition());
            telemetry.addData("Progress", rb.getCurrentPosition());
            telemetry.update();
            //Wait patiently
        }
        modeBreak();
        drive(0, 0, 0, 0);

    }
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
                //to stones
                iratClawTogg();
                drive(-0.5f, 0.5f, 0.5f, -0.5f);
                delay(1500);
                drive(0,0,0,0);
                delay(100);
                step++;
                break;
            case (3):
                tracker = new ElapsedTime();
                drive(-0.5f,-0.5f,-0.5f,-0.5f);
                delay(1000);
                brake();
//                while(!isBlack()){
//                    drive(-0.5f, -0.5f, -0.5f, -0.5f);
//                }
                step++;
                break;
            case (4):
                tracker2 = new ElapsedTime();
                drive(-0.5f, 0.5f, 0.5f, -0.5f);
                delay(750);
                brake();
                iratClawTogg();
                delay(500);
                drive(0.5f, -0.5f, -0.5f, 0.5f);
                step++;
                break;
            case (5):
                drive(0.5f, 0.5f, 0.5f, 0.5f);
                delay (tracker.milliseconds()-tracker2.milliseconds());
                iratArmUp();
                drive(0.6f, 0.6f, 0.6f, 0.6f);
                delay(5000);
                iratClawTogg();
                step++;
                break;
            case (6):
                drive(0.5f, -0.5f, -0.5f, 0.5f);
                delay(1000);
                brake();
                delay(50);
                clockwise();
                delay(500);
                drive(-0.5f,-0.5f,-0.5f,-0.5f);
                delay(1000);
                brake();
                hookOut(true);
                delay(500);
                step++;
                break;
            case(7):
                drive(0.5f,0.5f,0.5f,0.5f);
                delay(1800);
                hookIn(true);
                step=9;
                break;
            case (8):
                drive(0.5f, -0.5f, -0.5f, 0.5f);
                delay(1300);
                brake();
                delay(500);
                drive(-0.5f, -0.5f, -0.5f, -0.5f);
                delay(850);
                brake();
                delay(500);
                drive(0.5f, -0.5f, -0.5f, 0.5f);
                delay(1800);
                brake();
                step++;
                break;
            case(9):
                telemetry.addLine("Autonomous Complete");
                telemetry.addData("time", timer.milliseconds());
                telemetry.update();
        }
    }
}

