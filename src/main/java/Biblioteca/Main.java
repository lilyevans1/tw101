package Biblioteca;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.Buffer;
import java.util.ArrayList;

public class Main {
    public static void main(String [] args) throws IOException{
        PrintStream printStream = System.out;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Biblioteca biblioteca = setupBiblioteca(printStream);

        MainMenu menu = new MainMenu(printStream, reader, biblioteca);
        menu.start();
    }

    private static Biblioteca setupBiblioteca(PrintStream printStream) {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("HP 1", "JK Row", "1997", printStream));
        books.add(new Book("HP 2", "JK Row", "1999", printStream));
        books.add(new Book("HP 3", "JK Row", "2003", printStream));

        return new Biblioteca(System.out, books);
    }

}