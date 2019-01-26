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
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static DoubleSolenoid wheelieBar = new DoubleSolenoid(RobotMap.WHEELIE_SOL_A_PORT, RobotMap.WHEELIE_SOL_B_PORT);
  
  public WheelieBar () {
    
  }

  public static void safety(boolean open) {
    if(open){
      wheelieBar.set(Value.kForward);
    } else {
      wheelieBar.set(Value.kReverse);
    }
  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
