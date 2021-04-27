package org.fasttrackit;

public interface SystemFunctionality{

    void autopilot(int p, double d, double en, double obspos, String s);
    void radar(double realdistance, double obspos, String s, double speed);
    void brake(double speed);
}
