package org.firstinspires.ftc.teamcode.susannah;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous
public class susie_II extends LinearOpMode {
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;
    private DcMotor grabber;
    private DcMotor cascade;
    private DcMotor susan;

    @Override
    public void runOpMode() {
        frontLeft = hardwareMap.get(DcMotor.class, "leftFront");
        frontRight = hardwareMap.get(DcMotor.class, "rightFront");
        backLeft = hardwareMap.get(DcMotor.class, "leftRear");
        backRight = hardwareMap.get(DcMotor.class, "rightRear");

        grabber = hardwareMap.get(DcMotor.class, "Grabber");
        cascade = hardwareMap.get(DcMotor.class, "Cascade");
        susan = hardwareMap.get(DcMotor.class, "Susan");

        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);

        telemetry.addData("Initialized", "Ready to start");
        waitForStart();

        grabber.setPower(0.2);
        forwardEncoders(0.5, 1100);
        spinRightEncoders(0.5, 1000);
        cascade.setPower(1);
        sleep(1250);
        cascade.setPower(0.15);
        forwardEncoders(0.5, 300);
        strafeRightEncoders(0.5, 1000);
        grabber.setPower(-1);
        sleep(100);
        grabber.setPower(0);
    }




    //functions

    public void strafeLeft(double power) {
        frontRight.setPower(power);
        backRight.setPower(power*-1);
        frontLeft.setPower(power*-1);
        backLeft.setPower(power);
    }

    public void strafeRight(double power) {
        frontRight.setPower(power*-1);
        backRight.setPower(power);
        frontLeft.setPower(power);
        backLeft.setPower(power*-1);
    }

    public void backward(double power) {
        frontRight.setPower(power*-1);
        backRight.setPower(power*-1);
        frontLeft.setPower(power*-1);
        backLeft.setPower(power*-1);
    }

    public void forward(double power) {
        frontRight.setPower(power);
        backRight.setPower(power);
        frontLeft.setPower(power);
        backLeft.setPower(power);
    }

    public void spinLeft(double power) {
        frontRight.setPower(power*-1);
        backRight.setPower(power*-1);
        frontLeft.setPower(power);
        backLeft.setPower(power);
    }

    public void spinRight(double power) {
        frontRight.setPower(power);
        backRight.setPower(power);
        frontLeft.setPower(power*-1);
        backLeft.setPower(power*-1);
    }

    public void forward() {
        forward(1);
    }

    public void strafeLeft() {
        strafeLeft(1);
    }

    public void strafeRight() {
        strafeRight(1);
    }

    public void backward() {
        backward(1);
    }

    public void spinLeft() {
        spinLeft(1);
    }

    public void spinRight() {
        spinRight(1);
    }

    public void Run_with_encoder() {
        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void run_using_encoder() {
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void run_to_position() {
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void stop_and_reset_encoders() {
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void forwardEncoders(double power, int ticks) {
        stop_and_reset_encoders();
        frontLeft.setTargetPosition(ticks);
        frontRight.setTargetPosition(ticks);
        backLeft.setTargetPosition(ticks);
        backRight.setTargetPosition(ticks);
        run_to_position();
        while (frontLeft.isBusy()) {
            forward(power);
        }
    }

    public void backwardEncoders(double power, int ticks) {
        ticks = (ticks*-1);
        stop_and_reset_encoders();
        frontLeft.setTargetPosition(ticks);
        frontRight.setTargetPosition(ticks);
        backLeft.setTargetPosition(ticks);
        backRight.setTargetPosition(ticks);
        run_to_position();
        while (frontLeft.isBusy()) {
            backward(power);
        }
    }

    public void strafeRightEncoders(double power, int ticks) {
        stop_and_reset_encoders();
        frontLeft.setTargetPosition(ticks);
        frontRight.setTargetPosition(ticks*-1);
        backLeft.setTargetPosition(ticks*-1);
        backRight.setTargetPosition(ticks);
        run_to_position();
        while (frontLeft.isBusy()) {
            strafeRight(power);
        }
    }

    public void strafeLeftEncoders(double power, int ticks) {
        stop_and_reset_encoders();
        frontLeft.setTargetPosition(ticks*-1);
        frontRight.setTargetPosition(ticks);
        backLeft.setTargetPosition(ticks);
        backRight.setTargetPosition(ticks*-1);
        run_to_position();
        while (frontLeft.isBusy()) {
            strafeLeft(power);
        }
    }

    public void spinLeftEncoders(double power, int ticks) {
        stop_and_reset_encoders();
        frontLeft.setTargetPosition(ticks);
        frontRight.setTargetPosition(ticks*-1);
        backLeft.setTargetPosition(ticks);
        backRight.setTargetPosition(ticks*-1);
        run_to_position();
        while (frontLeft.isBusy()) {
            spinLeft(power);
        }
    }

    public void spinRightEncoders(double power, int ticks){
        stop_and_reset_encoders();
        frontLeft.setTargetPosition(ticks * -1);
        frontRight.setTargetPosition(ticks);
        backLeft.setTargetPosition(ticks * -1);
        backRight.setTargetPosition(ticks);
        run_to_position();
        while (frontLeft.isBusy()) {
            spinRight(power);
        }
    }
}

