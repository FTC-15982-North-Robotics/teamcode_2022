package org.firstinspires.ftc.teamcode.subsystem

public class Drive {
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;

    public Drive(HardwareMap hardwareMap) {
        frontLeft = hardwareMap.get(DcMotor.class, "front_left");
        frontRight = hardwareMap.get(DcMotor.class, "front_right");
        backLeft = hardwareMap.get(DcMotor.class, "back_left");
        backRight = hardwareMap.get(DcMotor.class, "back_right");

        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.FORWARD);
    }

    public void strafeLeftRaw(double power) {
        frontRight.setPower(power);
        backRight.setPower(power*-1);
        frontLeft.setPower(power*-1);
        backLeft.setPower(power);
    }

    public void strafeRightRaw(double power) {
        frontRight.setPower(power*-1);
        backRight.setPower(power);
        frontLeft.setPower(power);
        backLeft.setPower(power*-1);
    }

    public void backwardRaw(double power) {
        frontRight.setPower(power*-1);
        backRight.setPower(power*-1);
        frontLeft.setPower(power*-1);
        backLeft.setPower(power*-1);
    }

    public void forwardRaw(double power) {
        frontRight.setPower(power);
        backRight.setPower(power);
        frontLeft.setPower(power);
        backLeft.setPower(power);
    }

    public void spinLeftRaw(double power) {
        frontRight.setPower(power*-1);
        backRight.setPower(power*-1);
        frontLeft.setPower(power);
        backLeft.setPower(power);
    }

    public void spinRightRaw(double power) {
        frontRight.setPower(power);
        backRight.setPower(power);
        frontLeft.setPower(power*-1);
        backLeft.setPower(power*-1);
    }

    public void forwardRaw() {
        forward(1);
    }

    public void strafeLeftRaw() {
        strafeLeft(1);
    }

    public void strafeRightRaw() {
        strafeRight(1);
    }

    public void backwardRaw() {
        backward(1);
    }

    public void spinLeftRaw() {
        spinLeft(1);
    }

    public void spinRightRaw() {
        spinRight(1);
    }

    //encoder stuffs
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

    public void forward(double power, int ticks) {
        stop_and_reset_encoders();
        frontLeft.setTargetPosition(ticks);
        frontRight.setTargetPosition(ticks);
        backLeft.setTargetPosition(ticks);
        backRight.setTargetPosition(ticks);
        run_to_position();
        while (frontLeft.isBusy()) {
            forwardRaw(power);
        }
    }

    public void backward(double power, int ticks) {
        ticks = (ticks*-1);
        stop_and_reset_encoders();
        frontLeft.setTargetPosition(ticks);
        frontRight.setTargetPosition(ticks);
        backLeft.setTargetPosition(ticks);
        backRight.setTargetPosition(ticks);
        run_to_position();
        while (frontLeft.isBusy()) {
            backwardRaw(power);
        }
    }

    public void strafeRight(double power, int ticks) {
        stop_and_reset_encoders();
        frontLeft.setTargetPosition(ticks);
        frontRight.setTargetPosition(ticks*-1);
        backLeft.setTargetPosition(ticks*-1);
        backRight.setTargetPosition(ticks);
        run_to_position();
        while (frontLeft.isBusy()) {
            strafeRightRaw(power);
        }
    }

    public void strafeLeft(double power, int ticks) {
        stop_and_reset_encoders();
        frontLeft.setTargetPosition(ticks*-1);
        frontRight.setTargetPosition(ticks);
        backLeft.setTargetPosition(ticks);
        backRight.setTargetPosition(ticks*-1);
        run_to_position();
        while (frontLeft.isBusy()) {
            strafeLeftRaw(power);
        }
    }

    public void spinLeft(double power, int ticks) {
        stop_and_reset_encoders();
        frontLeft.setTargetPosition(ticks);
        frontRight.setTargetPosition(ticks*-1);
        backLeft.setTargetPosition(ticks);
        backRight.setTargetPosition(ticks*-1);
        run_to_position();
        while (frontLeft.isBusy()) {
            spinLeftRaw(power);
        }
    }

    public void spinRight(double power, int ticks) {
        stop_and_reset_encoders();
        frontLeft.setTargetPosition(ticks*-1);
        frontRight.setTargetPosition(ticks);
        backLeft.setTargetPosition(ticks*-1);
        backRight.setTargetPosition(ticks);
        run_to_position();
        while (frontLeft.isBusy()) {
            spinRightRaw(power);
        }
    }
}