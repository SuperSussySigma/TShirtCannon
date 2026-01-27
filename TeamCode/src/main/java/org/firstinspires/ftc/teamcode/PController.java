package org.firstinspires.ftc.teamcode;
public class PController {
    private double kP;
    private double pError;
    private double targetPoint;

    public PController (double kP, double targetPoint){
        kP = this.kP;
        targetPoint = this.targetPoint;
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
    public void setTargetPoint(double targetPoint)
    {
        targetPoint = this.targetPoint;

    }

}
