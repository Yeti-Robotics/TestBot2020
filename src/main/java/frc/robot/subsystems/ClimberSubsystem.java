package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimberSubsystem extends SubsystemBase {

    private TalonSRX climberTalon;
    public ClimberSubsystem() {
        climberTalon = new TalonSRX(Constants.CLIMBER_TALON);
    }

    public void climbUp(){
        climberTalon.set(ControlMode.PercentOutput, Constants.CLIMBER_SPEED);
    }

    public void climbDown(){
        climberTalon.set(ControlMode.PercentOutput, -Constants.CLIMBER_SPEED);
    }

    public void stopClimb(){
        climberTalon.set(ControlMode.PercentOutput, 0);
    }

}

