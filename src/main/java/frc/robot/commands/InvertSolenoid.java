// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.Pneumatics;

public class InvertSolenoid extends CommandBase {
  private Solenoid solenoid;
  private Pneumatics pneumatics;

  /** Creates a new SolenoidTEST. */
  public InvertSolenoid() {
    pneumatics = Robot.container.pneumatics;
    solenoid = pneumatics.solenoid;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    solenoid.set(!solenoid.get());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
