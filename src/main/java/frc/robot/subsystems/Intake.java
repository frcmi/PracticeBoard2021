package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

<<<<<<< HEAD
public class Intake extends SubsystemBase {
 // WPI_TalonFX motor = new WPI_TalonFX(0);
  
=======

public class Intake extends SubsystemBase {
  public final Joystick leftJoystick = new Joystick(0);
  private JoystickButton toggleIntakeButton = new JoystickButton(leftJoystick, 0);

  WPI_TalonFX motor = new WPI_TalonFX(0);
  SpeedController mIntake = m_main;
>>>>>>> 7de29ee08d6d032c3d94fb79c5b9e0427161d26f
  /**
   * Creates a new ExampleSubsystem.
   */
  public void Intake(double x) {
    while(toggleIntakeButton.get() == true){
      mIntake.set(x);
    }
//presses button
// one motor
//motor runs when joystick button "toggleIntakeButton" is pressed

<<<<<<< HEAD
// initializes new motor

  

  
=======
/

  @Override
  public void teleoPeriodic() { 

  }
>>>>>>> 7de29ee08d6d032c3d94fb79c5b9e0427161d26f
}