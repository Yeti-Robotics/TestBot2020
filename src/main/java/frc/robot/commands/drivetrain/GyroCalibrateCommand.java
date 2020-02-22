package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;


public class GyroCalibrateCommand extends CommandBase {
    private final DrivetrainSubsystem drivetrainSubsystem;
    private static boolean executeCompleted;

    public GyroCalibrateCommand(DrivetrainSubsystem drivetrainSubsystem) {
        this.drivetrainSubsystem = drivetrainSubsystem;
        addRequirements(drivetrainSubsystem);
    }

    @Override
    public void initialize() {
        executeCompleted = false;
        drivetrainSubsystem.gyroCalibrate();
        executeCompleted = true;
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        if (executeCompleted=true){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void end(boolean interrupted) {

    }
}
