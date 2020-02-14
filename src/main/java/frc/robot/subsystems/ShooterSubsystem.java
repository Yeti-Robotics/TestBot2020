package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {

    private Spark shooter1Spark;
    private Spark shooter2Spark;
    public Servo hoodServo1, hoodServo2;
    
    public ShooterSubsystem() {
        shooter1Spark = new Spark(Constants.SHOOTER_1_SPARK);
        shooter2Spark = new Spark(Constants.SHOOTER_2_SPARK);
        hoodServo1 = new Servo(Constants.SHOOTER_SERVO_1);
        hoodServo2 = new Servo(Constants.SHOOTER_SERVO_2);
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

    
    @Override
    public void periodic() {
        // TODO Auto-generated method stub
        System.out.println("position: " + hoodServo1.getPosition() + " angle: " + hoodServo1.getAngle() + "position variable: " + getHoodPosition());
        super.periodic();
    }

    public void setServo(double pos){
    //     hoodServo1.set(pos);
    //     hoodServo2.set(1-pos);
        hoodServo1.setAngle(180-pos);
        hoodServo2.setAngle(pos);

    }

    public void resetServo(){
        hoodServo1.set(0.1);
    }

    public double getHoodAngle(){
        return hoodServo1.getAngle();
    }

    public double getHoodPosition(){
        return hoodServo1.getPosition();
    }

    public double calcHoodAngle(){
        return Math.toDegrees(Math.asin(Math.sqrt(Constants.SHOOTER_HEIGHT * 2 * Constants.GRAVITY) / Constants.SHOOT_1_SPEED));
    }

}

