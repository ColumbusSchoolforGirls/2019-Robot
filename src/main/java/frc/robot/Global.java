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
    public static final int START = 8;
    public static final int SELECT = 7;

    //Drivetrain
    public static final double DEADZONE = 0.35;

    //Lift safty
    public static final double LIFT_DEADZONE = 3500.0;

    //PID control constants
    // Hatch loading: SP: 0.25 P = 3.5 I = 0.08 D = 0, IZONE = 0.11
    // Level 1: Setpoint: 0.35 P = 3.5, I = 0.08, D = 0, IZONE = 0.11
    // Level 2: Setpoint: 0.54 P = 2.5, I = 0.08, D = 0, IZONE = 0.18

    //Level 1 Cargo
    public static final double LIFT_P_CARGO_1 = 3.5;
    public static final double LIFT_I_CARGO_1 = 0.08;
    public static final double LIFT_D_CARGO_1 = 0;
    public static final double LIFT_IZONE_CARGO_1 = 0.11;
    public static final double LIFT_SETPOINT_CARGO_1 = 0.35;
    public static final double LIFT_TOLERANCE = 0;

    //Level 2 Cargo
    public static final double LIFT_P_CARGO_2 = 2.5;
    public static final double LIFT_I_CARGO_2 = 0.08;
    public static final double LIFT_D_CARGO_2 = 0;
    public static final double LIFT_IZONE_CARGO_2 = 0.18;
    public static final double LIFT_SETPOINT_CARGO_2 = 0.54;

    //Level 1 Hatch
    public static final double LIFT_P_HATCH_1 = 3.5;
    public static final double LIFT_I_HATCH_1 = 0.08;
    public static final double LIFT_D_HATCH_1 = 0;
    public static final double LIFT_IZONE_HATCH_1 = .11;
    public static final double LIFT_SETPOINT_HATCH_1 = 0.25;

    //Level 2 Hatch
    public static final double LIFT_P_HATCH_2 = 4;
    public static final double LIFT_I_HATCH_2 = 0.08;
    public static final double LIFT_D_HATCH_2 = 0;
    public static final double LIFT_IZONE_HATCH_2 = .1;
    public static final double LIFT_SETPOINT_HATCH_2 = 0.515;
}
