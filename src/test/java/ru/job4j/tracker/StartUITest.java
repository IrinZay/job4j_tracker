package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output output = new StubOutput();
        Input in = new StubInput(new String[] {"0", "Item name", "1"});
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        Collections.addAll(actions, new CreateAction(output), new ExitAction(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Item name");
    }

    @Test
    public void whenReplaceItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced Item"));
        int id = item.getId();
        String replacedName = "New Item Name";
        Input in = new StubInput(new String[]{"0", String.valueOf(id), replacedName, "1"});
        List<UserAction> actions = new ArrayList<>();
        Collections.addAll(actions, new EditAction(output), new ExitAction(output));
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
        List<UserAction> actions = new ArrayList<>();
        Collections.addAll(actions, new DeleteAction(output), new ExitAction(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(id)).isNull();
    }

    @Test
    public void whenExit() {
        Output output = new StubOutput();
        Input input = new StubInput(new String[] {"0"});
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        Collections.addAll(actions, new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).isEqualTo("Menu." + System.lineSeparator()
                + "0. Exit Program" + System.lineSeparator()
                + "Exit Program" + System.lineSeparator());
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        Collections.addAll(actions, new EditAction(out), new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "Edit item" + ln
                        + "Заявка заменена успешно." + ln
                        + "Menu." + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
                        + "Exit Program" + ln
        );
    }

    @Test
    public void whenFindAllItemsTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[] {"0", "1"});
        List<UserAction> actions = new ArrayList<>();
        Collections.addAll(actions, new ShowAllItemsAction(output),
                                new ExitAction(output));
        new StartUI(output).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "Show all items" + ln
                        + "Хранилище ещё не содержит заявок" + ln
                        + "Menu." + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "Exit Program" + ln
        );
    }

    @Test
    public void whenFindItemByNameTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test"));
        Input in = new StubInput(
                new String[] {"0", item.getName(), "1"});
        List<UserAction> actions = new ArrayList<>();
        Collections.addAll(actions, new FindByNameAction(output),
                new ExitAction(output));
        new StartUI(output).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "Find items by name" + ln
                        + item + ln
                        + "Menu." + ln
                        + "0. Find items by name" + ln
                        + "1. Exit Program" + ln
                        + "Exit Program" + ln
        );
    }

    @Test
    public void whenFindItemByIdTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"});
        List<UserAction> actions = new ArrayList<>();
        Collections.addAll(actions, new FindByIdAction(output),
                new ExitAction(output));
        new StartUI(output).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "Find item by id" + ln
                        + item + ln
                        + "Menu." + ln
                        + "0. Find item by id" + ln
                        + "1. Exit Program" + ln
                        + "Exit Program" + ln
        );
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"7", "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        Collections.addAll(actions, new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. Exit Program" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu." + ln
                        + "0. Exit Program" + ln
                        + "Exit Program" + ln
        );
    }
}
