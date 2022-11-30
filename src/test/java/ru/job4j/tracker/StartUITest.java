package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output output = new StubOutput();
        Input in = new StubInput(new String[] {"0", "Item name", "1"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(output), new ExitAction(output)};
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
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
        assertThat(tracker.findById(id).getName()).isEqualTo("New Item Name");
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
        assertThat(tracker.findById(id)).isNull();
    }

    @Test
    public void whenExit() {
        Output output = new StubOutput();
        Input input = new StubInput(new String[] {"0"});
        Tracker tracker = new Tracker();
        UserAction[] action = {new ExitAction(output)};
        new StartUI(output).init(input, tracker, action);
        assertThat(output.toString()).isEqualTo("Menu." + System.lineSeparator()
                + "0. Exit Program" + System.lineSeparator());
    }
}