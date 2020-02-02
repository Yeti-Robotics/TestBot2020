package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {

    private Spark shooter1Spark;
    private Spark shooter2Spark;
    private Servo hoodServo;

    public ShooterSubsystem() {
        shooter1Spark = new Spark(Constants.SHOOTER_1_SPARK);
        shooter2Spark = new Spark(Constants.SHOOTER_2_SPARK);
        hoodServo = new Servo(Constants.SHOOTER_SERVO);
    }

    public void shoot(){
        shooter1Spark.set(Constants.SHOOT_1_SPEED);
        shooter2Spark.set(Constants.SHOOT_2_SPEED);
    }

    public void reverseShoot(){
        shooter1Spark.set(Constants.REVERSE_SHOOT_1_SPEED);
        shooter2Spark.set(Constants.REVERSE_SHOOT_2_SPEED);
    }

    public void stopShoot(){
        shooter1Spark.set(0);
        shooter2Spark.set(0);
    }

    public void setHoodAngle(double angle){
        hoodServo.setAngle(angle);
    }

    public double getHoodAngle(){
        return hoodServo.getAngle();
    }

    public double calcHoodAngle(){
        return Math.toDegrees(Math.asin(Math.sqrt(Constants.SHOOTER_HEIGHT * 2 * Constants.GRAVITY) / Constants.SHOOT_1_SPEED));
    }

}

