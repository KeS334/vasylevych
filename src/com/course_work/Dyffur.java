package com.course_work;

public class Dyffur {

    private double x0 = 0;
    private double x1 = 1;
    private double h = 1.0 / 10;
    private double t0 = 0;
    private double t1 = 1;
    private double tau = 1.0 / 300;
    private double a = 1;
    private double b = -1;
    private double C = 1;


    public double getX0() {
        return x0;
    }

    public double getH() {
        return h;
    }

    public double getT0() {
        return t0;
    }

    public double getTau() {
        return tau;
    }

    public int getTpointsAmount() {
        return (int) Math.ceil((t1 - t0) / tau) + 1;
    }

    public int getHpointsAmount() {
        return (int) Math.ceil((x1 - x0) / h) + 1;
    }

    public double calculateTrueSolution(double x, double t) {
        return Math.pow(Math.sqrt(-b / a) + C * Math.exp(-1.5 * a * t + Math.sqrt(a / 2) * x), -1);
    }

    public double calculateBottomBorder(double x) {
        double t = 0;
        return Math.pow(Math.sqrt(-b / a) + C * Math.exp(-1.5 * a * t + Math.sqrt(a / 2) * x), -1);
    }

    public double calculateLeftBorder(double t) {
        double x = 0;
        return Math.pow(Math.sqrt(-b / a) + C * Math.exp(-1.5 * a * t + Math.sqrt(a / 2) * x), -1);
    }

    public double calculateRightBorder(double t) {
        double x = 1;
        return Math.pow(Math.sqrt(-b / a) + C * Math.exp(-1.5 * a * t + Math.sqrt(a / 2) * x), -1);
    }

    public double calculateApproximateSolution(double wiLeft, double wiCurrent, double wiRight) {
        double sigma = tau / (h * h);
        return (wiCurrent + sigma * (wiLeft - 2 * wiCurrent + wiRight) + a * tau * wiCurrent + b * tau * Math.pow(wiCurrent, 3));
    }


}
