/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Global;
import frc.robot.OI;
//import frc.robot.PIDCalculator;
import frc.robot.Robot;
import frc.robot.subsystems.Drivetrain;

/*
Got most of the informtion from: https://github.com/frc3946/MecanumDrivetrain/blob/master/src/edu/wpi/first/wpilibj/templates/commands/MecanumDrive.java
*/

public class Unicorndrive extends Command {
  double x;
  double y;
  double rotation;  
  
  double lastAngle;
  boolean trackingAngle;

  public Unicorndrive() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Drivetrain.drive(0, 0, 0);
    trackingAngle = false;
  }

  // Called repeatedly when this Command is scheduled to run
  //First Drivetrain value is yspeed, then xspeed, then rotation
  @Override
  protected void execute() {
    x = -OI.driveCont.getRawAxis(1);
    y = OI.driveCont.getRawAxis(0);
    rotation = OI.driveCont.getRawAxis(4);

    if (Math.abs(rotation) <= Global.DEADZONE){
      if (!trackingAngle){
        trackingAngle = true;
        lastAngle = Math.abs(Drivetrain.getFacingAngle());
      }

      double error = lastAngle - Math.abs(Drivetrain.getFacingAngle());

      rotation = Global.DRIVETRAIN_P * error;
    } else {
      trackingAngle = false;
    }

    Drivetrain.drive(y, x, rotation);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Drivetrain.drive(0, 0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Drivetrain.drive(0, 0, 0);
  }
}
