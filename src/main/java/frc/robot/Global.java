/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


/**
 * Add your docs here.
 */
public class Global {

    //Controllers
    public static final int JOYSTICK_DRIVE = 0;
    public static final int JOYSTICK_AUX = 1; //not sure if that is right but going to role with it
    public static final int BUTTON_A = 1;
    public static final int BUTTON_B = 2;
    public static final int BUTTON_X = 3;
    public static final int BUTTON_Y = 4;
    public static final int LEFT_BUMPER = 5;
    public static final int RIGHT_BUMPER = 6;
    public static final int START = 7;
    public static final int SELECT = 8;

    //Drivetrain
    public static final double DEADZONE = 0.35;

    //Lift safty
    public static final double LIFT_DEADZONE = 3500.0;

    //PID control constants (not tuned from last year)
    public static final double DRIVETRAIN_P = 0.000048; // 0.000048
	public static final double DRIVETRAIN_I = 0;
	public static final double DRIVETRAIN_D = 0;
	public static final double DRIVETRAIN_IZONE = 0;
	public static final double DRIVESTRAIGHT_ANGLE_P = 0.04; // 0.04
	public static final double DRIVESTRAIGHT_ANGLE_I = 0;
	public static final double DRIVESTRAIGHT_ANGLE_D = 0;
	public static final double TURNANGLE_P = 0.0061;
	public static final double TURNANGLE_I = 0.001;
	public static final double TURNANGLE_D = 0;
	public static final double TURNANGLE_IZONE = 10;
	public static double ELEVATOR_P = 0;
	public static double ELEVATOR_I = 0;
	public static double ELEVATOR_D = 0;
	public static double ELEVATOR_IZONE = 0;
}
