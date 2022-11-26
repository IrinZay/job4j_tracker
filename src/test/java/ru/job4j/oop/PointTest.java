package ru.job4j.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    @Test
    void when00And04Then4() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 4);
        double rsl = a.distance(b);
        double expected = 4;
        assertEquals(expected, rsl);
    }

    @Test
    void when04And40Then4() {
        Point b = new Point(0, 4);
        Point c = new Point(4, 0);
        double rsl = b.distance(c);
        double expected = 5.6;
        assertEquals(expected, rsl, 0.1);
    }

    @Test
    void when00And40Then4() {
        Point a = new Point(0, 0);
        Point c = new Point(4, 0);
        double rsl = a.distance(c);
        double expected = 4;
        assertEquals(expected, rsl);
    }

    @Test
    void when000And044Then() {
        Point a = new Point(0,0,0);
        Point b = new Point(0, 4,4);
        double rsl = a.distance3d(b);
        double expected = 5.6;
        assertEquals(expected, rsl, 0.1);
    }
}