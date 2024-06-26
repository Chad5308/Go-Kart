// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.Drive;

public class RobotContainer {
public Drive drive = new Drive();
public DriveCommand driveCommand = new DriveCommand(drive);

  public RobotContainer() {
    drive.setDefaultCommand(driveCommand);

    configureBindings();
  }



  private void configureBindings() {

// driveCommand.controller.x().onTrue(Commands.runOnce(() -> {driveCommand.inPlace();}));
driveCommand.controller.button(3).whileTrue(Commands.runOnce(() -> {driveCommand.inPlaceTrue();}));
driveCommand.controller.button(3).whileFalse(Commands.runOnce(() -> {driveCommand.inPlaceFalse();}));




// driveCommand.controller.povUp().onTrue(Commands.runOnce(() -> {driveCommand.increaseSpeed();}));
// driveCommand.controller.povDown().onTrue(Commands.runOnce(() -> {driveCommand.decreaseSpeed();}));
// driveCommand.controller.povLeft().onTrue(Commands.runOnce(() -> {driveCommand.cruiseControl();}));
// driveCommand.controller.povRight().onTrue(Commands.runOnce(() -> {driveCommand.resume();}));
// driveCommand.controller.b().onTrue(Commands.runOnce(() -> {driveCommand.cancel();}));

// driveCommand.controller.axisGreaterThan(3, 0.25).onTrue(Commands.runOnce(() -> {driveCommand.cancel();}));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
