/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.pidcommands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Global;
import frc.robot.PIDCalculator;
import frc.robot.Robot;
import frc.robot.subsystems.Drivetrain;

public class StrafeStaight extends Command {

  private double leftError;
  private double rightError;
  private double angle;
  private double setpoint;
  private PIDCalculator distPID;
  private PIDCalculator anglePID;

  public StrafeStaight(double angle) {
    requires(Robot.drivetrain);
    setpoint = angle;
    distPID = new PIDCalculator(Global.DRIVETRAIN_P, Global.DRIVETRAIN_I, Global.DRIVETRAIN_D);
    anglePID = new PIDCalculator(Global.DRIVESTRAIGHT_ANGLE_P, Global.DRIVESTRAIGHT_ANGLE_I, Global.DRIVESTRAIGHT_ANGLE_D);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    angle = Drivetrain.getFacingAngle();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    leftError = setpoint - Drivetrain.getLeftEncoder();
    rightError = setpoint - Drivetrain.getRightEncoder();
    double angleError = angle - Drivetrain.getFacingAngle();

    double leftOutput = distPID.getOutput(leftError);
    double rightOutput = distPID.getOutput(rightError);
    double angleOutput = anglePID.getOutput(angleError);

    SmartDashboard.putNumber("Left Error", leftError);
    SmartDashboard.putNumber("Right Error", rightError);

    Drivetrain.drive(-leftOutput - angleOutput, -rightOutput + angleOutput, 0);

  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Drivetrain.drive(0,0,0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Drivetrain.drive(0, 0, 0);
  }
}
