package org.firstinspires.ftc.teamcode;

public class StateMachines {
    private teleop teleOp;

    public enum LaunchState {
        IDLE,
        LAUNCHING,
        WAITING_FOR_RELOAD
    }

    public enum LoadState {
        IDLE,
        LOADING,
        WAITING_FOR_LAUNCH
    }

    public enum DriveState {
        IDLE,
        MANUAL,
        AUTO_AIM
    }

    public enum AimState {
        IDLE,
        AIMING_MANUAL,
        AIMING_AUTO
    }

    public LaunchState launchState = LaunchState.IDLE;
    public LoadState loadState = LoadState.IDLE;
    public DriveState driveState = DriveState.IDLE;
    public AimState aimState = AimState.IDLE;

    public StateMachines(teleop teleOp) {
        this.teleOp = teleOp;
    }

    public void run() {
        // Launch State Machine
        switch (launchState) {
            case IDLE:
                if (teleOp.gamepad1.a) {
                    launchState = LaunchState.LAUNCHING;
                }
                break;
            case LAUNCHING:
                // TODO: Add launch logic
                launchState = LaunchState.WAITING_FOR_RELOAD;
                break;
            case WAITING_FOR_RELOAD:
                if (loadState == LoadState.IDLE) {
                    launchState = LaunchState.IDLE;
                }
                break;
        }

        // Load State Machine
        switch (loadState) {
            case IDLE:
                if (teleOp.gamepad1.b) {
                    loadState = LoadState.LOADING;
                }
                break;
            case LOADING:
                // TODO: Add load logic
                loadState = LoadState.WAITING_FOR_LAUNCH;
                break;
            case WAITING_FOR_LAUNCH:
                if (launchState == LaunchState.IDLE) {
                    loadState = LoadState.IDLE;
                }
                break;
        }

        // Drive State Machine
        switch (driveState) {
            case IDLE:
                driveState = DriveState.MANUAL;
                break;
            case MANUAL:
                if (teleOp.gamepad1.x) {
                    driveState = DriveState.AUTO_AIM;
                }
                break;
            case AUTO_AIM:
                // TODO: Add auto aim logic
                if (teleOp.gamepad1.y) {
                    driveState = DriveState.MANUAL;
                }
                break;
        }

        // Aim State Machine
        switch (aimState) {
            case IDLE:
                aimState = AimState.AIMING_MANUAL;
                break;
            case AIMING_MANUAL:
                if (driveState == DriveState.AUTO_AIM) {
                    aimState = AimState.AIMING_AUTO;
                }
                break;
            case AIMING_AUTO:
                if (driveState == DriveState.MANUAL) {
                    aimState = AimState.AIMING_MANUAL;
                }
                break;
        }
    }
}
