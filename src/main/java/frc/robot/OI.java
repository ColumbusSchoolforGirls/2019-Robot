/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.DropWheelieBar;
import frc.robot.commands.FullSpeedAhead;
import frc.robot.commands.Grab;
import frc.robot.commands.IntakeManual;
import frc.robot.commands.LiftSetAngle;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  //Declares the different controllers
  public static Joystick driveCont = new Joystick(Global.JOYSTICK_DRIVE);
  public static Joystick auxCont = new Joystick(Global.JOYSTICK_AUX);

  //Declares the drivers buttons
  public static Button buttonA = new JoystickButton(driveCont, Global.BUTTON_A);
  public static Button buttonB = new JoystickButton(driveCont, Global.BUTTON_B);
  public static Button buttonY = new JoystickButton(driveCont, Global.BUTTON_Y);
  public static Button buttonX = new JoystickButton(driveCont, Global.BUTTON_X);
  public static Button rightBumper = new JoystickButton(driveCont, Global.RIGHT_BUMPER);
  public static Button leftBumper = new JoystickButton(driveCont, Global.LEFT_BUMPER);
  public static Button start = new JoystickButton(driveCont, Global.START);
  public static Button select = new JoystickButton(driveCont, Global.SELECT);
  public static Button leftTrigger = new JoystickAnalogButton(driveCont, 2, .5);
  public static Button rightTrigger = new JoystickAnalogButton(driveCont, 3, .5);

  //Declares the aux buttons
  public static Button auxButtonA = new JoystickButton(auxCont, Global.BUTTON_A);
  public static Button auxButtonB = new JoystickButton(auxCont, Global.BUTTON_B);
  public static Button auxButtonY = new JoystickButton(auxCont, Global.BUTTON_Y);
  public static Button auxButtonX = new JoystickButton(auxCont, Global.BUTTON_X);
  public static Button auxRightBumper = new JoystickButton(auxCont, Global.RIGHT_BUMPER);
  public static Button auxLeftBumper = new JoystickButton(auxCont, Global.LEFT_BUMPER);
  public static Button auxStart = new JoystickButton(auxCont, Global.START);
  public static Button auxSelect = new JoystickButton(auxCont, Global.SELECT);
  public static Button auxLeftTrigger = new JoystickAnalogButton(auxCont, 2, .5);
  public static Button auxRightTrigger = new JoystickAnalogButton(auxCont, 3, .5);
  


  public OI () {
    //uses the aux a button to open and close the arm
    auxButtonA.whileHeld(new Grab(true, false));
    auxButtonA.whenReleased(new Grab(false, true));

    //uses the bumpers to control the intake wheels
    auxLeftBumper.whileHeld(new IntakeManual(1));
    auxRightBumper.whileHeld(new IntakeManual(-1));
    
    //Driver holds A to spin in a circle and release the wheeliebar
    buttonA.whileHeld(new DropWheelieBar(true, false));
    buttonA.whenReleased(new DropWheelieBar(false, true));

    //PID lift controls
    auxSelect.whileHeld(new LiftSetAngle(Global.LIFT_SETPOINT_CARGO_1, Global.LIFT_P_CARGO_1, Global.LIFT_I_CARGO_1, Global.LIFT_D_CARGO_1, Global.LIFT_IZONE_CARGO_1));
    //auxStart.whileHeld(new LiftSetAngle(Global.LIFT_SETPOINT_CARGO_2, Global.LIFT_P_CARGO_2, Global.LIFT_I_CARGO_2, Global.LIFT_D_CARGO_2, Global.LIFT_IZONE_CARGO_2));
    auxLeftTrigger.whileHeld(new LiftSetAngle(Global.LIFT_SETPOINT_HATCH_1, Global.LIFT_P_HATCH_1, Global.LIFT_I_HATCH_1, Global.LIFT_D_HATCH_1, Global.LIFT_IZONE_HATCH_1));
    //auxRightTrigger.whileHeld(new LiftSetAngle(Global.LIFT_SETPOINT_HATCH_2, Global.LIFT_P_HATCH_2, Global.LIFT_I_HATCH_2, Global.LIFT_D_HATCH_2, Global.LIFT_IZONE_HATCH_2));

    //Driver 100 change to 100 speed
    leftTrigger.whileHeld(new FullSpeedAhead());  
 }
}
