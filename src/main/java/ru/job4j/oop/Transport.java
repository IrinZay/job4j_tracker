package ru.job4j.oop;

public class Transport {
    public static void main(String[] args) {
    Vehicle bus = new Bus();
    Vehicle plane = new Plane();
    Vehicle train = new Train();
    Vehicle[] vehicles = new Vehicle[]{bus, plane, train};
        for (Vehicle vehicle: vehicles) {
            vehicle.move();
        }
    }
}
