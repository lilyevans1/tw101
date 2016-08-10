package Biblioteca;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class MainMenuTest {

    private PrintStream printStream;
    private Biblioteca biblioteca;
    private MainMenu menu;
    private BufferedReader reader;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        biblioteca = mock(Biblioteca.class);
        menu = new MainMenu(printStream, reader, biblioteca);
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
    public void shouldPrintListBookOption(){
        menu.printOptionsList();
        verify(printStream).println("Please choose one of the following options: ");
        verify(printStream).println("1. List library books");
        verify(printStream).println("2. Quit");
    }

    @Test
    public void shouldAskForInput() throws IOException {
        when(reader.readLine()).thenReturn("2");
        menu.executeUserInput();

        verify(reader).readLine();
    }

    @Test
    public void shouldPrintBookListWhenInputIsOne() throws IOException {
        when(reader.readLine()).thenReturn("1", "2");
        menu.executeUserInput();

        verify(biblioteca).printBookList();
    }

    @Test
    public void shouldQuitWhenInputIsTwo() throws IOException {
        when(reader.readLine()).thenReturn("1", "2");
        menu.executeUserInput();

        verify(reader, times(2)).readLine();
    }

    @Test
    public void shouldNotifyUserWhenInputIsInvalid() throws IOException {
        when(reader.readLine()).thenReturn("", "1", "2");
        menu.executeUserInput();

        verify(printStream).println("Select a valid option!");
    }

    @Test
    public void shouldAskUserAgainWhenInputIsValid() throws Exception {
        when(reader.readLine()).thenReturn("1", "2");
        menu.executeUserInput();

        verify(biblioteca).printBookList();
        verify(printStream).println("Please choose one of the following options: ");
        verify(printStream).println("1. List library books");
        verify(printStream).println("2. Quit");
        verify(reader, times(2)).readLine();
    }

    @Test
    public void shouldAskUserAgainWhenInputIsInvalid() throws Exception {
        when(reader.readLine()).thenReturn("", "2");
        menu.executeUserInput();

        verify(reader, times(2)).readLine();
    }


}