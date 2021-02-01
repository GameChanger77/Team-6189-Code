package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class DriverControlled extends OpMode {
    Robot robot = new Robot();
    double strafe, forward, turn, power;

    @Override
    public void init() {
        robot.init(hardwareMap);
    }

    @Override
    public void loop() {
        if(gamepad1.right_trigger > .25)
            power = gamepad1.right_trigger;
        else
            power = .25;
        strafe = gamepad1.left_stick_x * power;
        forward = gamepad1.left_stick_y * power;
        turn = gamepad1.right_stick_x * power;

        robot.move(strafe, forward, turn);
    }
}
