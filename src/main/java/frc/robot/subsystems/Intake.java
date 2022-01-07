package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  public void intake() {
      while(toggleIntakeButton.get() == true){
      mIntake.set(1.0);
    }
  }
//presses button
// one motor
//motor runs when joystick button "toggleIntakeButton" is pressed



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}