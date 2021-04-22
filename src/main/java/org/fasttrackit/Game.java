package org.fasttrackit;

public class Game {

    private Car[] cars = new Car[3];
    private Track[] tracks= new Track[3];

    private void initialiseCars()
    {
        Car car1= new Tesla();
        Car car2 = new Volkswagen();
        Car car3 = new BMW();

        car1.setName("Model S");
        car1.setColor("White");
        car1.setType("Berlin");
        car1.setWeight(2000);  // kg
        car1.setHorsepower(825);
        car1.setMultimedia("LG");
        car1.setAudiosystem("Bang & Olufsen");
        car1.setEngine("Electric");
        car1.setBattery("Panasonic");
        car1.setAction("Forward");
        // type-casting
        ((Tesla)car1).setOwner("Elon Musk");
        ((Tesla)car1).setHeadquarters("California");
        ((Tesla)car1).setFactory("Nevada GigaFactory");

        cars[0]=car1;

        car2.setName("Passat");
        car2.setColor("Grey");
        car2.setType("Break");
        car2.setWeight(1510);
        car2.setHorsepower(140);
        car2.setMultimedia("Samsung");
        car2.setAudiosystem("Harman Kardon");
        car2.setEngine("Diesel");
        car2.setBattery("Varta");
        car2.setAction("Forward");
        ((Volkswagen)car2).setOwner("Herbert Diess");
        ((Volkswagen)car2).setHeadquarters("Wolfsburg");
        ((Volkswagen)car2).setFactory("Wolfsburg Factory Plant");

        cars[1] =car2;

        car3.setName("i8");
        car3.setColor("Lime");
        car3.setType("Sport");
        car3.setWeight(1540);
        car3.setHorsepower(357);
        car3.setMultimedia("DigitalMedia");
        car3.setAudiosystem("Harman Kardon");
        car3.setEngine("Electric");
        car3.setBattery("A123Systems");
        car3.setAction("Forward");
        ((BMW)car3).setOwner("Harald Kruger");
        ((BMW)car3).setHeadquarters("Munich");
        ((BMW)car3).setFactory("BMW Group Plant Munich");

        cars[2]= car3;

    }

    public void start()
    {
        initialiseCars();
        initialiseTracks();
        autopilot(cars[0].getHorsepower(), tracks[0].getLength());

    }

    private void initialiseTracks()
    {
        Track track1 = new Track();

        track1.setName("Highway");
        track1.setLength(10);  //km
        track1.setObstacle("Construction ahead!");
        track1.setObstacleposition(7);  //km

        tracks[0]=track1;

    }
    public void autopilot(int p, double d)
    {
        double acceleration=0;  // a = dV/dT;
        int time=0;
        double realdistance=0;
        double speed=0;
        double maxSpeed=55.55;

        if(p<200)
            acceleration=100000/(12*3600);
        if(p>=200 && p<400)
            acceleration=100000/(8*3600);
        if(p>=400 && p<600)
            acceleration=100000/(6*3600);
        if(p>=600 && p<800)
            acceleration=100000/(4*3600);
        if(p>=800 && p<1000)
            acceleration=100000/(2*3600);

        while(realdistance < (d*1000) )
        {
            time++;

            if(speed> maxSpeed)
                realdistance = maxSpeed *time;

            if(speed<=maxSpeed) {
                speed = acceleration * time;
                realdistance = speed * time;
            }

            System.out.println("Time: " + time + " s");
            if(speed<=maxSpeed)
            System.out.println("Speed: " + speed*3.6 + "km/h");
            if(speed>maxSpeed)
                System.out.println("Speed: " + maxSpeed*3.6 + "km/h");
            System.out.println("Distance: " + realdistance/1000 + " km");
            System.out.println(" ");
        }
        if(realdistance>=(d*1000))
            System.out.println("Finish!");
    }

}
