package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class NeckSubsystem extends SubsystemBase {


    private Spark neckSparkMini;
    private Spark neckSparkBelt;
    public NeckSubsystem() {
      neckSparkMini = new Spark(Constants.NECK_SPARK_MINI);
      neckSparkBelt = new Spark(Constants.NECK_SPARK_BELT);
    }

    public void miniRollIn(){
        neckSparkMini.set(Constants.MINI_ROLL_IN);
    }

    public void miniRollOut(){
        neckSparkMini.set(Constants.MINI_ROLL_OUT);
    }

    public void miniRollStop(){
        neckSparkMini.set(0);
    }

    public void beltUp(){
        neckSparkBelt.set(Constants.BELT_UP);
    }

    public void beltDown(){
        neckSparkBelt.set(Constants.BELT_DOWN);
    }

    public void beltStop(){
        neckSparkBelt.set(0);
    }
}

