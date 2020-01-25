package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class NeckSubsystem extends SubsystemBase {
    private Spark neckSpark;

    public NeckSubsystem() {
      neckSpark = new Spark(Constants.NECK_SPARK);
    }

    public void moveUp(){
        neckSpark.set(Constants.NECK_UP_SPEED);
    }

    public void moveDown(){
        neckSpark.set(Constants.NECK_DOWN_SPEED);
    }

    public void stopNeck(){
        neckSpark.set(0);
    }
}

