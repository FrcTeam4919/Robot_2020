package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.command.TimedCommand;

public class AutoConveyor extends TimedCommand {
    public AutoConveyor(double timeout) {
        super(timeout);
        requires(Robot.conveyorBelt);
    }
    @Override
    protected void initialize() {
        System.out.println("Conveying");
    }
    @Override
    protected void execute() {
        ConveyorBelt.convey();
    }
    @Override
    protected void end() {
        ConveyorBelt.Cease();
        System.out.println("Conveyed");
    }
    @Override
    protected void interrupted() {

    }
}