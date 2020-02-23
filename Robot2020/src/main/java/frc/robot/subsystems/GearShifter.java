package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearShifter extends Subsystem {

    private static DoubleSolenoid gearShifter;

    public GearShifter() {
        gearShifter = new DoubleSolenoid(0, 0, 1);
        addChild("Gear Shifter", gearShifter);

    }
    protected void initDefaultCommand() {

    }
    public static void highSpeed() {
        gearShifter.set(DoubleSolenoid.Value.kReverse);
    }
    public static void lowSpeed() {
        gearShifter.set(DoubleSolenoid.Value.kForward);
    }

}