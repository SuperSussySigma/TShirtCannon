package org.firstinspires.ftc.teamcode;
public class PController {
    private double kP;
    private double pError;
    private double targetPoint;

    public PController (double p, double target){
        kP = p;
        targetPoint = target;
    }

    public double updatePController(double currPosition)
    {
        pError = targetPoint - currPosition;

        return kP * pError;
    }
    public double getTargetPoint()
    {
        return targetPoint;
    }
    public void setTargetPoint(double target)
    {
        targetPoint = target;

    }

}
