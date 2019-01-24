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
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;

/*
Got most of the informtion from: https://github.com/frc3946/MecanumDrivetrain/blob/master/src/edu/wpi/first/wpilibj/templates/commands/MecanumDrive.java
*/

public class MecanumDrive extends Command {
  double X;
  double Y;
  double throttle;

  public MecanumDrive() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    X = OI.driveCont.getRawAxis(2);
    if (Math.abs(X) <= Global.DEADZONE) {
      X = 0.0;
    }
    Y = OI.driveCont.getRawAxis(1);
    if (Math.abs(Y) <= Global.DEADZONE) {
      Y = 0.0;
    }
    throttle = OI.driveCont.getThrottle();
    if (Math.abs(throttle) <= Global.DEADZONE) {
      throttle = 0.0;
    }

    DriveTrain.mecanumDrive(X, Y, throttle, gyro.getAngle()); //need gyro for it to work
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
