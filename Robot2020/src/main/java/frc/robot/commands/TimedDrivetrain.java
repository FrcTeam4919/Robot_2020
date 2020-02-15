package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.TimedCommand;

public class TimedDrivetrain extends TimedCommand {
    public TimedDrivetrain(double timeout) {
        super(timeout);

        requires(Robot.drivetrain);

    }

    @Override
    protected void initialize() {
        System.out.println("Moving backward");
    }
    @Override
    protected void execute() {
        Robot.drivetrain.moveBackward();
    }
    @Override
    protected void end() {
        System.out.println("Moved backward");
    }
    @Override
    protected void interrupted() {

    }
}