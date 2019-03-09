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
import frc.robot.PIDCalculator;
import frc.robot.Robot;
import frc.robot.subsystems.Lift;

public class LiftSetAngle extends Command {
  private double error;
  private double setpoint;
  private PIDCalculator distPID;

  public LiftSetAngle(double sonar, double p, double i, double d) {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.lift);
    setpoint = sonar;
    distPID = new PIDCalculator(p, i, d);
    Lift.liftMotor(0);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    error = setpoint - Lift.getSonar();

    double output = distPID.getOutput(error);

    SmartDashboard.putNumber("Lift Error", error);

    Lift.liftMotor(output);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Math.abs(error) <= Global.LIFT_TOLERANCE;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Lift.liftMotor(.25);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Lift.liftMotor(0);
  }
}
