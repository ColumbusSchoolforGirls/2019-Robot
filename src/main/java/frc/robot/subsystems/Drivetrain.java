/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.Mecanumdrive;
import edu.wpi.first.wpilibj.Spark;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Drivetrain extends Subsystem {
  public static Spark leftfront = new Spark(RobotMap.LEFT_DRIVE_PORT_FRONT);
  public static Spark rightfront = new Spark(RobotMap.RIGHT_DRIVE_PORT_FRONT);
  public static Spark leftback = new Spark(RobotMap.LEFT_DRIVE_PORT_BACK);
  public static Spark rightback = new Spark(RobotMap.RIGHT_DRIVE_PORT_BACK);

  public Drivetrain() {

  }  
  

  //when we use tankdrive (y axis data) then this command will run
  public static void setTankdriveSpeed (double leftspeed, double rightspeed) {
    leftfront.set(leftspeed);
    rightfront.set(rightspeed);
    leftback.set(leftspeed);
    rightback.set(rightspeed);
  }

  //when we strafe (x axis data) then this command will run
  //make sure that if motors need to run negatively then both the tank drive and strafe is fixed
  public static void setStrafeSpeed (double strafespeed) {
    leftfront.set(-strafespeed);
    rightfront.set(strafespeed);
    leftback.set(strafespeed);
    rightback.set(-strafespeed);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new Mecanumdrive());
  }
}
