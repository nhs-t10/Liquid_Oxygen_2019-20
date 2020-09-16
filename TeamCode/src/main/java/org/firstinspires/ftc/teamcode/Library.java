package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.DcMotor.RunMode;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.VoltageSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
import static java.lang.Thread.sleep;
public abstract class Library extends OpMode{
    ColorSensor color1;
    boolean clawOpen;
    float speed = 0.5f;
    float lY , lX, rX, saveSpeed;
    public DcMotor lf, lb, rf, rb, ladder;
    public Servo claw, hook, normPark, iratClaw, iratArm;
    public CRServo park;
    float [] omniValues = new float [4];
    public void speedController(){
        if (gamepad1.left_bumper){
            speed = 0.53f;
        }
        if (gamepad1.right_bumper){
            speed = 0.75f;
        }
        if (gamepad1.left_bumper && gamepad1.right_bumper){
            speed = 0.65f;
        }
    }
    public void lift(boolean up, boolean down, double stall){
        if (gamepad1.x){
            ladder.setPower(0.5);
        }
        if (gamepad1.y){
            ladder.setPower(-0.5);
        }
        if (!gamepad1.x && !gamepad1.y){
            ladder.setPower(stall);
        }
    }/** Working*/
    public void openClaw(){
        claw.setPosition(0.5); //subject to change for ease of hardware
    }
    public void closeClaw(){
        claw.setPosition(0); //subject to change for ease of hardware
    }
    public void aClawController(boolean button){
        if (button && !clawOpen) {
            claw.setPosition(1);
            clawOpen = true;
        }else if (button){
            claw.setPosition(0);
            clawOpen = false;
        }
        waitFor(100);
    }

    public boolean isBlack(){
        if (color1.alpha() < 1000){
            return true;
        }
        return false;
    }

    public float inchConversion(float inches){
        return inches/4;
    }
    public float rotToTick(float rotations){
        return rotations*570;
    }

    public void drive(float x, float y, float h, float k){
        lf.setPower(-x*speed);
        lb.setPower(-y*speed);
        rf.setPower(h*speed);
        rb.setPower(k*speed);
    }

    public void hardwareInit()  {
        lf = hardwareMap.dcMotor.get("lf");
        lb = hardwareMap.dcMotor.get("lb");
        rf = hardwareMap.dcMotor.get("rf");
        rb = hardwareMap.dcMotor.get("rb");
        hook = hardwareMap.servo.get("Hook");
        claw = hardwareMap.servo.get("Claw");
        ladder = hardwareMap.dcMotor.get("Ladder");
        color1 = hardwareMap.get(ColorSensor.class, "color1");
        iratArm = hardwareMap.servo.get("iratArm");

        hook.setPosition(0.55);
        telemetry.addData("iratArm position", iratArm.getPosition());
    }
    public void updateShortcuts(){
        lY = -gamepad1.left_stick_y;
        lX = gamepad1.left_stick_x;
        rX = gamepad1.right_stick_x;
    }

    public void hookOut (boolean button){
        if (button){
            hook.setPosition(0.7);
        }
    }
    public void hookIn(boolean button){
        if (button){
            hook.setPosition(0.2);
        }
    }
    public void parking(boolean park, boolean unpark){
        if (park){
            normPark.setPosition(1);
        }
        if (unpark){
            normPark.setPosition(0);
        }
    }
    public void waitFor(long miliseconds){
        try {
            sleep(miliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
























    public void modeBreak(){
        lf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rf.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rb.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void brake(){
        drive(0,0,0,0);
    }
    public void clockwise(){
        drive(0.5f, 0.5f, -0.5f, -0.5f);
        delay(765);
        drive(0,0,0,0);
    }
    ElapsedTime timer;
    public void delay(double delay){
        double endTime = timer.milliseconds()+delay;
        while(timer.milliseconds() <= endTime){
            //Be patient
        }
    }






    public void iratArmUp(){
        iratArm.setPosition(iratArm.getPosition()+0.1);
    }
    public void iratArmDown(){
        iratArm.setPosition(iratArm.getPosition()-0.1);
    }
}
