package org.fasttrackit;

public class Game {

    private Car[] cars = new Car[3];

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
        ((BMW)car3).setOwner("Harald Kruger");
        ((BMW)car3).setHeadquarters("Munich");
        ((BMW)car3).setFactory("BMW Group Plant Munich");

        cars[2]= car3;

    }

    public void start()
    {
        initialiseCars();
        System.out.println(cars[0].getName());

    }

}
