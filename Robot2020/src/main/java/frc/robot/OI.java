// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package frc.robot;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public Joystick joystick0;
    public static Joystick joystick1;
    public JoystickButton winchRetract;
    public JoystickButton winchUnwind;
    public JoystickButton towerExtend;
    public JoystickButton towerRetract;
    public JoystickButton colorSpinnerDeploy;
    public JoystickButton clockwiseSpinner;
    public JoystickButton counterClockwiseSpinner;
    public JoystickButton shoot;
    public JoystickButton conveyorMove;
    public JoystickButton deployBallCatcher;
    public JoystickButton ballCatcherAbsorb;
    public JoystickButton lockBallCatcher;
    public JoystickButton shiftForward;
    public JoystickButton shiftBackward;
    public JoystickButton shiftRight;
    public JoystickButton shiftLeft;


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        joystick0 = new Joystick(0);
        joystick1 = new Joystick(1);

        winchRetract = new JoystickButton(joystick0, 12);
        winchRetract.whileHeld(new WinchCommandRetract());
        winchRetract.whenReleased(new WinchCommandRetract().Stop());

        winchUnwind = new JoystickButton(joystick0, 16);
        winchUnwind.whileHeld(new WinchCommandUnwind());
        winchUnwind.whenReleased(new WinchCommandUnwind().Stop());

        towerExtend = new JoystickButton(joystick0, 14);
        towerExtend.whileHeld(new TowerCommandExtend());
        towerExtend.whenReleased(new TowerCommandExtend().Stop());

        towerRetract = new JoystickButton(joystick0, 3);
        towerRetract.whileHeld(new TowerCommandRetract());
        towerRetract.whenReleased(new TowerCommandRetract().Stop());

        clockwiseSpinner = new JoystickButton(joystick1, 4);
        clockwiseSpinner.whileHeld(new ColorWheelSpinnerClockwise());
        clockwiseSpinner.whenReleased(new ColorWheelSpinnerClockwise().Stop());

        counterClockwiseSpinner = new JoystickButton(joystick1, 3);
        counterClockwiseSpinner.whileHeld(new ColorWheelSpinnerCounterClockwise());
        counterClockwiseSpinner.whenReleased(new ColorWheelSpinnerCounterClockwise().Stop());

        shoot = new JoystickButton(joystick0, 2);
        shoot.whileHeld(new ShooterCommand());
        shoot.whenReleased(new ShooterCommand().Stop());

        conveyorMove = new JoystickButton(joystick0, 4);
        conveyorMove.whileHeld(new ConveyorBeltCommand());
        conveyorMove.whenReleased(new ConveyorBeltCommand().Stop());

        deployBallCatcher = new JoystickButton(joystick1, 1);
        deployBallCatcher.whileHeld(new DeployBallCatcher());
        deployBallCatcher.whenReleased(new DeployBallCatcher().Stop);

        ballCatcherAbsorb = new JoystickButton(joystick0, 1);
        ballCatcherAbsorb.whileHeld(new BallCatcherCommand());
        ballCatcherAbsorb.whenReleased(new BallCatcherCommand().Stop());

        lockBallCatcher = new JoystickButton(joystick1, 2);
        lockBallCatcher.whileHeld(new LockBallCatcher());
        lockBallCatcher.whenReleased(new LockBallCatcher().Stop());

        shiftForward = new JoystickButton(joystick0, 8);
        shiftForward.whileHeld(new ShiftForward());
        shiftForward.whenReleased(new ShiftForward().Stop());

        shiftBackward = new JoystickButton(joystick0, 15);
        shiftBackward.whileHeld(new ShiftBackward());
        shiftBackward.whenReleased(new ShiftBackward().Stop());

        shiftRight = new JoystickButton(joystick0, 6);
        shiftRight.whileHeld(new ShiftRight());
        shiftRight.whenReleased(new ShiftRight().Stop());

        shiftLeft = new JoystickButton(joystick0, 7);
        shiftLeft.whileHeld(new ShiftLeft());
        shiftLeft.whenReleased(new ShiftLeft().Stop());
        







        // SmartDashboard Buttons
        SmartDashboard.putData("AutonomousCommand", new AutonomousCommand());
        SmartDashboard.putData("WinchCommandRetract", new WinchCommandRetract());
        SmartDashboard.putData("WinchCommandUnwind", new WinchCommandUnwind());
        SmartDashboard.putData("TowerCommandExtend", new TowerCommandExtend());
        SmartDashboard.putData("TowerCommandRetract", new TowerCommandRetract());
        SmartDashboard.putData("ShooterCommand", new ShooterCommand());
        SmartDashboard.putData("BallCatcherCommand", new BallCatcherCommand());
        SmartDashboard.putData("DeployBallCatcher", new DeployBallCatcher());
        SmartDashboard.putData("ConveyorBeltCommand", new ConveyorBeltCommand());
        SmartDashboard.putData("ColorWheelSpinnerClockwise", new ColorWheelSpinnerClockwise());
        SmartDashboard.putData("ColorWheelSpinnerCounterClockwise", new ColorWheelSpinnerCounterClockwise());
        SmartDashboard.putData("SpinnerDeploy", new SpinnerDeploy());
        SmartDashboard.putData("SpinnerRetract", new SpinnerRetract());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getJoystick0() {
        return joystick0;
    }

    public Joystick getJoystick1() {
        return joystick1;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

