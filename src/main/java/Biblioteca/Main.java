package Biblioteca;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {
    public static void main(String [] args) throws IOException{
        PrintStream printStream = System.out;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BookList checkedOutBooks = new BookList(printStream);
        BookList availableBooks = getAvailableBookList(printStream);

        Biblioteca biblioteca = new Biblioteca(availableBooks, checkedOutBooks, printStream);

        Menu menu = new Menu(printStream, reader, biblioteca);
        menu.run();
    }

    private static BookList getAvailableBookList(PrintStream printStream) {
        Book hp1 = new Book("HP 1", "JK Row", "1997", printStream);
        Book hp2 = new Book("HP 2", "JK Row", "1997", printStream);
        Book hp3 = new Book("HP 3", "JK Row", "1997", printStream);

        BookList availableBooks = new BookList(printStream);

        availableBooks.addBook(hp1);
        availableBooks.addBook(hp2);
        availableBooks.addBook(hp3);
        return availableBooks;
    }

}
