package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.DcMotor.RunMode;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.VoltageSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
public abstract class Library extends OpMode{
    float speed = 0.5f;
    float lY , lX, rX, saveSpeed;
    public DcMotor lf, lb, rf, rb;
    public Servo claw, hook;
    public CRServo ladder, park;
    float [] omniValues = new float [4];

    public void clawControl(boolean button){
        if (button) {
            openClaw();
        }else{
            closeClaw();
        }
    }
    public void lift(){
        if (gamepad1.x){
            ladder.setPower(0.5);
        }
        if (gamepad1.y){
            ladder.setPower(-0.5);
        }
        if (!gamepad1.x && !gamepad1.y){
            ladder.setPower(0);
        }
    }/** Working*/
    public void hookUp(){
        hook.setPosition(1);
    }
    public void hookDown(){
        hook.setPosition(0.5);
    }
    public void openClaw(){
        claw.setPosition(0.5); //subject to change for ease of hardware
    }
    public void closeClaw(){
        claw.setPosition(0); //subject to change for ease of hardware
    }
   /** public void parkStickDown(boolean button){
        if (button){
            park.setPower(1/2);
        }
    }
    public void parkStickUp(boolean button){
        if (button){
            park.setPower(-1/2);
            try {
                Thread.sleep(3500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            park.setPower(0);
        }
    }
    public void parkStickStop(boolean button, boolean butone){
        if (!button && !butone){
            park.setPower(0);
        }
    }*/
    public float inchConversion(float inches){
        return inches/4;
    }

    public void drive(float x, float y, float h, float k){
        lf.setPower(-x);
        lb.setPower(-y);
        rf.setPower(h);
        rb.setPower(k);
    }

    public void hardwareInit(){
        lf = hardwareMap.dcMotor.get("lf");
        lb = hardwareMap.dcMotor.get("lb");
        rf = hardwareMap.dcMotor.get("rf");
        rb = hardwareMap.dcMotor.get("rb");
        hook = hardwareMap.servo.get("Hook");
        claw = hardwareMap.servo.get("Claw");
        ladder = hardwareMap.crservo.get("Ladder");
        park = hardwareMap.crservo.get("Park");

        telemetry.addData("hook position", hook.getPosition());
        telemetry.addData("claw position", claw.getPosition());
        hook.setPosition(1);
        claw.setPosition(0);
    }
   /** public void speedUp(boolean button){
        if (button){
            speed = speed + 0.1f;
            speed = Range.clip(speed, 0, -1);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void speedDown(boolean button){
        if (button){
            speed = speed-0.1f;
            speed = Range.clip(speed, 0, -1);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/
    public void updateShortcuts(){
        lY = gamepad1.left_stick_y;
        lX = gamepad1.left_stick_x;
        rX = gamepad1.right_stick_x;
    }

    public void slowMo(){
        if (gamepad1.dpad_right||gamepad1.dpad_left){
            saveSpeed = speed;
            speed = 0.1f;
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            speed = saveSpeed;
        }
    }

}
