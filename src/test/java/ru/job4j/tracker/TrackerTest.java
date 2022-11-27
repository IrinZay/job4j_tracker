package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertEquals(result.getName(), item.getName());
    }

    @Test
    public void whenTestFindById() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        Item item = tracker.add(bug);
        Item result = tracker.findById(item.getId());
        assertEquals(item.getName(), result.getName());
    }

    @Test
    public void whenTestFindAll() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        Item result = tracker.findAll()[0];
        assertEquals(first.getName(), result.getName());
    }

    @Test
    public void whenTestFindByNameCheckArrayLength() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        Item[] result = tracker.findByName(first.getName());
        assertEquals(result.length, 3);
    }

    @Test
    public void whenTestFindByNameCheckSecondItemName() {
        Tracker tracker = new Tracker();
        Item first = new Item("First");
        Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        Item[] result = tracker.findByName(second.getName());
        assertEquals(result[1].getName(), second.getName());
    }

    @Test
    public void whenReplaceItemIsSuccessful() {
        Tracker tracker = new Tracker();
        Item item = new Item("Bug");
        tracker.add(item);
        int id = item.getId();
        Item updateItem = new Item("Bug with description");
        tracker.replace(id, updateItem);
        assertEquals("Bug with description", tracker.findById(id).getName());
    }

    @Test
    public void whenReplaceItemIsNotSuccessful() {
        Tracker tracker = new Tracker();
        Item item = new Item("Bug");
        tracker.add(item);
        Item updateItem = new Item("Bug with description");
        boolean result = tracker.replace(1000, updateItem);
        assertEquals("Bug", tracker.findById(item.getId()).getName());
        assertFalse(result);
    }

}