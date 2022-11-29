package ru.job4j.oop;

public class Train implements Vehicle {
    @Override
    public String path() {
        return "по рельсам";
    }

    @Override
    public void move() {
        System.out.println("Поезд идёт " + path());
    }
}
