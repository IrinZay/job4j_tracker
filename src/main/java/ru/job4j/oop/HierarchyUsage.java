package ru.job4j.oop;

public class HierarchyUsage {
    public static void main(String[] args) {
        Car car = new Car();
        Transport tp = car;
        Object ob = car;
        Object ocar = car;
        Car carFromObject = (Car) ocar;

        Object bicycle = new Bicycle();
        Car cb = (Car) bicycle;
    }
}
