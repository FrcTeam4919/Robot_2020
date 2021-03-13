package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.command.TimedCommand;

public class AutoShooter extends TimedCommand {
    public AutoShooter(double timeout){
        super(timeout);
        requires(Robot.shooter);
    }
    @Override
    protected void initialize() {
        System.out.println("Shooting");
    }
    @Override
    protected void execute() {
        Shooter.theViolenceHasEscalated();
    }
    @Override
    protected void end() {
        Shooter.theViolenceHasDeEscalated();
        System.out.println("The Shooting is over");
    }
    @Override
    protected void interrupted() {

    }
}