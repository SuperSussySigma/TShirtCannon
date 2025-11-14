package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

public class StateMachines extends OpMode {
    public TeleOp teleOp;

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
    
    
    
    public void init() {}
    public void loop() {}
}
