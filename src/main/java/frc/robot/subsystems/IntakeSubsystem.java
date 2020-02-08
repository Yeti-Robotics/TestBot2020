package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {

// Any variables/fields used in the constructor must appear before the "INSTANCE" variable
// so that they are initialized before the constructor is called.



    private Spark intakeSpark;

    public IntakeSubsystem() {
        intakeSpark = new Spark(Constants.INTAKE_SPARK);
    }

    public void rollIn(){
        intakeSpark.set(Constants.ROLL_IN_SPEED);
    }

    public void rollOut(){
        intakeSpark.set(Constants.ROLL_OUT_SPEED);
    }

    public void stopRoll(){
        intakeSpark.set(0);
    }

}

