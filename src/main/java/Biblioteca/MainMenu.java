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

    public void run() throws IOException {
        printWelcome();
        printOptionsList();
        executeUserInput();
        printGoodbye();
    }

    public void printWelcome() {
        printStream.println("Welcome to the Biblioteca!");
    }

    public void printOptionsList() {
        printStream.println("Please choose one of the following options: ");
        printStream.println("1. List library books");
        printStream.println("2. Quit");
    }

    public void executeUserInput() {
        String choice = getUserInput();

        while(!choice.equals("2")) {
            if (choice.equals("1")) {
                biblioteca.printBookList();
            } else {
                printStream.println("Select a valid option!");
            }

            printStream.println();
            printOptionsList();
            choice = getUserInput();
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

    public void printGoodbye() {
        printStream.println("Goodbye!");
    }
}
