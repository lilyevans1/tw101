package Biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class MainMenu {
    private BufferedReader reader;
    private PrintStream printStream;
    private Biblioteca biblioteca;

    public MainMenu(PrintStream printStream, BufferedReader input, Biblioteca biblioteca) {
        this.printStream = printStream;
        this.biblioteca = biblioteca;
        this.reader = input;
    }

    public void start() throws IOException {
        printWelcome();
        printOptionsList();
        executeUserInput();
    }

    public void printWelcome() {
        printStream.println("Welcome to the Biblioteca!");
    }

    public void printOptionsList() {
        printStream.println("Please choose one of the following options: ");
        printStream.println("1. List library books");
    }

    public void executeUserInput() {
        String choice = getUserInput();

        if (choice.equals("1")) {
            biblioteca.printBookList();
        } else {
            printStream.println("Select a valid option!");
            executeUserInput();
        }
    }

    private String getUserInput() {
        String choice = null;
        try {
            choice = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return choice;
    }
}
