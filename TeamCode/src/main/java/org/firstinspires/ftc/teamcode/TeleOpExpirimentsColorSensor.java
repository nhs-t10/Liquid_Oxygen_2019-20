package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
@TeleOp(name = "Color Sensor Test")
public class TeleOpExpirimentsColorSensor extends Library {
    ColorSensor color1;
    public boolean isGold(){
        if (false){
            telemetry.addData("ARGB",color1.argb());
            telemetry.addData("alpha",color1.alpha());
            telemetry.addData("red",color1.red());
            telemetry.addData("green",color1.green());
            telemetry.addData("blue",color1.blue());
            telemetry.update();
            return true;
        }
        return false;
    }

    public void init(){
        hardwareInit();
        color1 = hardwareMap.get(ColorSensor.class, "color1");
    }
    public void loop(){

        telemetry.addData("ARGB",color1.argb());
        telemetry.addData("alpha",color1.alpha());
        telemetry.addData("red",color1.red());
        telemetry.addData("green",color1.green());
        telemetry.addData("blue",color1.blue());
        telemetry.update();
    }

    @Override
    public void stop() {
        super.stop();
    }
}
