/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class WheelieBar extends Subsystem {
  //Might need to add compressor here but it is already in the arm so idk
  //This might only work when the arm, if so then put compressor in here instead
  //If arm only works and the wheeliebar does not then have the compressor in here and in the arm
  public static DoubleSolenoid wheeliebar = new DoubleSolenoid(RobotMap.WHEELIE_SOL_A_PORT, RobotMap.WHEELIE_SOL_B_PORT);

  public WheelieBar() {

  }

  public static void drop(boolean open) {
    if (open) {
      wheeliebar.set(Value.kForward);
    } else {
      wheeliebar.set(Value.kReverse);
    }
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
