/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.Mecanumdrive;

/**
 * Got most of the info for this here: https://github.com/frc3946/MecanumDrivetrain/blob/master/src/edu/wpi/first/wpilibj/templates/subsystems/DriveTrain.java
 */
public class Drivetrain extends Subsystem {
  public static CANSparkMax leftFront = new CANSparkMax(RobotMap.LEFT_DRIVE_PORT_FRONT, MotorType.kBrushless);
  public static CANSparkMax leftBack = new CANSparkMax(RobotMap.LEFT_DRIVE_PORT_BACK, MotorType.kBrushless);
  public static CANSparkMax rightFront = new CANSparkMax(RobotMap.RIGHT_DRIVE_PORT_FRONT, MotorType.kBrushless);
  public static CANSparkMax rightBack = new CANSparkMax(RobotMap.RIGHT_DRIVE_PORT_BACK, MotorType.kBrushless);
  public static MecanumDrive drive = new MecanumDrive(leftFront, leftBack, rightFront, rightBack); //Command is deprecated!!!
  public static boolean polarMode = true; 

  public Drivetrain () {
    
  }

  public void mecanumDrive(double x, double y, double rotation, double gyro) {
    SmartDashboard.putNumber("X", x);
    SmartDashboard.putNumber("Y", y);
    SmartDashboard.putNumber("Rotation", rotation);
    SmartDashboard.putNumber("Gyro", gyro);
  }

  public static void drive(double yspeed, double xspeed, double rotation) {
    drive.driveCartesian(0.5*yspeed, 0.5*xspeed, 0.5*rotation);
  }

  public void update () {
    
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
     setDefaultCommand(new Mecanumdrive());
//the PID coding to fix the strafe

     /* protected void execute() {
    	leftError = setpoint - Drivetrain.getLeftEncoder();
    	rightError = setpoint - Drivetrain.getRightEncoder();
    	double angleError = angle - Drivetrain.getFacingAngle();

    	double leftOutput = distPID.getOutput(leftError);
    	double rightOutput = distPID.getOutput(rightError);
    	double angleOutput = anglePID.getOutput(angleError);

    	SmartDashboard.putNumber("Left Error", leftError);    	
    	SmartDashboard.putNumber("Right Error", rightError);

    	if (leftOutput > speedcap) {
    		leftOutput = speedcap; 
    	} else if (leftOutput < -speedcap) {
    		leftOutput = -speedcap;
    	}

    	if (rightOutput > speedcap) {
    		rightOutput = speedcap;
    	} else if (rightOutput < -speedcap) {
    		rightOutput = -speedcap;
    	}

    	double leftSpeed = -leftOutput - angleOutput;
    	double rightSpeed = -rightOutput + angleOutput;

    	Drivetrain.setSpeed(ControlMode.PercentOutput, leftSpeed, rightSpeed);
    }

    protected boolean isFinished() {
        return Math.abs(leftError) <= Global.DRIVE_DISTANCE_TOLERANCE;
    }

    protected void end() {
    	Drivetrain.setSpeed(ControlMode.PercentOutput, 0, 0);
//    	Drivetrain.resetEncoders();    	
    }

    protected void interrupted() {
    }

} */
  }
}
