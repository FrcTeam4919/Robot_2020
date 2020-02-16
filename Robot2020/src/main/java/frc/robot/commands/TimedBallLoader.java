package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.TimedCommand;

public class TimedBallLoader extends TimedCommand {
    public TimedBallLoader(double timeout) {
        super(timeout);
    }
    @Override
    public void initialize() {
        System.out.println("Loading magazine");
    }
    @Override 
    public void execute() {
        
    }
    @Override
    public void end() {
        System.out.println("Magazine loaded");
    }
}