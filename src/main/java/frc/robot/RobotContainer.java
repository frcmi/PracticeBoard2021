package frc.robot;

import static frc.robot.Constants.*;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
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
  private final Turret turret = new Turret();
  private final Intake intake = new Intake();
  private final Limelight limelight = new Limelight();
}

public RobotContainer() {
    // Auto-shooting
    JoystickButton shootBall = new JoystickButton(driver, Controls.SHOOT_BALL);
    ShootBall shootBallCmd = new ShootBall(shooter, intake, turret, limelight);
    shootBall.whenPressed(shootBallCmd);
    shootBall.whenReleased(new InstantCommand(() -> {
      shootBallCmd.cancel();
      shooter.setFlywheelPercent(0);
      shooter.closeBallGate();
      turret.setRotatorSpeed(0);
    }));

    JoystickButton toggleLock = new JoystickButton(driver, 8);
    // Intake running
    JoystickButton runIntakeFwd = new JoystickButton(driver, Controls.RUN_INTAKE_FWD);
    runIntakeFwd.whenPressed(new InstantCommand(() -> {
      intake.setInternalRoller(1.0);
      intake.setExternalRoller(-1.0); 
    }
    ));
    runIntakeFwd.whenReleased(new InstantCommand(() -> {
      intake.setInternalRoller(0);
      intake.setExternalRoller(0);
    }
    ));

    JoystickButton runIntakeRvs = new JoystickButton(driver, Controls.RUN_INTAKE_RVS);
    runIntakeRvs.whenPressed(new InstantCommand(() -> {
      intake.setInternalRoller(-1.0);
      intake.setExternalRoller(1.0); 
    }
    ));
    runIntakeRvs.whenReleased(new InstantCommand(() -> {
      intake.setInternalRoller(0);
      intake.setExternalRoller(0); 
    }
    ));

    JoystickButton toggleIntakeRaised = new JoystickButton(driver, Controls.TOGGLE_INTAKE_RAISED);
    toggleIntakeRaised.whenPressed(new InstantCommand(() -> intake.toggleRaised()));
    // Manual shooting
    JoystickButton manualSpinShooter = new JoystickButton(driver, Controls.SHOOT_BALL_MANUAL);
    manualSpinShooter.whenPressed(new InstantCommand(() -> shooter.setFlywheelRPM(4000)));
    manualSpinShooter.whenReleased(new InstantCommand(() -> shooter.setFlywheelRPM(0)));

    //Operator controls:

    // Turret control
    turret.setDefaultCommand(new RotateWithJoystick(turret, () -> operator.getX(Controls.ROTATE_TURRET)));

    // Limelight zoom
    JoystickButton toggleLimelightZoom = new JoystickButton(operator, Controls.TOGGLE_LIMELIGHT_ZOOM);
    toggleLimelightZoom.whenPressed(new InstantCommand(() -> limelight.toggleZoom()));

    public Command getAutonomousCommand() {
        return new SequentialCommandGroup(
          new InstantCommand(() -> shooter.openBallGate()),
          new ParallelCommandGroup(
            new TurnTurretForTime(turret, 0.22, 4),
          new AlignTurret(turret, limelight, true),
          new ShooterRev(shooter, limelight),
          new TimedIntake(intake, 1.0, 0.22, TimedIntake.IntakeMode.INTERNAL),
          new ShooterRev(shooter, limelight),
          new TimedIntake(intake, 1.0, 0.15, TimedIntake.IntakeMode.INTERNAL),
          new ShooterRev(shooter, limelight),
          new TimedIntake(intake, 1.0, 0.15, TimedIntake.IntakeMode.INTERNAL),
          new InstantCommand(() -> intake.setRaised(false))));
      }  
}