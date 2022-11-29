package ru.job4j.oop;

public class Plane implements Vehicle {
    @Override
    public String path() {
        return "по воздуху";
    }

    @Override
    public void move() {
        System.out.println("Самолет летит " + path());
    }
}
