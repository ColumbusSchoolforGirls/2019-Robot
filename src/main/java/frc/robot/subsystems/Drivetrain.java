/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

/**
 * Got most of the info for this here: https://github.com/frc3946/MecanumDrivetrain/blob/master/src/edu/wpi/first/wpilibj/templates/subsystems/DriveTrain.java
 */
public class DriveTrain extends Subsystem {
  public static CANSparkMax leftFront = new CANSparkMax(RobotMap.LEFT_DRIVE_PORT_FRONT, MotorType.kBrushless);
  public static CANSparkMax leftBack = new CANSparkMax(RobotMap.LEFT_DRIVE_PORT_BACK, MotorType.kBrushless);
  public static CANSparkMax rightFront = new CANSparkMax(RobotMap.RIGHT_DRIVE_PORT_FRONT, MotorType.kBrushless);
  public static CANSparkMax rightBack = new CANSparkMax(RobotMap.RIGHT_DRIVE_PORT_BACK, MotorType.kBrushless);
  public final RobotDrive drive = new RobotDrive(leftFront, leftBack, rightFront, rightBack); //Command is deprecated!!!
  public static boolean polarMode = true; 

  public DriveTrain () {
    super();
    drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
    drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
  }

  public void mecanumDrive(double x, double y, double rotation, double gyro) {
    SmartDashboard.putNumber("X", x);
    SmartDashboard.putNumber("Y", y);
    SmartDashboard.putNumber("Rotation", rotation);
    SmartDashboard.putNumber("Gyro", gyro);
    if (DriveTrain.polarMode == true) {
      SmartDashboard.putString("polarMode", "Polar Mode");
    } else {
      SmartDashboard.putString("polarMode", "Field Oriented");
    }

    if (polarMode == true) {
      drive.mecanumDrive_Polar(Math.sqrt(x * x + y * y), (Math.toDegrees(MathUtils.atan2(y, x)) - 90), rotation);  //What are you trying to accomplish?
    } else {
      drive.mecanumDrive_Cartesian(.7 * x, .7 * y, .7 * rotation, gyro);
    }
  }

  public void update () {
    
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
