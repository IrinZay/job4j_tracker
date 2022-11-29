package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output output = new StubOutput();
        Input in = new StubInput(new String[] {"0", "Item name", "1"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(output), new ExitAction(output)};
        new StartUI(output).init(in, tracker, actions);
        assertEquals(tracker.findAll()[0].getName(), "Item name");
    }

    @Test
    public void whenReplaceItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced Item"));
        int id = item.getId();
        String replacedName = "New Item Name";
        Input in = new StubInput(new String[]{"0", String.valueOf(id), replacedName, "1"});
        UserAction[] actions = {new EditAction(output), new ExitAction(output)};
        new StartUI(output).init(in, tracker, actions);
        assertEquals(tracker.findById(id).getName(), replacedName);
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Item to delete"));
        int id = item.getId();
        Input in = new StubInput(new String[]{"0", String.valueOf(id), "1"});
        UserAction[] actions = {new DeleteAction(output), new ExitAction(output)};
        new StartUI(output).init(in, tracker, actions);
        assertNull(tracker.findById(id));
    }

    @Test
    public void whenExit() {
        Output output = new StubOutput();
        Input input = new StubInput(new String[] {"0"});
        Tracker tracker = new Tracker();
        UserAction[] action = {new ExitAction(output)};
        new StartUI(output).init(input, tracker, action);
        assertEquals(output.toString(), "Menu." + System.lineSeparator()
                + "0. Exit Program" + System.lineSeparator());
    }
}