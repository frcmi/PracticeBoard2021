package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  public Intake() {


  }
// one motor
//permanently run motor, it spins rod

WPI_TalonFX m_main = new WPI_TalonFX(0);
// initializes new motor

  @Override

  

  
  public void periodic() { //test comment

    // This method will be called once per scheduler run
    
  }
}