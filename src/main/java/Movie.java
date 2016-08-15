import java.io.PrintStream;

public class Movie implements MediaItem {

    private final String title;
    private final String yearReleased;
    private final String director;
    private final String rating;
    private final PrintStream printStream;

    public Movie(String title, String yearReleased, String director, String rating, PrintStream printStream) {
        this.title = title;
        this.yearReleased = yearReleased;
        this.director = director;
        this.rating = rating;
        this.printStream = printStream;
    }

    public void printDetails() {
        printStream.println(title + " | " + yearReleased + " | " + director + " | " + rating);
    }

    public boolean thisIsMyTitle(String title) {
        return false;
    }
}
