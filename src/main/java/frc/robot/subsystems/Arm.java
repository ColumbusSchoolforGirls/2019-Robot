/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Arm extends Subsystem () { public static DoubleSolenoid claw = new DoublSolenoid(RobotMap.CLAW_SOL_A_PORT, RobotMap.CLAW_SOL_B_PORT); 
    public static Compressor compressor = new Compressor(); 
    public Arm () {} public static void grab(boolean open) { if () {} }