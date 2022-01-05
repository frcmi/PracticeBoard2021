package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wapi.first.wpilibj.Buttons.*;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public final Joystick leftJoystick = new Joystick(0)
public class Intake extends SubsystemBase {
  private JoystickButton toggleIntakeButton = new JoystickButton(leftJoystick, 0);
  
  /**
   * Creates a new ExampleSubsystem.
   */
  public void Intake() {



  }
// one motor
//permanently run motor, it spins rod

// initializes new motor
WPI_TalonFX motor = new WPI_TalonFX(0);
  @Override
  
}
/
  }
}