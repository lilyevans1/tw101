package Biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
    public void shouldPrintWelcome() throws IOException {
        menu.printWelcome();
        verify(printStream).println("Welcome to the Biblioteca!");
    }

    @Test
    public void shouldPrintListBookOption(){
        menu.printOptionsList();
        verify(printStream).println("Please choose one of the following options: ");
        verify(printStream).println("1. List library books");
    }

    @Test
    public void shouldPrintBookListWhenInputIsOne() throws Exception {
        when(reader.readLine()).thenReturn("1");
        menu.executeUserInput();

        verify(reader).readLine();
        verify(biblioteca).printBookList();
    }
}