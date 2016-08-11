package Biblioteca;

import java.io.PrintStream;

public class Book {

    private String title;
    private String author;
    private String yearPublished;
    private PrintStream printStream;
    private boolean checkedOut;

    public Book(String title, String author, String yearPublished, PrintStream printStream) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.printStream = printStream;
        this.checkedOut = false;
    }

    public void printBookDetails() {
        if (!checkedOut) {
            printStream.println(title + " | " + author + " | " + yearPublished);
        }
    }

    /*public void checkOut() {
        checkedOut = true;
    }*/
}
