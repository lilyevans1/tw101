package Biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;

public class BookList {

    private ArrayList<Book> books;
    private PrintStream printStream;

    public BookList(PrintStream printStream) {
        this.printStream = printStream;
        this.books = new ArrayList<Book>();

    }

    public boolean containsBook(String title) {
        for (Book bookChoice : books){
            if(bookChoice.thisIsMyTitle(title))
                return true;
        }
        return false;
    }

    public void printBookList() {
        if (books.isEmpty()) {
            printStream.println("There are no books.");
        }
        for (Book book : books) {
            book.printBookDetails();
        }
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book removeBook(String title) {
        for (Book bookChoice : books){
            if (bookChoice.thisIsMyTitle(title)){
                books.remove(bookChoice);
                return bookChoice;
            }
        }
        return null;
    }
}
