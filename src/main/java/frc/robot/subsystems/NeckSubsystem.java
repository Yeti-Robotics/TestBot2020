package frc.robot.subsystems;


import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class NeckSubsystem extends SubsystemBase {
    private Spark neckSpark;
    private DigitalInput lowerBeamBreak;
    private DigitalInput upperBeamBreak;

    public NeckSubsystem() {
      neckSpark = new Spark(Constants.NECK_SPARK);
      lowerBeamBreak = new DigitalInput(Constants.LOWER_BEAM_BREAK);
      upperBeamBreak = new DigitalInput(Constants.UPPER_BEAM_BREAK);
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

    public boolean getLowerBeamBreak() {
        return lowerBeamBreak.get();
    }

    public boolean getUpperBeamBreak() {
        return upperBeamBreak.get();
    }

}

