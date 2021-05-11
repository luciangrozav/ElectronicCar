package org.fasttrackit;

import java.util.Scanner;

public class Game implements SystemFunctionality {

    private Car[] cars = new Car[3];
    private Track[] tracks= new Track[3];
    Scanner scanner = new Scanner(System.in);

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
        car1.setEnergylevel(200);
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
        car2.setEnergylevel(100);
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
        car3.setEnergylevel(150);
        ((BMW)car3).setOwner("Harald Kruger");
        ((BMW)car3).setHeadquarters("Munich");
        ((BMW)car3).setFactory("BMW Group Plant Munich");

        cars[2]= car3;

    }

    public void start()
    {
        int n;
        System.out.println("Choose your car:");
        System.out.println("1) Tesla Model S");
        System.out.println("2) Volkswagen Passat");
        System.out.println("3) BMW i8");
        System.out.println(" ");
        System.out.println("Choose:");
        n=scanner.nextInt();
        initialiseCars();
        initialiseTracks();
        if(n==1)
        {
            System.out.println(cars[0].getName());
            System.out.println("Race:");
            autopilot(cars[0].getHorsepower(), tracks[0].getLength(), cars[0].getEnergylevel(), tracks[0].getObstacleposition(), tracks[0].getObstacle());}
        if(n==2)
        {
            System.out.println(cars[1].getName());
            System.out.println("Race:");
            autopilot(cars[1].getHorsepower(), tracks[0].getLength(), cars[1].getEnergylevel(), tracks[0].getObstacleposition(), tracks[0].getObstacle());}
        if(n==3)
        {   System.out.println(cars[2].getName());
            System.out.println("Race:");
            autopilot(cars[2].getHorsepower(), tracks[0].getLength(), cars[2].getEnergylevel(), tracks[0].getObstacleposition(), tracks[0].getObstacle());}

        highwayspeed(cars[1].getHorsepower(), cars[1].getEnergylevel(), tracks[0].getLength());

    }

    private void initialiseTracks()
    {
        Track track1 = new Track();

        track1.setName("Highway");
        track1.setLength(10);  //km
        track1.setObstacle("Warning! Obstacle ahead!");
        track1.setObstacleposition(7);  //km
        track1.setType(3);

        tracks[0]=track1;

    }
    public void autopilot(int p, double d, double en, double obspos, String s)  //scenario1
    {
        double acceleration=0;  // a = dV/dT;
        int time=0;  // secunde
        int i=0;
        double realdistance=0;
        double speed=0;
        double maxSpeed=55.55;
        obspos=obspos*1000;


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

        while(realdistance < (d*1000) && en>0)
        {
            time++;

            if(p<200)
            en=en-0.2;
            if(p>=200 && p<400)
                en=en-0.4;
            if(p>=400 && p<600)
                en=en-0.6;
            if(p>=600 && p<800)
                en=en-0.8;
            if(p>=800 && p<1000)
                en=en-1;

            //speed
            if( realdistance < obspos-500)  //1
            {
                if(speed<= maxSpeed)
                    speed = acceleration * time;
                if(speed>maxSpeed)
                    speed=maxSpeed;

                realdistance += speed;
            }

            if (radar(realdistance, obspos))  //2
            {
                speed = speed-5;
                en=en-1;
                if(speed<25)
                    speed=25;
                realdistance += speed;
            }

            if( realdistance > obspos+300)  //3
            {
                i++;
                speed += acceleration * i;
                if(speed>maxSpeed)
                    speed=maxSpeed;

            realdistance += speed;

            }


            System.out.println("Time: " + time + " s");

            System.out.println("Distance: " + realdistance/1000 + " km");

            System.out.println("Energy level:" + en);

            System.out.println("Speed: " + speed*3.6 + "km/h");

            lanechange(realdistance, obspos, s);

            System.out.println(" ");
        }

        if(en<=0)
            System.out.println("Car stopped, no energy left!");

        if(realdistance>=(d*1000))
            System.out.println("Finish!");
    }


    public void lanechange(double realdistance, double obspos, String s)
    {

        // s- warning-ul
        if (realdistance < obspos-500)
            System.out.println("Direction: Forward");
        if(realdistance >= obspos-500 && realdistance < obspos)
        {
            System.out.println("Direction: Left");
        System.out.println(s);
        }
        if(realdistance >= obspos && realdistance < obspos+300)
        {
            System.out.println("Direction: Right");
        System.out.println(s);
        }
        if (realdistance > obspos+500)
            System.out.println("Direction: Forward");

    }

    public boolean radar(double realdistance, double obspos)
    {

        if (realdistance >= obspos-500 && realdistance <= obspos+300)
        {
         return true;
        } else return false;

    }

    public void highwayspeed(int p, double en, double d)  // scenario2
    {
        System.out.println("Pedal level: {0, 1, 2, 3}");
        System.out.println("Brake level: {0, 1, 2, 3}");
        System.out.println(" ");

        double speed=0;
        int i=1;
        int k=0;
        double maxSpeed=0;
        double acceleration=0;
        int pedallevel; // how much you accelerate; (0, 1, 2, 3)
        int brakelevel=0; // 0, 1, 2, 3
        int time=0;  // timp total
        int t=0;  // timp folosit pentru cresterea vitezei prin accelerare
        double di=0;

        if(p<200)
            acceleration=100000/(12*3600);  // test only for cars <200 horsepower
//        if(p>=200 && p<400)
//            acceleration=100000/(8*3600);
//        if(p>=400 && p<600)
//            acceleration=100000/(6*3600);
//        if(p>=600 && p<800)
//            acceleration=100000/(4*3600);
//        if(p>=800 && p<1000)
//            acceleration=100000/(2*3600);

        System.out.println("Pedal level: ");
        pedallevel = scanner.nextInt();
        System.out.println(" ");
        System.out.println("Set maximum speed (km/h):");
        maxSpeed= scanner.nextDouble();
        maxSpeed=maxSpeed*0.27;

        // Start
        if(pedallevel==1)
            acceleration=acceleration-1.3;
        if(pedallevel==2)
            acceleration=acceleration-0.8;


        while(di< (d*1000) && en>0) {
            time++;

            if (p < 200)
                en = en - 0.2;
//            if (p >= 200 && p < 400)
//                en = en - 0.4;
//            if (p >= 400 && p < 600)
//                en = en - 0.6;
//            if (p >= 600 && p < 800)
//                en = en - 0.8;
//            if (p >= 800 && p < 1000)
//                en = en - 1;

            if (pedallevel == 1 && brakelevel==0)
                acceleration = 1;
            if (pedallevel == 2 && brakelevel==0)
                acceleration = 1.5;
            if(pedallevel == 3 && brakelevel==0)
                acceleration=100000/(12*3600);

            if (brakelevel == 1 && pedallevel == 0)
            {speed = speed - 0.4;
            k++;}
            if (brakelevel == 2 && pedallevel == 0)
            {speed = speed - 0.6;
                k++;}
            if (brakelevel == 3 && pedallevel == 0)
            {speed = speed - 1;
                k++;}

           if(k!=0)
               t=0;

            if (speed <= maxSpeed && pedallevel!=0 && brakelevel==0)  // doar cand accelerezi
            {
                t++;
                speed += acceleration * t;}

            if(pedallevel==0  && brakelevel==0)  // frecarea cu aerul
                speed=speed-0.2;
            if (speed > maxSpeed)
                speed = maxSpeed;


            di += speed;

            System.out.println(" ");
            System.out.println("Time: " + time);
            System.out.println("Speed: " + speed * 3.6);
            System.out.println("Distance:" + di / 1000);
            System.out.println("Energy level:" + en);

                if (time == 30 * i) // => behaviour of the car after 30s
                {
                    i++;
                    System.out.println(" ");
                    System.out.println("Pedal level: ");
                    pedallevel = scanner.nextInt();
                    System.out.println(" ");
                    System.out.println("Brake level: ");
                    brakelevel = scanner.nextInt();
                    System.out.println(" ");

                }

        }
        if(en<=0)
            System.out.println("Car stopped, no energy left!");

        if(di>=(d*1000))
            System.out.println("Finish!");




    }

}
