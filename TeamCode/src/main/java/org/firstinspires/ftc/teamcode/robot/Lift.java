package org.firstinspires.ftc.teamcode.robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * This class implements the robotic function known as the lift.
 * @author Henry
 * @version 1.1
 */
public class Lift {

    private static final double GEAR_DIAMETER_MM = 3.0;
    private static final double COUNTS_PER_REV = 1440;
    private static final double COUNTS_PER_MM = (COUNTS_PER_REV / (GEAR_DIAMETER_MM * Math.PI));

    private DcMotor liftMotor;

    /**
     * Initializes the hardware
     * @param hwMap Hardware Map
     */
    public void init(HardwareMap hwMap) {
        liftMotor = hwMap.get(DcMotor.class, HardwareName.MOTOR_VERTICAL_LIFT);

        liftMotor.setPower(0.0);
    }

    /**
     * Set the power of the lift motor
     * @param power Power
     */
    public void setLiftPower(double power) {
        liftMotor.setPower(power);
    }

    public DcMotor getLiftMotor() {
        return liftMotor;
    }

    /**
     * Returns the power of the lift motor
     * @return Lift Motor Power
     */
    public double getLiftPower() {
        return liftMotor.getPower();
    }
}
