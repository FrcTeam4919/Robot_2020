package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.TimedCommand;

public class AutoTurn extends TimedCommand {
    public AutoTurn(double timeout) {
        super(timeout);
        requires(Robot.drivetrain);
    }
    @Override 
    public void initialize() {
        System.out.println("Turning");
    }
    @Override
    public void execute() {
        Robot.drivetrain.turn();
    }
    @Override
    public void end() {
        System.out.println("Turned");
    }
}