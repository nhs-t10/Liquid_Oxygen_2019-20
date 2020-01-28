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
    ElapsedTime timer;
    int timesWaitCalled = 0;
    double timeWaitFirstWasCalled;
    int step = 1;
    public void modeBreak(){
        lf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
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
                //timer = new ElapsedTime();
                step++;
                break;
            case (2):
                //to stones
                encodeStrafe(0, 4168);
                step++;
                break;
            case (3):
                while(!isBlack()){
                    drive(-0.5f, -0.5f, -0.5f, -0.5f);
                    timer = new ElapsedTime();
                }
                step++;
                break;
            case (4):
                iratClawTogg();
                encodeStrafe(0, -200);
                iratClawTogg();
                delay(1000);
                encodeStrafe(0, 913);
                step++;
                break;
            case (5):
                drive(0.5f, 0.5f, 0.5f, 0.5f);
                delay (timer.milliseconds());
                iratArmUp();
                encodeLinear(0, 4275);
                openClaw();
                step++;
                break;
            case (6):
                encodeStrafe(0, 100);
                delay(50);
                encodeRotate(0, -300);
                delay(50);
                encodeLinear(0, 100);
                hookOut(true);
                delay(50);
                step++;
                break;
            case(7):
                encodeLinear(0, 4489);
                hookIn(true);
            case(8):
                telemetry.addLine("Autonomous Complete");
                telemetry.addData("time", timer.milliseconds());
                telemetry.update();
        }
    }
}

