package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name= "SixwheelTwohexmotor", group = "Linear OpMode")

public class SixwheelTwohexmotor extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor Left;
    private DcMotor Right;


    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        //HW Map DC Motors
        Left = hardwareMap.dcMotor.get("Left");
        Right = hardwareMap.dcMotor.get("Right");

        Left.setDirection(DcMotorSimple.Direction.REVERSE);


        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {

            if (gamepad1.left_stick_x != 0 || gamepad1.left_stick_y != 0) /*If the left stick is not neutral...*/ {
                double drive = -gamepad1.left_stick_y; //Set the Drive to the negative value of the y-axis value
                double turn = gamepad1.left_stick_x; //Set the turn to the value of the x-axis value

                double leftPower;
                double rightPower;
                leftPower = Range.clip(drive + turn, -1.0, 1.0); //fun math
                rightPower = Range.clip(drive - turn, -1.0, 1.0); //fun math 2

                Left.setPower(leftPower * 1.5);
                Right.setPower(rightPower * 1.5);
            }
            if (gamepad1.left_stick_x == 0 || gamepad1.left_stick_y == 0){

                Left.setPower(0);
                Right.setPower(0);
            }

        }


    }

}
