package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error () {
    }

    public Error (boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void showInfo () {
        System.out.println("Ошибка - " + active);
        System.out.println("Статус - " + status);
        System.out.println("Сообщение - " + message);
    }

    public static void main(String[] args) {
        Error error = new Error(true, 1, "disconnected");
        error.showInfo();
        System.out.println();
        Error error404 = new Error();
        error404.showInfo();
    }
}
