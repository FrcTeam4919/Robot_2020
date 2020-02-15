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

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.*;
import edu.wpi.first.hal.FRCNetComm.tInstances;
import edu.wpi.first.hal.FRCNetComm.tResourceType;
import edu.wpi.first.hal.HAL;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.analog.adis16448.frc.ADIS16448_IMU;
import com.revrobotics.ColorMatch;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in 
 * the project.
 */
public class Robot extends TimedRobot {

    Command autonomousCommand;
    SendableChooser<Command> chooser = new SendableChooser<>();

    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    Thread m_visionThread;
    public static Drivetrain drivetrain;
    public static WinchMotor winchMotor;
    public static TowerMotor towerMotor;
    public static BallCatcher ballCatcher;
    public static ConveyorBelt conveyorBelt;
    public static Spinner spinner;
    public static Shooter shooter;
    private final I2C.Port i2cPort = I2C.Port.kOnboard;
    private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
    private final ColorMatch m_colorMatcher = new ColorMatch();
    private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
    private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.540, 0.250);
    private final Color kRedTarget = ColorMatch.makeColor(0.450, 0.380, 0.170);
    private final Color kYellowTarget = ColorMatch.makeColor(0.320, 0.525, 0.150);
    public static final ADIS16448_IMU imu = new ADIS16448_IMU();
    CameraServer server;
    //public static edu.wpi.first.cameraserver.CameraServer camera;


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
        m_visionThread = new Thread(() -> {
            UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();

            camera.setResolution(640, 480);
            // Gets a CvSink. This will capture Mats from the camera
            CvSink cvSink = CameraServer.getInstance().getVideo();
            // Sets up a CvSource. This will send images back to the Dashboard
            CvSource outputStream = CameraServer.getInstance().putVideo("Rectangle", 640, 480);

            // Mats are system intensive. It is best to reuse just one throughout code
            Mat mat = new Mat();

            // Interrupted can never be 'true'. The program will run an infinite loop
            // and never exit if it is. This will allow the robot to stop the
            // thread when restarting the code or deploying
            while(!Thread.interrupted()) {
                // tells the CvSink to grab a frame from the camera and put it into
                // the source mat. If there is an error notify the output.
                if (cvSink.grabFrame(mat) == 0) {
                    // sends output to the error
                    outputStream.notifyError(cvSink.getError());
                    // skips the rest of the current iteration
                    continue;
                }
            }
            // Puts a rectangle on the image
            Imgproc.rectangle(mat, new Point(100, 100), new Point(400, 400), new Scalar(255, 255, 255), 5);
            // Gives the output stream a new image to display
            outputStream.putFrame(mat);
         }
        );
        m_visionThread.setDaemon(true);
        m_visionThread.start();
        m_colorMatcher.addColorMatch(kBlueTarget);
        m_colorMatcher.addColorMatch(kGreenTarget);
        m_colorMatcher.addColorMatch(kRedTarget);
        m_colorMatcher.addColorMatch(kYellowTarget);
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        drivetrain = new Drivetrain();
        winchMotor = new WinchMotor();
        towerMotor = new TowerMotor();
        ballCatcher = new BallCatcher();
        conveyorBelt = new ConveyorBelt();
        spinner = new Spinner();
        shooter = new Shooter();
        //server = CameraServer.getInstance();
        //UsbCamera camera = server.startAutomaticCapture();
        //camera.setResolution(640, 480);



        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();

        HAL.report(tResourceType.kResourceType_Framework, tInstances.kFramework_RobotBuilder);

        // Add commands to Autonomous Sendable Chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        chooser.setDefaultOption("Autonomous Command", new AutonomousCommand());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        SmartDashboard.putData("Auto mode", chooser);
    }
    @Override
    public void robotPeriodic() {
        m_colorMatcher.setConfidenceThreshold(0.95);
        Color detectedColor = m_colorSensor.getColor();
        String colorString;
        ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);
        if (match.color == kBlueTarget) {
            colorString = "Blue";
        } else if (match.color == kRedTarget) {
            colorString = "Red";
        } else if (match.color == kYellowTarget) {
            colorString = "Yellow";
        } else if (match.color == kGreenTarget) {
            colorString = "Green";
        } else {
            colorString = "Unknown";
        }
        SmartDashboard.putNumber("Red", detectedColor.red);
        SmartDashboard.putNumber("Green", detectedColor.green);
        SmartDashboard.putNumber("Blue", detectedColor.blue);
        SmartDashboard.putNumber("Confidence", match.confidence);
        SmartDashboard.putString("Detected Color", colorString);
        double IR = m_colorSensor.getIR();
        SmartDashboard.putNumber("IR", IR);
        int proximity = m_colorSensor.getProximity();
        SmartDashboard.putNumber("Proximity", proximity);
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    @Override
    public void disabledInit(){

    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
        autonomousCommand = chooser.getSelected();
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {

        
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
}
