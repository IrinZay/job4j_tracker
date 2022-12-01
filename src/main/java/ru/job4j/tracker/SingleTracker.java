package ru.job4j.tracker;

public final class SingleTracker {
    private static Tracker tracker = new Tracker();

    private SingleTracker() {
    }

    public static Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return null;
    }
}
