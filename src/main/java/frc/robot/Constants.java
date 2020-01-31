/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final int LEFT_SPARK_1 = 0;
    public static final int LEFT_SPARK_2 = 1;
    public static final int LEFT_SPARK_3 = 2;
    public static final int RIGHT_SPARK_1 = 3;
    public static final int RIGHT_SPARK_2 = 4;
    public static final int RIGHT_SPARK_3 = 5;
    public static final int INTAKE_SPARK = 15;
    public static final int NECK_SPARK = 19;
    public static final int SHOOTER_1_SPARK = 18;
    public static final int SHOOTER_2_SPARK = 17;
    public static final int FUNNEL_SPARK = 16;
    public static final int CLIMBER_TALON = 13;

    public static final int SHOOTER_SERVO = 14;

    public static final int WHEEL_OF_FORTUNE_TALON = 5;
    public static final int LEFT_JOYSTICK = 0;
    public static final int RIGHT_JOYSTICK = 1;
    public static final int SECONDARY_JOYSTICK = 2;

    public static final int JEVOIS_BAUD_RATE = 115200;

    public static final double ROLL_IN_SPEED = 0.5;
    public static final double ROLL_OUT_SPEED = -0.5;
    public static final double NECK_UP_SPEED = 0.5;
    public static final double NECK_DOWN_SPEED = -0.5;
    public static final double SHOOT_1_SPEED = 0.5;
    public static final double SHOOT_2_SPEED = 0.5;
    public static final double REVERSE_SHOOT_1_SPEED = -0.5;
    public static final double REVERSE_SHOOT_2_SPEED = -0.5;
    public static final double FUNNEL_IN_SPEED = 0.5;
    public static final double FUNNEL_OUT_SPEED = -0.5;
    public static final double CLIMBER_SPEED = 0.5;

    public static final int UPPER_BEAM_BREAK = 0;
    public static final int LOWER_BEAM_BREAK = 1;

    public static final double KNOWN_DISTANCE = 161.3; //inches
    public static final int PIXEL_WIDTH_KNOWN = 65; //pixels
    public static final double KNOWN_TAPE_BOUND_WIDTH = 39.25; //inches
    public static final double FOCAL_LENGTH = ( KNOWN_DISTANCE * PIXEL_WIDTH_KNOWN) / KNOWN_TAPE_BOUND_WIDTH;


}
