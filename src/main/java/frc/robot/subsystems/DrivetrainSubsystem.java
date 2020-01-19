package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;
import org.opencv.video.SparsePyrLKOpticalFlow;

public class DrivetrainSubsystem extends SubsystemBase {
    private Spark left1Spark;
    private Spark right1Spark;
    private Spark left2Spark;
    private Spark right2Spark;
    private Spark left3Spark;
    private Spark right3Spark;
// Any variables/fields used in the constructor must appear before the "INSTANCE" variable
// so that they are initialized before the constructor is called.

    public DrivetrainSubsystem() {
        left1Spark = new Spark(Constants.LEFT_SPARK_1);
        left2Spark = new Spark(Constants.LEFT_SPARK_2);
        left3Spark = new Spark(Constants.LEFT_SPARK_3);
        right1Spark = new Spark(Constants.RIGHT_SPARK_1);
        right2Spark = new Spark(Constants.RIGHT_SPARK_2);
        right3Spark = new Spark(Constants.RIGHT_SPARK_3);

        left3Spark.setInverted(true);
        right3Spark.setInverted(true);

    }
    public void drive(double leftPower, double rightPower) {
        left1Spark.set(leftPower);
        left2Spark.set(leftPower);
        left3Spark.set(leftPower);
        right1Spark.set(rightPower);
        right2Spark.set(rightPower);
        right3Spark.set(rightPower);

    }

    @Override
    public void periodic() {
        double leftY = Robot.robotContainer.leftJoy.getY();
        double rightY = Robot.robotContainer.rightJoy.getY();
        drive(-leftY, rightY);
        // System.out.println("drivetrain periodic");
    }
}

