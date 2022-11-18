package org.firstinspires.ftc.teamcode.susannah;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class bob extends LinearOpMode {
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


        frontLeft.setDirection(DcMotor.Direction.FORWARD);
        backLeft.setDirection(DcMotor.Direction.FORWARD);
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Initialized", "Ready to start");
        waitForStart();

        while (opModeIsActive()) {
/*
  Drivetrain Options
 */
//                        double speed;
//                        speed = 1;
//                        backLeft.setPower(((1 * gamepad1.left_stick_y + gamepad1.left_stick_x) - gamepad1.right_stick_x) * speed);
//                        backRight.setPower(((-1 * gamepad1.left_stick_y + gamepad1.left_stick_x) - gamepad1.right_stick_x) * speed);
//                        frontLeft.setPower(((1 * gamepad1.left_stick_y - gamepad1.left_stick_x) - gamepad1.right_stick_x) * speed);
//                        frontRight.setPower(((-1 * gamepad1.left_stick_y - gamepad1.left_stick_x) - gamepad1.right_stick_x) * speed);

                        double speed = -gamepad1.left_stick_y;
                        double turn = -gamepad1.right_stick_x;
                        double strafe = gamepad1.left_stick_x;
                        frontLeft.setPower(speed + turn - strafe);
                        frontRight.setPower(speed - turn - strafe);
                        backLeft.setPower(speed + turn + strafe);
                        backRight.setPower(speed - turn + strafe);


                        //Grabber Control
                        if (gamepad1.x) {
                            grabber.setPower(1);
                            sleep(100);
                            grabber.setPower(0);
                        } else if (gamepad1.y) {
                            grabber.setPower(-1);
                            sleep(100);
                            grabber.setPower(0);
                        }

                        //Cascade control
                        if (gamepad1.right_trigger > 0.01) {
                                cascade.setPower(gamepad1.right_trigger);
                        } else if (gamepad1.left_trigger > 0.01) {
                                cascade.setPower(gamepad1.left_trigger / -3);
                        } else {
                                cascade.setPower(0.2);
                        }

                        //susan control
                        if (gamepad1.dpad_up) {
                            susan.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//                            int haha = susan.getCurrentPosition();
//                            telemetry.addData("ha", haha);
//                            int hahaha = haha + 15;
                            susan.setTargetPosition(30);
                            susan.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                            while (susan.isBusy()) {
                                susan.setPower(1);
                            }
                            susan.setPower(0);
                        }

                        if (gamepad1.dpad_down) {
                            susan.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//                            int haha = susan.getCurrentPosition();
//                            telemetry.addData("ha", haha);
//                            int hahaha = haha - 10;
                            susan.setTargetPosition(231);
                            susan.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                            while (susan.isBusy()) {
                                susan.setPower(1);
                            }
                            susan.setPower(0);
                        }


//            double x = gamepad1.left_stick_x;
//            double y = gamepad1.left_stick_y*-1;
//            double turn = gamepad1.right_stick_x;
//            double theta = Math.atan2(y, x);
//            double power = Math.hypot(x, y);
//            double sin = Math.sin(theta - Math.PI/4);
//            double cos = Math.cos(theta - Math.PI/4);
//            double max = Math.max(Math.abs(sin), Math.abs(cos));
//            frontLeft.setPower(power * cos/max + turn);
//            frontRight.setPower(power * sin/max - turn);
//            backLeft.setPower(power * sin/max + turn);
//            backRight.setPower(power * cos/max - turn);
//            if ((power + Math.abs(turn)) > 1) {
//                frontLeft.setPower((frontLeft.getPower()) / power + turn);
//                frontRight.setPower((frontRight.getPower()) / power + turn);
//                backLeft.setPower((backLeft.getPower()) / power + turn);
//                backRight.setPower((backRight.getPower()) / power + turn);
//            }
/*
  Arm Cascade Options
  */
//                        if (gamepad1.right_trigger > 0.01) {
//                                cascade.setPower(gamepad1.right_trigger);
//                        } else if (gamepad1.left_trigger > 0.01) {
//                                cascade.setPower(gamepad1.left_trigger / -3);
//                        } else {
//                                cascade.setPower(0);
//                        }
//
//                        if (gamepad1.right_trigger > 0.01) {
//                                cascade.setPower(gamepad1.right_trigger);
//                        } else if (gamepad1.left_trigger > 0.01) {
//                                cascade.setPower(gamepad1.left_trigger / -3);
//                        } else {
//                                cascade.setPower(0.1);
//                        }
//
//                        Something having to do with encoders...
/*
  Intake
  */
//                        if (gamepad1.left_bumper) {
//                                intake.setPower(1);
//                        } else if (gamepad1.right_bumper) {
//                                intake.setPower(-1);
//                        } else {
//                                intake.setPower(0);
//                        }


            telemetry.update();
        }
    }

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

    public void spinRightEncoders(double power, int ticks) {
        stop_and_reset_encoders();
        frontLeft.setTargetPosition(ticks*-1);
        frontRight.setTargetPosition(ticks);
        backLeft.setTargetPosition(ticks*-1);
        backRight.setTargetPosition(ticks);
        run_to_position();
        while (frontLeft.isBusy()) {
            spinRight(power);
        }
    }
}
