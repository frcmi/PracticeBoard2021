package frc.robot;

import frc.robot.commands.InvertSolenoid;
import frc.robot.subsystems.Pneumatics;

public class RobotContainer {
    public InvertSolenoid invertSolenoid;
    public Pneumatics pneumatics = new Pneumatics();
}
