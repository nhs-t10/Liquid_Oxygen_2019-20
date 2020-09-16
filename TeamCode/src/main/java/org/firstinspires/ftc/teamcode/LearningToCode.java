package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@TeleOp(name = "Learning")
public class LearningToCode extends Library{

  /* The parameter weekday is true if it is a weekday, and the parameter vacation is true if we are on vacation. 
  We sleep in if it is not a weekday or we're on vacation. Return true if we sleep in. */


  public boolean sleepIn(boolean weekday, boolean vacation) {
    if (vacation = true){
      return true;
    }
    if (weekday = true){
      return false;
    }
    return true;
  }

  public boolean sleepIn(boolean weekday, boolean vacation) {
    return (vacation || !weekday);
  }

  // We have two monkeys, a and b, and the parameters aSmile and bSmile indicate if each is smiling. 
  // We are in trouble if they are both smiling or if neither of them is smiling. 
  // Return true if we are in trouble.

  public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
    if (aSmile && bSmile){
      return true;
    }
    if (!aSmile && !bSmile){
      return true;
    }
    return false;
  }

  public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
    return aSmile = bSmile;
  }
  













    public void init(){
        
    }
    public void loop(){

    }
}




















































































