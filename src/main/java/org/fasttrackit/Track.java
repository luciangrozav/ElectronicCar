package org.fasttrackit;

public class Track {


    String name; // Mediu: urban, rural, autostrada;
     int length;
     String obstacle;
     int obstacleposition;

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

    public int getObstacleposition() {
        return obstacleposition;
    }

    public void setObstacleposition(int obstacleposition) {
        this.obstacleposition = obstacleposition;
    }
}
