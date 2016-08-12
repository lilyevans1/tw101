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
        biblioteca = new Biblioteca(availableBookList, checkedOutBookList);
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
}
