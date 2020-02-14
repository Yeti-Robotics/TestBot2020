package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMTalonFX;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.TalonFXSensorCollection;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import org.opencv.video.SparsePyrLKOpticalFlow;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class DrivetrainSubsystem extends SubsystemBase {
    private Spark left1Spark;
    private Spark right1Spark;
    private Spark left2Spark;
    private Spark right2Spark;
    private Spark left3Spark;
    private Spark right3Spark;

    private TalonFX falcon;
    // Any variables/fields used in the constructor must appear before the
    // "INSTANCE" variable
    // so that they are initialized before the constructor is called.

    public DrivetrainSubsystem() {
        left1Spark = new Spark(Constants.LEFT_SPARK_1);
        left2Spark = new Spark(Constants.LEFT_SPARK_2);
        left3Spark = new Spark(Constants.LEFT_SPARK_3);
        right1Spark = new Spark(Constants.RIGHT_SPARK_1);
        right2Spark = new Spark(Constants.RIGHT_SPARK_2);
        right3Spark = new Spark(Constants.RIGHT_SPARK_3);

        falcon = new TalonFX(5);

        left3Spark.setInverted(true);
        falcon.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 0);

    }

    public void drive(double leftPower, double rightPower) {
        left1Spark.set(leftPower);
        left2Spark.set(leftPower);
        left3Spark.set(leftPower);
        right1Spark.set(rightPower);
        right2Spark.set(rightPower);
        right3Spark.set(rightPower);
    }

    public void driveWithMinPower(double leftPower, double rightPower, double minAbsolutePower) {
        double realLeftPower = (leftPower / Math.abs(leftPower)) * Math.max(Math.abs(leftPower), minAbsolutePower);
        double realRightPower = (rightPower / Math.abs(rightPower)) * Math.max(Math.abs(rightPower), minAbsolutePower);

        left1Spark.set(realLeftPower);
        left2Spark.set(realLeftPower);
        left3Spark.set(realLeftPower);
        right1Spark.set(realRightPower);
        right2Spark.set(realRightPower);
        right3Spark.set(realRightPower);
    }

    public void testFalcon() {
        falcon.set(TalonFXControlMode.PercentOutput, 0.3);
    }

    public void stopFalcon() {
        falcon.set(TalonFXControlMode.PercentOutput, 0);
    }

    public void resetEncoder(){
        falcon.setSelectedSensorPosition(0);
    }

    // public double getFalconEncoder() {
    //     TalonFXSensorCollection sensorCollection = falcon.getSensorCollection();
    //     return sensorCollection.getIntegratedSensorPosition();
    // }

    public double getFalconEncoder() {
        return falcon.getSelectedSensorPosition();
    }

    @Override
    public void periodic() {
        // double leftY = Robot.robotContainer.leftJoy.getY();
        // double rightY = Robot.robotContainer.rightJoy.getY();
        //drive(-leftY, rightY);

        // System.out.println(leftY + ", " + rightY);

        NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
        NetworkTableEntry tx = table.getEntry("tx");
        NetworkTableEntry ty = table.getEntry("ty");
        NetworkTableEntry ta = table.getEntry("ta");

//read values periodically
        double x = tx.getDouble(0.0);
        double y = ty.getDouble(0.0);
        double area = ta.getDouble(0.0);

//post to smart dashboard periodically
        SmartDashboard.putNumber("LimelightX", x);
        SmartDashboard.putNumber("LimelightY", y);
        SmartDashboard.putNumber("LimelightArea", area);
    }

}

