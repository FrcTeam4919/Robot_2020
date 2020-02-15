package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousStage extends CommandGroup{
    public AutonomousStage(){
        addSequential(new TimedDrivetrain(3));
        addParallel(new AutoConveyor(3));
        addSequential(new AutoShooter(3));
    }
}