/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
// import frc.robot.commands.drivetrain.DriveForTimeCommand;
// import frc.robot.commands.drivetrain.GyroCalibrateCommand;
import frc.robot.commands.drivetrain.TurnToTargetCommand;
import frc.robot.commands.funnel.FunnelInCommand;
import frc.robot.commands.intake.RollInCommand;
import frc.robot.commands.intake.RollOutCommand;
import frc.robot.commands.neck.MoveDownNeckCommand;
import frc.robot.commands.neck.MoveUpNeckCommand;
import frc.robot.commands.shooting.ReverseShootCommand;
import frc.robot.commands.shooting.SetHoodAngleCommand;
import frc.robot.commands.shooting.ShootCommand;
import frc.robot.commands.shooting.TestServoCommand;
import frc.robot.commands.wheelOfFortune.PositionControlCommand;
import frc.robot.commands.wheelOfFortune.RotationControlCommand;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public final Joystick leftJoy;
  public final Joystick rightJoy;
  public final Joystick secondaryJoy;
  private WheelOfFortuneSubsystem wheelOfFortuneSubsystem;
  private DrivetrainSubsystem drivetrainSubsystem;
  private IntakeSubsystem intakeSubsystem;
  private NeckSubsystem neckSubsystem;
  private ShooterSubsystem shooterSubsystem;
  private FunnelSubsystem funnelSubsystem;
  
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    leftJoy = new Joystick(Constants.LEFT_JOYSTICK);
    rightJoy = new Joystick(Constants.RIGHT_JOYSTICK);
    secondaryJoy = new Joystick(Constants.SECONDARY_JOYSTICK);

    drivetrainSubsystem = new DrivetrainSubsystem();
    wheelOfFortuneSubsystem = new WheelOfFortuneSubsystem();
    neckSubsystem = new NeckSubsystem();
    shooterSubsystem = new ShooterSubsystem();
    funnelSubsystem = new FunnelSubsystem();
    intakeSubsystem = new IntakeSubsystem();

    drivetrainSubsystem.setDefaultCommand(new RunCommand(() -> drivetrainSubsystem.drive(getLeftY(), getRightY()), drivetrainSubsystem));
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // setJoystickButton(leftJoy, 5,new DriveForTimeCommand(drivetrainSubsystem, 1000, 0.5)); // test auto

    setJoystickButton(leftJoy, 3, new PositionControlCommand(wheelOfFortuneSubsystem));

    setJoystickButton(secondaryJoy, 4, new RotationControlCommand(wheelOfFortuneSubsystem));

    setJoystickButton(secondaryJoy, 1, new RollInCommand(intakeSubsystem));

    setJoystickButton(secondaryJoy, 2, new RollOutCommand(intakeSubsystem));

    setJoystickButton(secondaryJoy, 3, new MoveUpNeckCommand(neckSubsystem));

    setJoystickButton(secondaryJoy, 10, new MoveDownNeckCommand(neckSubsystem));

    setJoystickButton(secondaryJoy, 7, new ShootCommand(shooterSubsystem));

    setJoystickButton(rightJoy, 2, new TestServoCommand(shooterSubsystem, 0));

    setJoystickButton(rightJoy, 1, new TestServoCommand(shooterSubsystem, 180));

    setJoystickButton(leftJoy, 1, new ReverseShootCommand(shooterSubsystem));

    // setJoystickButton(leftJoy, 9, new GyroCalibrateCommand(drivetrainSubsystem));

//shoot
    setJoystickButton(leftJoy, 2, new SequentialCommandGroup(
                      new SetHoodAngleCommand(shooterSubsystem, 45),
                      new ParallelCommandGroup(
                              new FunnelInCommand(funnelSubsystem),
                              new MoveUpNeckCommand(neckSubsystem),
                              new ShootCommand(shooterSubsystem)
                      )
                ).withInterrupt(() -> !neckSubsystem.getUpperBeamBreak()));
// //align and shoot
//     setJoystickButton(leftJoy, 4, new SequentialCommandGroup(
//       new TurnToTargetCommand(drivetrainSubsystem),
//       new SetHoodAngleCommand(shooterSubsystem,45),
//       new ParallelCommandGroup(
//               new MoveUpNeckCommand(neckSubsystem),
//               new ShootCommand(shooterSubsystem)
//       )
// ));

  setJoystickButton(leftJoy, 5, new TurnToTargetCommand(drivetrainSubsystem));
  }

  public double getLeftY() {
    return -leftJoy.getY();
    // return leftJoy.getRawAxis(RobotMap.DRIVERSTATION_LEFT_Y_AXIS);
  }

  public double getLeftX() {
    return leftJoy.getX();
  }

  public double getRightY() {
    return rightJoy.getY();
  }

  public double getRightX() {
    return rightJoy.getX();
  }

  public double getSecondaryY(){
      return secondaryJoy.getY();
  }

  private void setJoystickButton(Joystick joystick, int button, CommandBase command){
    new JoystickButton(joystick, button).whenPressed(command);
  }
}
