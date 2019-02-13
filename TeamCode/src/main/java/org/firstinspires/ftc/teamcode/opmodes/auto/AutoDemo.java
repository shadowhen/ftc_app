package org.firstinspires.ftc.teamcode.opmodes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.robot.MineralPosition;

/**
 * This class is autonomous demonstration program for demoing the robot in front of people
 * who are interested in the team's robot's autonomous capabilities.
 * @author Henry
 * @version 1.0
 */
@Autonomous(name = "Autonomous Demonstration",  group = "demo")
public class AutoDemo extends AutoOpMode {

    private MineralPosition mineralPosition;

    @Override
    public void runOpMode() throws InterruptedException {
        super.runOpMode();

        // Initializes vuforia and tensorflow object detection
        initDetector(true);

        // Activate the detector to detect minerals
        if (detector.getDetector() != null) {
            detector.getDetector().activate();
        }

        while (!isStopRequested() && opModeIsActive()) {
            telemetry.addData("status", "waiting...");
            telemetry.update();
        }

        // Scans for the gold mineral (no landing this time)
        // Landing would require a lander's latch which the team cannot carry a big lander
        mineralPosition = detectGoldFromTwoMinerals(5);

        switch (mineralPosition) {
            case LEFT:
                robot.moveSidewaysByEncoder(DRIVE_SPEED, -400, 5);
                robot.moveByEncoder(DRIVE_SPEED, 300, 300, 5);
                break;
            case RIGHT:
                robot.moveSidewaysByEncoder(DRIVE_SPEED, 400, 5);
                robot.moveByEncoder(DRIVE_SPEED, 300, 300, 5);
                break;
            default:
                robot.moveSidewaysByEncoder(DRIVE_SPEED, 600, 5);
                robot.moveByEncoder(DRIVE_SPEED, 300, 300, 5);
        }
        sleep(500);

        // Drop the team marker
        setSweeperLiftPower(SWEEPER_DEPLOY_SPEED, 500);
        sleep(500);
        setSweeperLiftPower(SWEEPER_RETRACT_SPEED, 750);
    }
}
