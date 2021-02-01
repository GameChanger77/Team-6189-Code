package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.GyroEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robot {
    public Motor motor1,motor2,motor3,motor4;
    public MecanumDrive mecanum = new MecanumDrive(motor1, motor2, motor3, motor4);
    public GyroEx imu;

    public void move(double strafe, double forward, double turn){
        mecanum.driveFieldCentric(strafe, forward, turn, imu.getHeading());
    }

    public void init(HardwareMap hm){
        initMotors(hm);
        imu.init();
    }

    private void initMotors(HardwareMap hm){
        motor1 = new Motor(hm, "motor1", Motor.GoBILDA.RPM_312);
        motor2 = new Motor(hm, "motor2", Motor.GoBILDA.RPM_312);
        motor3 = new Motor(hm, "motor3", Motor.GoBILDA.RPM_312);
        motor4 = new Motor(hm, "motor4", Motor.GoBILDA.RPM_312);

        motor2.setInverted(true);
        motor4.setInverted(true);

        motor1.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        motor2.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        motor3.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        motor4.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
    }


}
