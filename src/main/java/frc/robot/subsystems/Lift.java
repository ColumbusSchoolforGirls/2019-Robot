/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.LiftManual;

/**
 * Add your docs here.
 */
public class Lift extends Subsystem {
  public static TalonSRX lift = new TalonSRX(RobotMap.LIFT_PORT);
  public static Encoder liftEncoder = new Encoder(RobotMap.LIFT_ENCODER_A, RobotMap.LIFT_ENCODER_B);

  public Lift () {
    liftEncoder.reset();
  }
  public static void liftMotor(double speed){
    lift.set(ControlMode.PercentOutput, speed);
      
  }

  public static void resetEncoder(){
    liftEncoder.reset();
  }

  public static double getEncoder(){
    return liftEncoder.getDistance();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new LiftManual());
  }
  public void update(){
    SmartDashboard.putNumber("Elevator Encoder", getEncoder());
  }
}
