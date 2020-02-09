// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package frc.robot.subsystems;


import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.OI;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Drivetrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private VictorSP leftMotor;
private VictorSP rightMotor;
public static DifferentialDrive westCoastTankDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public Drivetrain() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    leftMotor = new VictorSP(0);
    addChild("LeftMotor",leftMotor);
    leftMotor.setInverted(false);
        
    rightMotor = new VictorSP(1);
    addChild("RightMotor",rightMotor);
    rightMotor.setInverted(false);
        
    westCoastTankDrive = new DifferentialDrive(leftMotor, rightMotor);
    addChild("WestCoastTankDrive",westCoastTankDrive);
    westCoastTankDrive.setSafetyEnabled(true);
    westCoastTankDrive.setExpiration(0.1);
    westCoastTankDrive.setMaxOutput(1.0);

        

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
        double y = OI.joystick1.getY();
        double x = OI.joystick1.getX();
        double z = OI.joystick1.getZ();
        y = correctErrors(y);
        x = correctErrors(x);
        z  = correctErrors(z);
        westCoastTankDrive.arcadeDrive(x, -y);

    }
    public double correctErrors(double value) {
        if (Math.abs(value) < 0.2) {
            value = 0;
        }
        return value;
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

