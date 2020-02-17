package frc.robot.commands;

import edu.wpi.first.wpilibj.command.*;

public class AutonomousStage extends CommandGroup{
    public AutonomousStage(){
        addSequential(new TimedDrivetrain(3));
        addSequential(new AutoTurn(2));
        addParallel(new Command(3));
        addParallel(new TimedBallLoader(3));
        addParallel(new AutoShooter(3));
    }
}