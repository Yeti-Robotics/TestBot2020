package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FunnelSubsystem extends SubsystemBase {

    private Spark funnelSpark;

    public FunnelSubsystem() {
        funnelSpark = new Spark(Constants.FUNNEL_SPARK);
    }

    public void funnelIn() {
        funnelSpark.set(Constants.FUNNEL_IN_SPEED);
    }

    public void funnelOut() {
        funnelSpark.set(Constants.FUNNEL_OUT_SPEED);
    }

    public void funnelStop() {
        funnelSpark.set(0);
    }

}

