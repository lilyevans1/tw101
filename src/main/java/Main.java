import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {
    public static void main(String [] args) throws IOException{
        PrintStream printStream = System.out;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        MediaList checkedOutItems = new MediaList(printStream);
        MediaList availableItems = getAvailableItemList(printStream);

        Biblioteca biblioteca = new Biblioteca(availableItems, checkedOutItems, printStream);

        Menu menu = new Menu(printStream, reader, biblioteca);
        menu.start();
    }

    private static MediaList getAvailableItemList(PrintStream printStream) {
        Book hp1 = new Book("HP 1", "JK Row", "1997", printStream);
        Book hp2 = new Book("HP 2", "JK Row", "1997", printStream);
        Book hp3 = new Book("HP 3", "JK Row", "1997", printStream);
        Movie hp4 = new Movie("HP 4", "1997", "Director", "10", printStream);

        MediaList list = new MediaList(printStream);

        list.addItem(hp1);
        list.addItem(hp2);
        list.addItem(hp3);
        list.addItem(hp4);
        return list;
    }

}
