package org.fasttrackit;

public abstract class Car {

    private String name;
    private String color;
    private String type;
    private String multimedia;
    private String audiosystem;
    private String battery;
    private String engine;
    private String action;

    private int weight;
    private int horsepower;
    private double energylevel;

    public double getEnergylevel() {
        return energylevel;
    }

    public void setEnergylevel(double energylevel) {
        this.energylevel = energylevel;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(String multimedia) {
        this.multimedia = multimedia;
    }

    public String getAudiosystem() {
        return audiosystem;
    }

    public void setAudiosystem(String audiosystem) {
        this.audiosystem = audiosystem;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }



}
