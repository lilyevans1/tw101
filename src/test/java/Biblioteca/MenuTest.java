package Biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class MenuTest {

    private PrintStream printStream;
    private Biblioteca biblioteca;
    private Menu menu;
    private BufferedReader reader;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        biblioteca = mock(Biblioteca.class);
        menu = new Menu(printStream, reader, biblioteca);
    }

    @Test
    public void shouldPrintWelcome() {
        menu.printWelcome();
        verify(printStream).println("Welcome to the Biblioteca!");
    }

    @Test
    public void shouldPrintGoodbye() {
        menu.printGoodbye();
        verify(printStream).println("Goodbye!");
    }

    @Test
    public void shouldPrintBookOptions(){
        menu.printOptionsList();
        verify(printStream).println("Please choose one of the following options: ");
        verify(printStream).println("0. Quit");
        verify(printStream).println("1. List library books");
        verify(printStream).println("2. Check out a book");

    }

    @Test
    public void shouldAskForInput() throws IOException {
        when(reader.readLine()).thenReturn("0");
        menu.executeUserInput();

        verify(reader).readLine();
    }

    @Test
    public void shouldPrintBookListWhenInputIsOne() throws IOException {
        when(reader.readLine()).thenReturn("1", "0");
        menu.executeUserInput();

        verify(biblioteca).printAvailableBooks();
    }

    @Test
    public void shouldQuitWhenInputIsZero() throws IOException {
        when(reader.readLine()).thenReturn("1", "0");
        menu.executeUserInput();

        verify(reader, times(2)).readLine();
    }

    @Test
    public void shouldNotifyUserWhenInputIsInvalid() throws IOException {
        when(reader.readLine()).thenReturn("", "1", "0");
        menu.executeUserInput();

        verify(printStream).println("Select a valid option!");
    }

    @Test
    public void shouldAskUserAgainWhenInputIsValid() throws Exception {
        when(reader.readLine()).thenReturn("1", "0");
        menu.executeUserInput();

        verify(biblioteca).printAvailableBooks();
        verify(printStream).println("Please choose one of the following options: ");
        verify(printStream).println("0. Quit");
        verify(printStream).println("1. List library books");
        verify(printStream).println("2. Check out a book");
        verify(reader, times(2)).readLine();
    }

    @Test
    public void shouldAskUserAgainWhenInputIsInvalid() throws Exception {
        when(reader.readLine()).thenReturn("", "0");
        menu.executeUserInput();

        verify(reader, times(2)).readLine();
    }

    @Test
    public void shouldAllowUserToCheckoutWhenTwoSelected() throws Exception {
        when(reader.readLine()).thenReturn("2", "0");
        menu.executeUserInput();

        verify(printStream, never()).println("Select a valid option!");
    }

    @Test
    public void shouldCheckoutBookWhenTwoSelected() throws Exception {
        when(reader.readLine()).thenReturn("2", "", "0");
        menu.executeUserInput();

        verify(biblioteca).checkOutBook("");

    }

    @Test
    public void shouldPromptUserToEnterTitleOfCheckedOutBook() throws Exception {
        when(reader.readLine()).thenReturn("2", "0");
        menu.executeUserInput();
        verify(printStream).println("Please enter a book title.");
    }

    @Test
    public void shouldCheckUserInputReceivedWhenOptionTwoSelected() throws Exception {
        when(reader.readLine()).thenReturn("2", "0");
        menu.executeUserInput();
        verify(reader, times(3)).readLine();
    }

    @Test
    public void shouldCheckinBookWhenThreeSelected() throws Exception {
        when(reader.readLine()).thenReturn("3", "", "0");
        menu.executeUserInput();
        verify(biblioteca).checkInBook("");
    }
}