package Biblioteca;


import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.io.PrintStream;
import java.util.ArrayList;

public class BibliotecaTests {
    private PrintStream printstream;
    private Book book1;
    private Book book2;
    private ArrayList<Book> books;
    private Biblioteca biblioteca;


    @Before
    public void setup() {
        printstream = mock(PrintStream.class);
        book1 = mock(Book.class);
        book2 = mock(Book.class);
        books = new ArrayList<Book>();
        biblioteca = new Biblioteca(printstream, books);
    }

    @Test
    public void shouldPrintEmptyStringWhenLibraryEmpty() {
        biblioteca.printBookList();
        verify(printstream).println("There are no books.");
    }

    @Test
    public void shouldPrintOneBookWhenLibraryHasOneBook() {
        books.add(book1);
        biblioteca.printBookList();
        verify(book1).printBookDetails();
    }

    @Test
    public void shouldPrintTwoBooksWhenLibraryHasTwoBooks() {
        books.add(book1);
        books.add(book1);
        biblioteca.printBookList();
        verify(book1, times(2)).printBookDetails();
    }


}
