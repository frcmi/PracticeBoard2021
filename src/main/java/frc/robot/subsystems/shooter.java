package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.SpeedController;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.*; 
public class Shooter extends SubsystemBase {
    WPI_TalonFX m_main = new WPI_TalonFX(4);
    SpeedController m_shooter = m_main;
    public final Joystick leftJoystick = new Joystick(2);
    private JoystickButton theStick = new JoystickButton(leftJoystick,2);
    //making a button
    @Override
    public void set(double x){
        while(toggleIntakeButton.get() == true){
            mIntake.set(x);
        }
    }
    public void teleopPeriodic() { //runs every 20 ms
        
    
    }
}