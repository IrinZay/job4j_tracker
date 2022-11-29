package ru.job4j.oop;

public class Bus implements Vehicle {
    @Override
    public String path() {
        return "по скоростной трассе";
    }

    @Override
    public void move() {
        System.out.println("Автобус едет " + path());
    }
}
