/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

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
    public static final int INTAKE_SPARK = 1738;
    public static final int NECK_SPARK_MINI = 69;
    public static final int NECK_SPARK_BELT = 420;
    public static final int SHOOTER_1_SPARK = 987654321;
    public static final int SHOOTER_2_SPARK = 123456789;

    public static final int WHEEL_OF_FORTUNE_TALON = 5;
    public static final int LEFT_JOYSTICK = 0;
    public static final int RIGHT_JOYSTICK = 1;
    public static final int SECONDARY_JOYSTICK = 2;

    public static final int JEVOIS_BAUD_RATE = 115200;

    public static final double ROLL_IN_SPEED = 0.5;
    public static final double ROLL_OUT_SPEED = -0.5;
    public static final double MINI_ROLL_IN = 0.5;
    public static final double MINI_ROLL_OUT = -0.5;
    public static final double BELT_UP = 0.5;
    public static final double BELT_DOWN = -0.5;
    public static final double SHOOT_1_SPEED = 0.5;
    public static final double SHOOT_2_SPEED = 0.5;
    public static final double REVERSE_SHOOT_1_SPEED = -0.5;
    public static final double REVERSE_SHOOT_2_SPEED = -0.5;
}
