/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Global;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.subsystems.Drivetrain;


public class Unicorndrive extends Command {
  double x;
  double y;
  double rotation;  
  double gyroAngle;
  
  double lastAngle;
  double error;

  public Unicorndrive() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Drivetrain.drive(0, 0, 0);
  }

  // Called repeatedly when this Command is scheduled to run
  //First Drivetrain value is xspeed, then yspeed, then rotation
  @Override
  protected void execute() {
    x = OI.driveCont.getRawAxis(0);
    y = -OI.driveCont.getRawAxis(1);
    rotation = OI.driveCont.getRawAxis(4);
    gyroAngle = Drivetrain.getFacingAngle();

    if (Math.abs(x) <= Global.DEADZONE && Math.abs(y) <= Global.DEADZONE && Math.abs(rotation) <= Global.DEADZONE) {
      Drivetrain.drive(0, 0, 0);
    } else {
      if (Math.abs(rotation) <= Global.DEADZONE){
      
      if (x >= Global.DEADZONE) {
        error = lastAngle - Math.abs(Drivetrain.getFacingAngle());
       //p left .007
        rotation = .007 * error;
      } else {
        rotation = OI.driveCont.getRawAxis(4);
        lastAngle = gyroAngle;
      }

    } else {
      rotation = OI.driveCont.getRawAxis(4);
    }
    //this is where we reduce speed for rotation and not the x and y
    Drivetrain.drive(0.3*x, 0.5*y, 0.4*rotation);

    SmartDashboard.putNumber("Strafing Error", error);
    }

    //The x value is first for some reason
    
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
