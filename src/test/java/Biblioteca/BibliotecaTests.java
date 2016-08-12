package Biblioteca;


import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.io.PrintStream;

public class BibliotecaTests {
    private PrintStream printStream;
    private Book book1;
    private Book book2;
    private Biblioteca biblioteca;
    private BookList availableBookList;
    private BookList checkedOutBookList;


    @Before
    public void setup() {
        printStream = mock(PrintStream.class);
        book1 = mock(Book.class);
        book2 = mock(Book.class);
        availableBookList = mock(BookList.class);
        checkedOutBookList = mock(BookList.class);
        biblioteca = new Biblioteca(availableBookList, checkedOutBookList, printStream);
    }

    @Test
    public void shouldCheckBookAvailabilityWhenUserInputsTitle() throws Exception {
        biblioteca.checkOutBook("HP 1");
        verify(availableBookList).containsBook("HP 1");
    }

    @Test
    public void shouldRemoveBookFromAvailableListWhenCheckedOut() throws Exception {
        when(availableBookList.containsBook("HP 1")).thenReturn(true);
        biblioteca.checkOutBook("HP 1");
        verify(availableBookList).removeBook("HP 1");
    }

    @Test
    public void shouldMoveBookToCheckedOutList() throws Exception {
        when(availableBookList.containsBook("HP 1")).thenReturn(true);
        when(availableBookList.removeBook("HP 1")).thenReturn(book1);
        biblioteca.checkOutBook("HP 1");
        verify(checkedOutBookList).addBook(book1);
    }

    @Test
    public void shouldDisplayHappyMessageWhenBookIsCheckedOutSuccessfully() throws Exception {
        when(availableBookList.containsBook("HP 1")).thenReturn(true);
        biblioteca.checkOutBook("HP 1");
        verify(printStream).println("Thank you! Enjoy the book.");
    }

    @Test
    public void shouldDisplaySadMessageWhenBookIsCheckedOutUnsuccessfully() throws Exception {
        when(availableBookList.containsBook("HP 1")).thenReturn(false);
        biblioteca.checkOutBook("HP 1");
        verify(printStream).println("That book is not available.");
    }

    @Test
    public void shouldRemoveBookFromCheckedOutBookListWhenCheckedIn() throws Exception {
        when(checkedOutBookList.containsBook("HP 1")).thenReturn(true);
        biblioteca.checkInBook("HP 1");
        verify(checkedOutBookList).removeBook("HP 1");
    }

    @Test
    public void shouldMoveBookToCheckedInList() throws Exception {
        when(checkedOutBookList.containsBook("HP 1")).thenReturn(true);
        when(checkedOutBookList.removeBook("HP 1")).thenReturn(book1);
        biblioteca.checkInBook("HP 1");
        verify(availableBookList).addBook(book1);
    }

    @Test
    public void shouldDisplayHappyMessageWhenBookIsCheckedInSuccessfully() throws Exception {
        when(checkedOutBookList.containsBook("HP 1")).thenReturn(true);
        biblioteca.checkInBook("HP 1");
        verify(printStream).println("Thank you for returning the book.");
    }

    @Test
    public void shouldDisplaySadMessageWhenBookIsCheckedInUnsuccessfully() throws Exception {
        when(checkedOutBookList.containsBook("HP 1")).thenReturn(false);
        biblioteca.checkInBook("HP 1");
        verify(printStream).println("That is not a valid book to return.");
    }
}
