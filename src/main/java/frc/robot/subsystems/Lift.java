/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.commands.LiftManual;

/**
 * Thi subsystem is for the 4 bar lift
 */
public class Lift extends Subsystem {
  public static TalonSRX lift = new TalonSRX(RobotMap.LIFT_PORT);
  public static AnalogInput sonar = new AnalogInput(0);

  public Lift () {
    lift.setNeutralMode(NeutralMode.Brake);
  }

  public static void liftMotor(double speed){
    lift.set(ControlMode.PercentOutput, speed);
      
  }

  public static double getLiftMotor() {
    return lift.getMotorOutputPercent();
  }

  public static double getSonar() {
    return sonar.getAverageVoltage();
  }

  public static double getDistance() {
    return getSonar()/.0098;
  }

  public void update () {
    SmartDashboard.putNumber("Lift Motor", getLiftMotor());
    SmartDashboard.putNumber("Aux Joystick", OI.auxCont.getRawAxis(1));
    SmartDashboard.putNumber("Sonar Value", getSonar());
    SmartDashboard.putNumber("Arm Distance", getDistance());
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new LiftManual());
  }

}
