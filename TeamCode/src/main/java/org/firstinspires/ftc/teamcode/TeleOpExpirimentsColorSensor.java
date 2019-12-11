package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
@TeleOp(name = "Color Sensor Test")
public class TeleOpExpirimentsColorSensor extends Library {
    ColorSensor Glasses;

    public void init(){
        hardwareInit();
        Glasses = hardwareMap.colorSensor.get("colorSensor1");
    }
    public void loop(){
        telemetry.addData("red",Glasses.red());
        telemetry.addData("green",Glasses.green());
        telemetry.addData("blue",Glasses.blue());
        telemetry.update();
    }

    @Override
    public void stop() {
        super.stop();
    }
}
