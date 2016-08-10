package Biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Book> bookList;
    private PrintStream printStream;

    public Biblioteca(PrintStream printStream, ArrayList<Book> bookList){

        this.printStream = printStream;
        this.bookList = bookList;
    }

    public void printBookList() {
        if (this.bookList.isEmpty())
            printStream.println("There are no books.");
        for (Book book : bookList) {
            book.print();
        }
    }
}
