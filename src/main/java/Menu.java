import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Menu {

    private BufferedReader reader;
    private PrintStream printStream;
    private Biblioteca biblioteca;

    public Menu(PrintStream printStream, BufferedReader input, Biblioteca biblioteca) {
        this.printStream = printStream;
        this.biblioteca = biblioteca;
        this.reader = input;
    }

    public void start() throws IOException {
        printWelcome();
        printOptionsList();
        runUntilQuit();
    }

    private void printWelcome() {
        printStream.println("Welcome to the Biblioteca!");
    }

    private void printOptionsList() {
        printStream.println("Please choose one of the following options: ");
        printStream.println("0. Quit");
        printStream.println("1. List books");
        printStream.println("2. Check out a book");
        printStream.println("3. Check in a book");
        printStream.println("4. List movies");
    }

    private void runUntilQuit() throws IOException {
        String choice = getUserInput();
        while(!choice.equals("0")) {
            executeUserInput(choice);
            printStream.println();
            printOptionsList();
            choice = getUserInput();
        }
        quit();
    }

    private void executeUserInput(String choice) throws IOException {
        if (choice.equals("1")) {
            biblioteca.printAvailableBooks();
        } else if (choice.equals("2")){
            printStream.println("Please enter a book title.");
            String title = reader.readLine();
            biblioteca.checkOut(title);
        } else if (choice.equals("3")){
            printStream.println("Please enter a book title.");
            String title = reader.readLine();
            biblioteca.checkIn(title);
        } else if (choice.equals("4")){
            biblioteca.printAvailableMovies();
        } else {
            printStream.println("Select a valid option!");
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

    private void quit() {
        printStream.println("Goodbye!");
    }
}
