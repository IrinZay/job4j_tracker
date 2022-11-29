package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Input in = new StubInput(new String[] {"0", "Item name", "1"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(), new ExitAction()};
        new StartUI().init(in, tracker, actions);
        assertEquals(tracker.findAll()[0].getName(), "Item name");
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced Item"));
        int id = item.getId();
        String replacedName = "New Item Name";
        Input in = new StubInput(new String[]{"0", String.valueOf(id), replacedName, "1"});
        UserAction[] actions = {new EditAction(), new ExitAction()};
        new StartUI().init(in, tracker, actions);
        assertEquals(tracker.findById(id).getName(), replacedName);
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Item to delete"));
        int id = item.getId();
        Input in = new StubInput(new String[]{"0", String.valueOf(id), "1"});
        UserAction[] actions = {new DeleteAction(), new ExitAction()};
        new StartUI().init(in, tracker, actions);
        assertNull(tracker.findById(id));
    }
}