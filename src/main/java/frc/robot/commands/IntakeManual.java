/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Intake;

public class IntakeManual extends Command {
  double speed;
  public IntakeManual(double speed=b) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Intake);
    this.b=speed;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Intake.runIntake(0);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Intake.runIntake(speed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
    Intake.runIntake(0);
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Intake.runIntake(0);
  }


  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
