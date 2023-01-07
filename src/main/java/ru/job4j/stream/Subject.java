package ru.job4j.stream;

public record Subject(String name, int score) {
    @Override
    public String name() {
        return name;
    }

    @Override
    public int score() {
        return score;
    }
}
