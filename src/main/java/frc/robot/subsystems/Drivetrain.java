/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.commands.Mecanumdrive;
import edu.wpi.first.wpilibj.SPI;

/**
 * Got most of the info for this here: https://github.com/frc3946/MecanumDrivetrain/blob/master/src/edu/wpi/first/wpilibj/templates/subsystems/DriveTrain.java
 */
public class Drivetrain extends Subsystem {
  public static CANSparkMax leftFront = new CANSparkMax(RobotMap.LEFT_DRIVE_PORT_FRONT, MotorType.kBrushless);
  public static CANSparkMax leftBack = new CANSparkMax(RobotMap.LEFT_DRIVE_PORT_BACK, MotorType.kBrushless);
  public static CANSparkMax rightFront = new CANSparkMax(RobotMap.RIGHT_DRIVE_PORT_FRONT, MotorType.kBrushless);
  public static CANSparkMax rightBack = new CANSparkMax(RobotMap.RIGHT_DRIVE_PORT_BACK, MotorType.kBrushless);

  public static CANEncoder rightCanEncoder = new CANEncoder(rightFront);
  public static CANEncoder leftCanEncoder = new CANEncoder(leftFront);

  public static AHRS gyro = new AHRS(SPI.Port.kMXP);

  public static MecanumDrive drive = new MecanumDrive(leftFront, leftBack, rightFront, rightBack); 
  
  public static boolean polarMode = true; 

  public Drivetrain () {
    gyro.reset();
    
  }

  public static void drive(double yspeed, double xspeed, double rotation) {
    drive.driveCartesian(0.5*yspeed, 0.5*xspeed, 0.5*rotation);
  }

  /* figure out how to reset these encoders
  
  public static void resetEncoder () {
    leftCanEncoder.
    rightCanEncoder.reset();
  }
  
  */

  public static double getLeftEncoder () {
    return leftCanEncoder.getPosition();
  }

  public static double getRightEncoder () {
    return rightCanEncoder.getPosition();
  }

  public static double getFacingAngle () {
    return gyro.getAngle();
  }

  public static void resetGyro () {
    gyro.reset();
  }

  public static double getJoystickAngle () {
    return Math.atan(OI.driveCont.getRawAxis(0)/OI.driveCont.getRawAxis(1));
  }


  public void update () {
    SmartDashboard.putNumber("Left Encoder", getLeftEncoder());
    SmartDashboard.putNumber("Right Encoder", getRightEncoder());
    SmartDashboard.putNumber("Angle", getFacingAngle());
    SmartDashboard.putNumber("Joystick Angle", getJoystickAngle());
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
     setDefaultCommand(new Mecanumdrive());
  }
}







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

