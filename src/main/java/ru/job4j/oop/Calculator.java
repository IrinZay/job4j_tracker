package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int y) {
        return x * y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + multiply(y) + minus(y) + divide(y);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(5);
        System.out.println("Результат метода multiply = " + rsl);
        rsl = sum(5);
        System.out.println("Результат метода sum = " + rsl);
        rsl = minus(5);
        System.out.println("Результат метода minus = " + rsl);
        rsl = calculator.divide(5);
        System.out.println("Результат метода divide = " + rsl);
        rsl = calculator.sumAllOperation(5);
        System.out.println("Результат метода sumAllOperation = " + rsl);
    }
}
