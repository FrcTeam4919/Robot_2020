package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.*;

public class GearShifterHigh extends Command {
    public GearShifterHigh () {

    }

    public void initialize() {
        System.out.println("Shifting into high speed");
        GearShifter.highSpeed();
    }

    protected boolean isFinished() {
        return false;
    }
}