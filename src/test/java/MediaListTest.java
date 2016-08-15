import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MediaListTest {

    private MediaList mediaList;
    private PrintStream printStream;
    private Book book;
    private Movie movie;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        mediaList = new MediaList(printStream);
        book = mock(Book.class);
        movie = mock(Movie.class);
    }


    @Test
    public void shouldNotBeAvailableWhenCheckedOut() throws Exception {
        mediaList.removeItem("HP 1");
        assertFalse(mediaList.containsItem("HP 1"));
    }

    @Test
    public void shouldContainBookWhenAddedToBookList() throws Exception {
        when(book.thisIsMyTitle("title")).thenReturn(true);
        mediaList.addItem(book);
        assertTrue(mediaList.containsItem("title"));
    }

    @Test
    public void shouldListOneBookWhenOneBookInMediaList() throws Exception {
        mediaList.addItem(book);
        mediaList.printBookList();
        verify(book).printDetails();
    }

    @Test
    public void shouldListZeroBooksWhenZeroBooksInMediaListAndOneMovie() throws Exception {
        mediaList.addItem(movie);
        verify(book, never()).printDetails();
        verify(movie, never()).printDetails();
    }

    @Test
    public void shouldListOneMovieWhenOneMovieInMediaList() throws Exception {
        mediaList.addItem(movie);
        mediaList.printMovieList();
        verify(movie).printDetails();
    }

    @Test
    public void shouldListZeroMoviesWhenZeroMoviesInMediaListAndOneBook() throws Exception {
        mediaList.addItem(book);
        verify(movie, never()).printDetails();
        verify(book, never()).printDetails();
    }
}