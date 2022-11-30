package ru.job4j.tracker;

public class CreateAction implements UserAction {

    private final Output output;

    public CreateAction(Output out) {
        this.output = out;
    }

    @Override
    public String name() {
        return "Add new Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println(name());
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        output.println("Добавленная заявка: " + item);
        return true;
    }

}
