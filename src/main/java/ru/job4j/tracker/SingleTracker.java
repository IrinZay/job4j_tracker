package ru.job4j.tracker;

public final class SingleTracker {
    private static Tracker tracker = null;

    private SingleTracker() {
    }

    public static Tracker getTracker() {
        if (tracker == null) {
            tracker = new Tracker();
        }
        return tracker;
    }

    public static Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return null;
    }
}
