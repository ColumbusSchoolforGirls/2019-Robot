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

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.LiftManual;

/**
 * Thi subsystem is for the 4 bar lift
 */
public class Lift extends Subsystem {
  public static TalonSRX lift = new TalonSRX(RobotMap.LIFT_PORT);

  public Lift () {
    lift.setNeutralMode(NeutralMode.Brake);
  }

  public static void liftMotor(double speed){
    lift.set(ControlMode.PercentOutput, speed);
      
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new LiftManual());
  }

}
