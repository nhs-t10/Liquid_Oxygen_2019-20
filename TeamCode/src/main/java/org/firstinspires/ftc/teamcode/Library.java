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
import static java.lang.Thread.sleep;
public abstract class Library extends OpMode{
    boolean clawOpen;
    float speed = 0.5f;
    float lY , lX, rX, saveSpeed;
    public DcMotor lf, lb, rf, rb, ladder;
    public Servo claw, hook, normPark;
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



    public float inchConversion(float inches){
        return inches/4;
    }
    public float rotToTick(float rotations){
        return rotations/570;
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
        //park = hardwareMap.crservo.get("Park");
        //normPark = hardwareMap.servo.get("ParkII");

        telemetry.addData("hook position", hook.getPosition());
        telemetry.addData("claw position", claw.getPosition());
        hook.setPosition(0.55);
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




    public float decimalSeparateDec(float input){
        float num = input;
        for (float i = input; i > 1; i = i-1){
            num = num-1;
        }
        return num;
    }
    public float decimalSeparateWhl(float input){
        float num = 0;
        for (float i = input; i > 1; i = i-1){
            num = num+1;
        }
        return num;
    }






    public void forward(float rotationNumber){
        int curPos = lf.getCurrentPosition();
        float rotationsPartial = decimalSeparateDec(rotationNumber);
        float rotationsFull = decimalSeparateWhl(rotationNumber);
        int rotParInTics = Math.round(rotationsPartial*560);
        int rotateTo = rotParInTics + curPos;
        if (rotateTo > 560){
            rotateTo = rotateTo - 560;
        }

        drive(0.6f, 0.6f, 0.6f, 0.6f);
        while (rotationsFull != 0){
            if (lf.getCurrentPosition() == curPos){
                rotationsFull = rotationsFull-1;
                waitFor(100);
            }
        }
        while (lf.getCurrentPosition() != rotateTo) {
            drive(0.6f,0.6f,0.6f,0.6f);
        }
        drive(0,0,0,0);
    }
    public void backwards(float rotationNumber){
        int curPos = lf.getCurrentPosition();
        float rotationsPartial = decimalSeparateDec(rotationNumber);
        float rotationsFull = decimalSeparateWhl(rotationNumber);
        int rotParInTics = Math.round(rotationsPartial*560);
        int rotateTo = rotParInTics + curPos;
        if (rotateTo > 560){
            rotateTo = rotateTo - 560;
        }

        drive(-0.6f, -0.6f, -0.6f, -0.6f);
        while (rotationsFull != 0){
            if (lf.getCurrentPosition() == curPos){
                rotationsFull = rotationsFull-1;
                waitFor(100);
            }
        }
        while (lf.getCurrentPosition() != rotateTo) {
            drive(-0.6f, -0.6f, -0.6f, -0.6f);
        }
        drive(0,0,0,0);
    }
    public void left(float rotationNumber){
        int curPos = lf.getCurrentPosition();
        float rotationsPartial = decimalSeparateDec(rotationNumber);
        float rotationsFull = decimalSeparateWhl(rotationNumber);
        int rotParInTics = Math.round(rotationsPartial*560);
        int rotateTo = rotParInTics + curPos;
        if (rotateTo > 560){
            rotateTo = rotateTo - 560;
        }

        drive(-0.6f, 0.6f, 0.6f, -0.6f);
        while (rotationsFull != 0){
            if (lf.getCurrentPosition() == curPos){
                rotationsFull = rotationsFull-1;
                waitFor(100);
            }
        }
        while (lf.getCurrentPosition() != rotateTo) {
            drive(-0.6f, 0.6f, 0.6f, -0.6f);
        }
        drive(0,0,0,0);
    }
    public void right(float rotationNumber){
        int curPos = lf.getCurrentPosition();
        float rotationsPartial = decimalSeparateDec(rotationNumber);
        float rotationsFull = decimalSeparateWhl(rotationNumber);
        int rotParInTics = Math.round(rotationsPartial*560);
        int rotateTo = rotParInTics + curPos;
        if (rotateTo > 560){
            rotateTo = rotateTo - 560;
        }

        drive(0.6f, -0.6f, -0.6f, 0.6f);
        while (rotationsFull != 0){
            if (lf.getCurrentPosition() == curPos){
                rotationsFull = rotationsFull-1;
                waitFor(100);
            }
        }
        while (lf.getCurrentPosition() != rotateTo) {
            drive(0.6f, -0.6f, -0.6f, 0.6f);
        }
        drive(0,0,0,0);
    }
}