package Biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class BookTest {

    private String title;
    private String author;
    private String yearPublished;
    private Book book;
    private PrintStream printStream;

    @Before
    public void setup() {
        title = "Book Name";
        author = "Author";
        yearPublished = "2016";
        printStream = mock(PrintStream.class);

        book = new Book(title, author, yearPublished, printStream);
    }

    @Test
    public void shouldPrintBookDetails(){
        book.printBookDetails();
        verify(printStream).println(getExpectedDetails());
    }

    @Test
    public void shouldNotPrintBookDetailsWhenCheckedOut() {
        book.checkOut();

        book.printBookDetails();

        verify(printStream, never()).println(getExpectedDetails());
    }

    public String getExpectedDetails() {
        return title + " | " + author + " | " + yearPublished;
    }

}