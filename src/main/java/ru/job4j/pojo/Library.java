package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book java = new Book("Java for beginners", 712);
        Book cleanCode = new Book("Clean Code", 464);
        Book aGameOfThrones = new Book("A game of thrones", 694);
        Book algorithms = new Book("Grokking algorithms", 256);
        Book[] books = new Book[4];
        books[0] = java;
        books[1] = cleanCode;
        books[2] = aGameOfThrones;
        books[3] = algorithms;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getTitle() + " " + bk.getSheets());
        }
        System.out.println("Swap first and last books");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getTitle() + " " + bk.getSheets());
        }
        System.out.println("Shown only book.title -> Clean Code");
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            if ("Clean Code".equals(bk.getTitle())) {
                System.out.println(bk.getTitle() + " " + bk.getSheets());
            }
        }
    }
}
