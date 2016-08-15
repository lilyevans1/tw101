import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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
        book.printDetails();
        verify(printStream).println(getExpectedDetails());
    }

    public String getExpectedDetails() {
        return title + " | " + author + " | " + yearPublished;
    }

    @Test
    public void shouldReturnFalseWhenTitleIsNotMyTitle() throws Exception {
        assertFalse(book.thisIsMyTitle("Not Book Name"));
    }

    @Test
    public void shouldReturnTrueWhenTitleIsMyTitle() throws Exception {
        assertTrue(book.thisIsMyTitle("Book Name"));
    }

}