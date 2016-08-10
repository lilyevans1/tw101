package Biblioteca;


import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.io.PrintStream;
import java.util.ArrayList;

public class BibliotecaTests {
    private PrintStream printstream;
    private Book book;
    private ArrayList<Book> books;


    @Before
    public void setup() {
        printstream = mock(PrintStream.class);
        book = mock(Book.class);
        books = new ArrayList<Book>();
    }

    @Test
    public void shouldPrintEmptyStringWhenLibraryEmpty() {
        Biblioteca biblioteca = new Biblioteca(printstream, books);
        biblioteca.printBookList();
        verify(printstream).println("There are no books.");
    }

    @Test
    public void shouldPrintOneBookWhenLibraryHasOneBook() {
        books.add(book);
        Biblioteca biblioteca = new Biblioteca(printstream, books);
        biblioteca.printBookList();
        verify(book).print();
    }

    @Test
    public void shouldPrintTwoBooksWhenLibraryHasTwoBooks() {
        books.add(book);
        books.add(book);
        Biblioteca biblioteca = new Biblioteca(printstream, books);
        biblioteca.printBookList();
        verify(book, times(2)).print();
    }
}
