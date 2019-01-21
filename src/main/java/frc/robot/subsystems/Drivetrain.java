/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.MecanumDrive;
import edu.wpi.first.wpilibj.Spark;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Drivetrain extends Subsystem {
public static Spark leftFront = new Spark(RobotMap.LEFT_DRIVE_PORT_FRONT);
public static Spark leftBack = new Spark(RobotMap.LEFT_DRIVE_PORT_BACK);
public static Spark rightFront = new Spark(RobotMap.RIGHT_DRIVE_PORT_FRONT);
public static Spark rigthBack = new Spark(RobotMap.RIGHT_DRIVE_PORT_BACK);

  public Drivetrain() {

  }  

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new MecanumDrive());
  }
}
