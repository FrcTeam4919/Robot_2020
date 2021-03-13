package frc.robot.commands;

import edu.wpi.first.wpilibj.command.*;

public class AutonomousStage extends CommandGroup{
    public AutonomousStage(){
        addSequential(new TimedDrivetrain(3));
       // addSequential(new AutoTurn(3));
       // addSequential(new AutoConveyor(3));
       // addSequential(new TimedBallLoader(3));
       // addSequential(new AutoShooter(3));
    }
}