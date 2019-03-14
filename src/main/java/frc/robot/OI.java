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
import frc.robot.commands.Grab;
import frc.robot.commands.IntakeManual;

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

  //Declares the aux buttons
  public static Button auxButtonA = new JoystickButton(auxCont, Global.BUTTON_A);
  public static Button auxButtonB = new JoystickButton(auxCont, Global.BUTTON_B);
  public static Button auxButtonY = new JoystickButton(auxCont, Global.BUTTON_Y);
  public static Button auxButtonX = new JoystickButton(auxCont, Global.BUTTON_X);
  public static Button auxRightBumper = new JoystickButton(auxCont, Global.RIGHT_BUMPER);
  public static Button auxLeftBumper = new JoystickButton(auxCont, Global.LEFT_BUMPER);
  public static Button auxStart = new JoystickButton(auxCont, Global.START);
  public static Button auxSelect = new JoystickButton(auxCont, Global.SELECT);


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
  }
}
