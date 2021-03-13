package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.TimedCommand;

public class TimedDriveForward extends TimedCommand {
    public TimedDriveForward(double timeout) {
        super(timeout);
        requires(Robot.drivetrain);
    }
    @Override
    protected void initialize() {
        System.out.println("Moving forward");
    }
    @Override
    protected void execute() {
        Robot.drivetrain.moveForward();
    }
    @Override
    protected void end() {
        System.out.println("Moved forward");
    }
    @Override
    protected void interrupted() {
        
    }
}