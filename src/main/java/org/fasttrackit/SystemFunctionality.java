package org.fasttrackit;

public interface SystemFunctionality{

    void autopilot(int p, double d, double en, double obspos, String s);
    void lanechange(double realdistance, double obspos, String s);
    boolean radar(double realdistance, double obspos);
    void highwayspeed(int p, double en, double d);
}
