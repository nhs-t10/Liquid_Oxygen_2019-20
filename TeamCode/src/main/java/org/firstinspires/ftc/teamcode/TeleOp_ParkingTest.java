package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "ParkTest")
public class TeleOp_ParkingTest extends Library {
    Servo ParkThing;
    public void init(){
        hardwareInit();
        ParkThing = hardwareMap.servo.get("ParkThing");
    }

    public void loop(){



        telemetry.addData("lf power: ", lf.getPower());
        telemetry.addData("lb power: ", lb.getPower());
        telemetry.addData("rf power: ", rf.getPower());
        telemetry.addData("rb power: ", rb.getPower());
        telemetry.addData("Speed",speed);
        telemetry.addData("ParkingLocation", ParkThing.getPosition());

        telemetry.update();
    }

    @Override
    public void stop() {
        super.stop();
    }
}
