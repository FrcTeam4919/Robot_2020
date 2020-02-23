package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.*;

public class GearShifterLow extends Command {
    public GearShifterLow() {

    }
    
    public void initialize() {
        System.out.println("Shifting into low speed");
        GearShifter.lowSpeed();
    }
    protected boolean isFinished() {
        return false;
    }
}