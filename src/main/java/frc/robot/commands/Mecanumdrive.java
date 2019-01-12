/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Global;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.subsystems.Drivetrain;

/**
 * An example command.  You can replace me with your own command.
 */
public class Mecanumdrive extends Command {
  public Mecanumdrive() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Drivetrain.setTankdriveSpeed(0, 0);
  }

  /*
  basically this is what i am trying to type
  if left x axis data is less than left y axis data 
  then figure out if left y axis data is less than dead zone
  nested if loop right y axis data is less than dead zone then no motors run
  else then right side runs
  if the left y axis data is larger than dead zone 
  nested if loop if right y axis data is less than dead zone then left side runs
  else then both sides run

  if the x axis data is larger than right axis data and if x axis data is larger than dead zone
  then do the strafe command

  1 - LeftX
2 - LeftY
3 - Triggers (Each trigger = 0 to 1, axis value = right - left)
4 - RightX
5 - RightY
6 - DPad Left/Right
  */
  @Override
  protected void execute() {
    if (Math.abs(OI.driveCont.getRawAxis(1)) <= Global.DEADZONE && Math.abs(OI.driveCont.getRawAxis(2)) <= Global.DEADZONE && Math.abs(OI.driveCont.getRawAxis(2)) <= Global.DEADZONE) {
      Drivetrain.setTankdriveSpeed(0, 0);
    } else if (Math.abs(OI.driveCont.getRawAxis(1)) <= Math.abs(OI.driveCont.getRawAxis(2))) {
        if (Math.abs(OI.driveCont.getRawAxis(2)) <= Global.DEADZONE) {
          Drivetrain.setTankdriveSpeed(0, OI.driveCont.getRawAxis(5));
        } else if (Math.abs(OI.driveCont.getRawAxis(5)) <= Global.DEADZONE) {
          Drivetrain.setTankdriveSpeed(OI.driveCont.getRawAxis(2), 0);
        } else {
          Drivetrain.setTankdriveSpeed(OI.driveCont.getRawAxis(2), OI.driveCont.getRawAxis(5));
        }
    } else {
      Drivetrain.setStrafeSpeed(OI.driveCont.getRawAxis(1));
    }
    }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
