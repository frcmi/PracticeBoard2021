package frc.robot;

import edu.wpi.first.wpilibj.XboxController.Button;

/**
 * This class contains all the constant values used for setting up
 * and running the robot.
 */
public class Constants {

    public static class Controls {
        // Driver controls:
        public static final int SHOOT_BALL = Button.kA.value;
        public static final int SHOOT_BALL_MANUAL = 7;

        // Operator controls:
        public static final int TOGGLE_LIMELIGHT_ZOOM = Button.kB.value;
        public static final int INC_RPM_OFFSET = Button.kBumperRight.value;
        public static final int DEC_RPM_OFFSET = Button.kBumperLeft.value;
    }

    // USB ids
    public static final int DRIVER = 0;
    public static final int OPERATOR = 1;

    // CANbus ids
    public static final int SHOOTER_LEFT = 8;
    public static final int SHOOTER_RIGHT = 9;

    // Shooter
    public static final double SHOOTER_P = 0.0003;
    public static final double SHOOTER_FF = 0.00019;
    public static final double RPM_STABILITY_ERROR = 25;

    // Limelight
    public static final double LL_HEIGHT_ABOVE_GROUND = 2.75;// in feet (2'9")
    public static final double LL_TARGET_HEIGHT = 7.5; // in feet (7'6")
    public static final double LL_SHOT_HEIGHT = LL_TARGET_HEIGHT - LL_HEIGHT_ABOVE_GROUND;

}