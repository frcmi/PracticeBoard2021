package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;


public class Intake extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  public Intake() {


  }
// one motor
//permanently run motor, it spins rod

// initializes new motor
WPI_TalonFX motor = new WPI_TalonFX(0);
  @Override
  public void periodic() { //test comment

    // This method will be called once per scheduler run
    
  }
}