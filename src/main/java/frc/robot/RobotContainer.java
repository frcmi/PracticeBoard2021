package frc.robot;

import static frc.robot.Constants.*;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the robot subsystems and commands are declared.
 * Commands are also bound to button triggers here.
 */
public class RobotContainer {

  // Two controllers used for robot operation
  private final XboxController driver = new XboxController(DRIVER);
  private final XboxController operator = new XboxController(OPERATOR);

  // Robot subsystems:
  private final Shooter shooter = new Shooter(driver);
  private final Limelight limelight = new Limelight();


public RobotContainer() {
    // Auto-shooting
    JoystickButton shootBall = new JoystickButton(driver, Controls.SHOOT_BALL);
    ShootBall shootBallCmd = new ShootBall(shooter, limelight);
    shootBall.whenPressed(shootBallCmd);
    shootBall.whenReleased(new InstantCommand(() -> {
      shootBallCmd.cancel();  
      shooter.setFlywheelPercent(0);
      shooter.closeBallGate();
    }));

    // Manual shooting
    JoystickButton manualSpinShooter = new JoystickButton(driver, Controls.SHOOT_BALL_MANUAL);
    manualSpinShooter.whenPressed(new InstantCommand(() -> shooter.setFlywheelRPM(4000)));
    manualSpinShooter.whenReleased(new InstantCommand(() -> shooter.setFlywheelRPM(0)));

    //Operator controls:

    // Limelight zoom
    JoystickButton toggleLimelightZoom = new JoystickButton(operator, Controls.TOGGLE_LIMELIGHT_ZOOM);
    toggleLimelightZoom.whenPressed(new InstantCommand(() -> limelight.toggleZoom()));}

    public Command getAutonomousCommand() {
        return new SequentialCommandGroup(
          new InstantCommand(() -> shooter.openBallGate()),
          new ShooterRev(shooter, limelight),
          new ShooterRev(shooter, limelight),
          new ShooterRev(shooter, limelight));
      }  
}