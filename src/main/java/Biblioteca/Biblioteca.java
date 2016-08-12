package Biblioteca;

import java.io.PrintStream;

public class Biblioteca {

    private BookList availableBookList;
    private BookList checkedOutBookList;
    private PrintStream printStream;

    public Biblioteca(BookList availableBookList, BookList checkedOutBookList, PrintStream printStream){

        this.availableBookList = availableBookList;
        this.checkedOutBookList = checkedOutBookList;
        this.printStream = printStream;
    }

    public void printAvailableBooks() {
        availableBookList.printBookList();
    }

    public void printCheckedOutBooks() {
        checkedOutBookList.printBookList();
    }

    public void checkOutBook(String title) {
        if(availableBookList.containsBook(title)){
            Book bookToCheckOut = availableBookList.removeBook(title);
            checkedOutBookList.addBook(bookToCheckOut);
            printStream.println("Thank you! Enjoy the book.");
        } else
            printStream.println("That book is not available.");
    }

    public void checkInBook(String title) {
        if(checkedOutBookList.containsBook(title)) {
            Book bookToCheckIn = checkedOutBookList.removeBook(title);
            availableBookList.addBook(bookToCheckIn);
            printStream.println("Thank you for returning the book.");
        } else
            printStream.println("That is not a valid book to return.");
    }
}
