/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 * Add your docs here.
 */
public class Vision extends Subsystem {
  NetworkTable table;

  double[] defaultValue = new double[0];

  public Vision () {
    table = NetworkTable.getSubTable("GRIP/myContoursReport");
  }

  public void networkTable () {
    double[] areas = table.getNumberArray("area", defaultValue);
    System.out.print("areas: ");
    for (double area : areas) {
      System.out.print(area + " ");
    }
    System.out.println();
    Timer.delay(1);
  }



  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
