package ru.job4j.tracker;

public class EditAction implements UserAction {

    private final Output output;

    public EditAction(Output out) {
        this.output = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println(name());
        int id = input.askInt("Enter id :");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            output.println("Заявка изменена успешно.");
        } else {
            output.println("Ошибка замены заявки.");
        }
        return true;
    }

}
