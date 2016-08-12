package Biblioteca;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BookListTest {

    private BookList availableBookList;
    private BookList checkedOutBookList;
    private PrintStream printStream;
    private Book book;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        availableBookList = new BookList(printStream);
        checkedOutBookList = new BookList(printStream);
        book = mock(Book.class);
    }

    @Test
    public void shouldNotBeAvailableWhenCheckedOut() throws Exception {
        availableBookList.removeBook("HP 1");
        assertFalse(availableBookList.containsBook("HP 1"));
    }

    @Test
    public void shouldContainBookWhenAddedToBookList() throws Exception {
        when(book.thisIsMyTitle("title")).thenReturn(true);
        checkedOutBookList.addBook(book);
        assertTrue(checkedOutBookList.containsBook("title"));
    }
}