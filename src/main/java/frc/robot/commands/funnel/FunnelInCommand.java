package frc.robot.commands.funnel;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FunnelSubsystem;


public class FunnelInCommand extends CommandBase {
    private final FunnelSubsystem funnelSubsystem;

    public FunnelInCommand(FunnelSubsystem funnelSubsystem) {
        this.funnelSubsystem = funnelSubsystem;
        addRequirements(funnelSubsystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        funnelSubsystem.funnelIn();
    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        funnelSubsystem.funnelStop();
    }
}
