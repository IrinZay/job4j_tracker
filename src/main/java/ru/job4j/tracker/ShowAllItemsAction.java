package ru.job4j.tracker;

public class ShowAllItemsAction implements UserAction {

    private final Output output;

    public ShowAllItemsAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println(name());
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                output.println(item);
            }
        } else {
            output.println("Хранилище ещё не содержит заявок");
        }
        return true;
    }
}
