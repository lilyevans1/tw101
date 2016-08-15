import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.io.PrintStream;

public class BibliotecaTests {
    private PrintStream printStream;
    private Book book1;
    private Biblioteca biblioteca;
    private MediaList availableMediaList;
    private MediaList checkedOutMediaList;


    @Before
    public void setup() {
        printStream = mock(PrintStream.class);
        book1 = mock(Book.class);
        availableMediaList = mock(MediaList.class);
        checkedOutMediaList = mock(MediaList.class);
        biblioteca = new Biblioteca(availableMediaList, checkedOutMediaList, printStream);
    }

    @Test
    public void shouldCheckBookAvailabilityWhenUserInputsTitle() throws Exception {
        biblioteca.checkOut("HP 1");
        verify(availableMediaList).containsItem("HP 1");
    }

    @Test
    public void shouldRemoveBookFromAvailableListWhenCheckedOut() throws Exception {
        when(availableMediaList.containsItem("HP 1")).thenReturn(true);
        biblioteca.checkOut("HP 1");
        verify(availableMediaList).removeItem("HP 1");
    }

    @Test
    public void shouldMoveBookToCheckedOutList() throws Exception {
        when(availableMediaList.containsItem("HP 1")).thenReturn(true);
        when(availableMediaList.removeItem("HP 1")).thenReturn(book1);
        biblioteca.checkOut("HP 1");
        verify(checkedOutMediaList).addItem(book1);
    }

    @Test
    public void shouldDisplayHappyMessageWhenBookIsCheckedOutSuccessfully() throws Exception {
        when(availableMediaList.containsItem("HP 1")).thenReturn(true);
        biblioteca.checkOut("HP 1");
        verify(printStream).println("Thank you! Enjoy the book.");
    }

    @Test
    public void shouldDisplaySadMessageWhenBookIsCheckedOutUnsuccessfully() throws Exception {
        when(availableMediaList.containsItem("HP 1")).thenReturn(false);
        biblioteca.checkOut("HP 1");
        verify(printStream).println("That book is not available.");
    }

    @Test
    public void shouldRemoveBookFromCheckedOutBookListWhenCheckedIn() throws Exception {
        when(checkedOutMediaList.containsItem("HP 1")).thenReturn(true);
        biblioteca.checkIn("HP 1");
        verify(checkedOutMediaList).removeItem("HP 1");
    }

    @Test
    public void shouldMoveBookToCheckedInList() throws Exception {
        when(checkedOutMediaList.containsItem("HP 1")).thenReturn(true);
        when(checkedOutMediaList.removeItem("HP 1")).thenReturn(book1);
        biblioteca.checkIn("HP 1");
        verify(availableMediaList).addItem(book1);
    }

    @Test
    public void shouldDisplayHappyMessageWhenBookIsCheckedInSuccessfully() throws Exception {
        when(checkedOutMediaList.containsItem("HP 1")).thenReturn(true);
        biblioteca.checkIn("HP 1");
        verify(printStream).println("Thank you for returning the book.");
    }

    @Test
    public void shouldDisplaySadMessageWhenBookIsCheckedInUnsuccessfully() throws Exception {
        when(checkedOutMediaList.containsItem("HP 1")).thenReturn(false);
        biblioteca.checkIn("HP 1");
        verify(printStream).println("That is not a valid book to return.");
    }
}
