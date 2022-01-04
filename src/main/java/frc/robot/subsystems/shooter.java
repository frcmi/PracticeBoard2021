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
    private Joystick m_theStick = new Joystick(2);
    @Override
    public void teleopPeriodic() { //runs every 20 ms
        container.Shooter.shooter(m_theStick.getY());
        boolean toggleOn = false;
        boolean togglePressed = false;
    }
    public void shooter(double x) {
            updateToggle();
            if(toggleOn){
                m_shooter.set(x);
            }else{
                m_shooter.set(0);
                //if button is not pressed, motor will not have power
            }
    }
        public void updateToggle()
        {
            if(m_theStick.getRawButton(1)){
                if(!togglePressed){
                    toggleOn = !toggleOn;
                    togglePressed = true;
             }
            }else{
                togglePressed = false;
            }
        }
    } 
}