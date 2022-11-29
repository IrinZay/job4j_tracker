package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void ride() {
        System.out.println("The bus goes");
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("There are "  + passengers + " passengers on the bus.");
    }

    @Override
    public int refuel(int fuel) {
        int price = 0;
        return price;
    }
}
