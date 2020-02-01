package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name = "Blue Foundation Far")
public class AutonomousENCODER_TEST extends Library {
    float [] omniValues = new float [4];
    int step = 1;
    ElapsedTime timer;

    public void delay(double delay){
        double endTime = timer.milliseconds()+delay;
        while(timer.milliseconds() <= endTime){
            //Be patient
        }
    }

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
    public void clockwise(){
        drive(0.5f, 0.5f, -0.5f, -0.5f);
        delay(765);
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
        while (lf.getCurrentPosition() < distance/2 /**&& rb.getCurrentPosition() < distance*/){
            telemetry.addData("lf Busy?", lf.isBusy());
            telemetry.addData("rb Busy?", rb.isBusy());
            telemetry.addData("Porgress", lf.getCurrentPosition());
            telemetry.addData("Progress", rb.getCurrentPosition());
            telemetry.update();
            //Wait patiently
        }
        drive(power/2, power/2, power/2, power/2);
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
                modeBreak();
//                encodeLinear(0.05f, 1000 );
//                delay(1500);
//                encodeRotate(0.05f, 278);
                drive(0.5f, -0.5f, -0.5f, 0.5f);
                delay(1000);
                brake();
                step++;
                break;
        }
    }
    @Override
    public void stop(){
        super.stop();
    }
}

