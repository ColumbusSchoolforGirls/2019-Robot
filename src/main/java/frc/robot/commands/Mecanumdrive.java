/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.drive.RobotDriveBase;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;

public class MecanumDrive extends RobotDriveBase {
  public MecanumDrive() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  @Override
  public void initSendable(SendableBuilder builder) {

  }

  public void driveCartesian () {

  }

  @Override
  public void stopMotor() {

  }

  @Override
  public String getDescription() {
    return null;
}
}
