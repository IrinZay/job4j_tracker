package ru.job4j.pojo;

public class Book {
    private String title;
    private int sheets;

    public Book(String title, int sheets) {
        this.title = title;
        this.sheets = sheets;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSheets() {
        return sheets;
    }

    public void setSheets(int sheets) {
        this.sheets = sheets;
    }
}
