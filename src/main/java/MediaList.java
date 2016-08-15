import java.io.PrintStream;
import java.util.ArrayList;

public class MediaList {

    private ArrayList<MediaItem> items;
    private PrintStream printStream;

    public MediaList(PrintStream printStream) {
        this.printStream = printStream;
        this.items = new ArrayList<MediaItem>();

    }

    public boolean containsItem(String title) {
        for (MediaItem item : items){
            if(item.thisIsMyTitle(title))
                return true;
        }
        return false;
    }

    public void printBookList() {
        if (items.isEmpty()) {
            printStream.println("There are no books.");
        }
        for (MediaItem item : items) {
            if (item instanceof Book) {
                item.printDetails();
            }
        }
    }

    public void printMovieList() {
        if (items.isEmpty()) {
            printStream.println("There are no movies.");
        }
        for (MediaItem item : items) {
            if (item instanceof Movie) {
                item.printDetails();
            }
        }
    }

    public void addItem(MediaItem item) {
        items.add(item);
    }

    public MediaItem removeItem(String title) {
        for (MediaItem item : items){
            if (item.thisIsMyTitle(title)){
                items.remove(item);
                return item;
            }
        }
        return null;
    }


}
