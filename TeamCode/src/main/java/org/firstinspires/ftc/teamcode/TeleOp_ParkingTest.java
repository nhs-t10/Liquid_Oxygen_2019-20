package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "ParkTest")
public class TeleOp_ParkingTest extends Library {
    Servo parkStick;
    public void parkStickDown(boolean button){
        if (button){
            parkStick.setPosition(1);
        }
    }
    public void parkStickUp(boolean button){
        if (button){
            parkStick.setPosition(0);
        }
    }


    public void init(){
        hardwareInit();
        parkStick = hardwareMap.servo.get("ParkStick");
    }

    public void loop(){
        parkStickDown(gamepad1.dpad_down);
        parkStickUp(gamepad1.dpad_up);

        telemetry.addData("lf power: ", lf.getPower());
        telemetry.addData("lb power: ", lb.getPower());
        telemetry.addData("rf power: ", rf.getPower());
        telemetry.addData("rb power: ", rb.getPower());
        telemetry.addData("Speed",speed);
        telemetry.addData("Park Stick", parkStick.getPosition());

        telemetry.update();
    }

    @Override
    public void stop() {
        super.stop();
    }
}
