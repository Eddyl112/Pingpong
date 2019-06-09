/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.subsystems.Shooter;

public class Shoot extends Command {
  public Shoot() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_shooter);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    // if(OI.shooterButton.get()) {

    if(OI.driveStick.getRawButton(1)) {
      Shooter.shoot(-(OI.driveStick.getThrottle()+1)*0.15);
    } else {
      Shooter.shoot(0);
    }




    // if(OI.feederButton.get()) {
    if(OI.driveStick.getRawButton(3)) {
      Shooter.feed(1.0);
    } else if(OI.driveStick.getRawButton(5)) {
      Shooter.feed(-1.0);
    } else {
      Shooter.feed(0);
    }

    //if(OI.reverseFeeder.get()) {
    

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
