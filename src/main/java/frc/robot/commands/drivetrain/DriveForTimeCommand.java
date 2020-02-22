package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;


public class DriveForTimeCommand extends CommandBase {
    private final DrivetrainSubsystem drivetrainSubsystem;
    double time, power;
    private int counter;

    public DriveForTimeCommand(DrivetrainSubsystem drivetrainSubsystem, double t, double p) {
        this.drivetrainSubsystem = drivetrainSubsystem;
        addRequirements(drivetrainSubsystem);
        this.time = t;
        this.power = p;
    }

    @Override
    public void initialize() {
        counter = 0;
        System.out.println("drive started");
    }

    @Override
    public void execute() {
        drivetrainSubsystem.drive(power,power);
        counter++;
    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return counter>time;
    }

    @Override
    public void end(boolean interrupted) {
        drivetrainSubsystem.drive(0,0);
        System.out.println("drive done");

    }
}
