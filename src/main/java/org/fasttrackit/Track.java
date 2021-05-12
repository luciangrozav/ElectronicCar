package org.fasttrackit;

public class Track {


    String name; // Mediu: urban, rural, autostrada; -> type:1, 2, 3.
     int length;
     String obstacle;
     double obstacleposition;
     int type;
     String weatherconditions;

    public String getWeatherconditions() {
        return weatherconditions;
    }

    public void setWeatherconditions(String weatherconditions) {
        this.weatherconditions = weatherconditions;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getObstacle() {
        return obstacle;
    }

    public void setObstacle(String obstacle) {
        this.obstacle = obstacle;
    }

    public double getObstacleposition() {
        return obstacleposition;
    }

    public void setObstacleposition(double obstacleposition) {
        this.obstacleposition = obstacleposition;
    }
}
