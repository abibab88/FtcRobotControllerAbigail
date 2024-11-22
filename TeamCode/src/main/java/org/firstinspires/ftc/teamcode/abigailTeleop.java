package org.firstinspires.ftc.teamcode;// Import required classes for LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp(name = "jelly")
public class abigailTeleop extends LinearOpMode {
    // Declare objects here
protected DcMotorEx MotorFL;
protected DcMotorEx MotorFR;
protected DcMotorEx MotorBL;
protected DcMotorEx MotorBR;

    // The mn runOpMode method - called when the INIT button is pressed.
    public void runOpMode() throws InterruptedException {
        // Initialization code goes here
MotorFL = hardwareMap.get(DcMotorEx.class, "motor1");
MotorFR = hardwareMap.get(DcMotorEx.class, "motor2");
MotorBL = hardwareMap.get(DcMotorEx.class, "motor3");
MotorBR = hardwareMap.get(DcMotorEx.class, "motor4");


        // Wait for the start button to be pressed.
        waitForStart();


        // Main loop - This loop runs repeatedly after the START button is pressed
        while(opModeIsActive()) {
            // Code to control the robot goes here
            // Mecanum wheel omnidirectional movement control
           double speed = -gamepad1.left_stick_y;
           double rotate = gamepad1.right_stick_x;
           double strafe = gamepad1.left_stick_x * 1.1;

           double denominator = Math.max(Math.abs(speed) + Math.abs(strafe) + Math.abs(rotate), 1);
           double frontLeftPower = (speed + strafe + rotate) / denominator;
           double frontRightPower = (speed - strafe - rotate) / denominator;
           double backLeftPower = (speed - strafe + rotate) / denominator;
           double backRightPower = (speed + strafe - rotate) / denominator;

            // calculating motor powers for omnidirectional movement
           MotorFL.setPower(frontLeftPower);
           MotorFR.setPower(frontRightPower);
           MotorBL.setPower(backLeftPower);
           MotorBR.setPower(backRightPower);







        }
    }
}