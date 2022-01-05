package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wapi.first.wpilibj.Buttons.*;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


public class Intake extends SubsystemBase {
  private JoystickButton toggleIntakeButton = new JoystickButton(leftJoystick, 0);
  public final Joystick leftJoystick = new Joystick(0);

private void configureButtonBindings() {
  //toggleIntakeButton.whenPressed(toggleIntake);
  //^ alternate method for pressing button
}

  WPI_TalonFX motor = new WPI_TalonFX(0);
  SpeedController mIntake = m_main;
  /**
   * Creates a new ExampleSubsystem.
   */
  public void Intake(double x) {
    while(toggleIntakeButton.get() == true){
      mIntake.set(x);
    }
//presses button
    
  }
// one motor
//motor runs when joystick button "toggleIntakeButton" is pressed

/

  @Override
  public void teleoPeriodic() { 

  }
}
  }
}