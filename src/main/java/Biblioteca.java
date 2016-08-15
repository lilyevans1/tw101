import java.io.PrintStream;

public class Biblioteca {

    private MediaList availableMediaList;
    private MediaList checkedOutMediaList;
    private PrintStream printStream;

    public Biblioteca(MediaList availableMediaList, MediaList checkedOutMediaList, PrintStream printStream){
        this.availableMediaList = availableMediaList;
        this.checkedOutMediaList = checkedOutMediaList;
        this.printStream = printStream;
    }

    public void printAvailableBooks() {
        availableMediaList.printBookList();
    }

    public void printAvailableMovies() {
        availableMediaList.printMovieList();
    }

    public void checkOut(String title) {
        if(availableMediaList.containsItem(title)){
            MediaItem itemToCheckOut = availableMediaList.removeItem(title);
            checkedOutMediaList.addItem(itemToCheckOut);
            printStream.println("Thank you! Enjoy the book.");
        } else
            printStream.println("That book is not available.");
    }

    public void checkIn(String title) {
        if(checkedOutMediaList.containsItem(title)) {
            MediaItem itemToCheckIn = checkedOutMediaList.removeItem(title);
            availableMediaList.addItem(itemToCheckIn);
            printStream.println("Thank you for returning the book.");
        } else
            printStream.println("That is not a valid book to return.");
    }


}
