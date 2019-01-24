/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;

/**
 * An example subsystem. You can replace me with your own Subsystem.
 */
public class Drivetrain extends Subsystem {
public static CANSparkMax leftFront = new CANSparkMax(RobotMap.LEFT_DRIVE_PORT_FRONT, MotorType.kBrushless);
public static CANSparkMax leftBack = new CANSparkMax(RobotMap.LEFT_DRIVE_PORT_BACK, MotorType.kBrushless);
public static CANSparkMax rightFront = new CANSparkMax(RobotMap.RIGHT_DRIVE_PORT_FRONT, MotorType.kBrushless);
public static CANSparkMax rigthBack = new CANSparkMax(RobotMap.RIGHT_DRIVE_PORT_BACK, MotorType.kBrushless);


  public Drivetrain() {

  }  

  @Override
  public void initDefaultCommand() {
  }
}
