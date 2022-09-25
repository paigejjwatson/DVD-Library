import javax.xml.transform.stream.StreamSource;
import java.net.StandardSocketOptions;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Map;

public class DVDLibraryView {

    private UserIO io = new UserIOImpl();

    public int menuChoice() {

        io.printf("--- MENU ---\n" +
                "type the number corresponding to the choice you require.\n\n" +
                "1 : Add a DVD to the collection\n" +
                "2 : Remove a DVD from the collection\n" +
                "3 : Edit information for a DVD in the collection\n" +
                "4 : List all DVDs in the collection\n" +
                "5 : Display information for a specific DVD\n" +
                "6 : Search for a DVD by title\n" +
                "7 : Load a DVD library from external source\n" +
                "8 : Save the DVD collection and exit\n\n");

        return io.readInt("choice: ", 1, 8);
    }

    public void addDVDBanner() {
        io.println("--- ADD DVD ---");
    }

    public void removeDVDBanner() {
        io.println("--- REMOVE DVD ---");
    }

    public void listDVDsBanner() {
        io.println("--- LIST DVDs ---");
    }
    public DVD getNewDVDInfo() {
        String title = io.readString("Enter the DVD TITLE: ");
        LocalDate release = io.readDate("Enter the DVD RELEASE DATE (format dd/mm/yyyy): ");
        String rating = io.readString("Enter the DVD MPAA RATING (choices: G, PG, PG13, R, NC17): ");
        String director = io.readString("Enter the DVD's DIRECTOR'S NAME: ");
        String studio = io.readString("Enter the DVD's STUDIO NAME: ");
        String review = io.readString("Enter a short USER REVIEW for the DVD: ");
        DVD dvd = new DVD(title, release, rating, director, studio, review);
        return dvd;
    }

    public String getDVDName() {
        return io.readString("Enter the DVD Title: ");
    }

    public void displayDVDList(Map<String, DVD> dvds) {
        for ( String title : dvds.keySet() ) {
            io.println(title);
        }
    }

    public int editCategoryChoice() {
        io.printf("--- EDIT DVD ---\n" +
                "type the number corresponding to the category you wish to edit.\n" +
                "1 : Title\n" +
                "2 : releaseDate\n" +
                "3 : Rating\n" +
                "4 : Director\n" +
                "5 : Studio\n" +
                "6 : User Review\n\n");
        return io.readInt("choice: ", 1, 6);
    }

    public String getValueGeneric() {
        return io.readString("Enter the new value for this category (note: dates must be in format dd/mm/yyyy):  ");
    }

    public void displayDVDInfo(DVD dvd) {
        io.println("--- DVD INFORMATION ---");
        System.out.printf("Title: %s\n", dvd.getTitle());
        System.out.printf("Release Date: %s\n", dvd.getReleaseDate().toString());
        System.out.printf("Rating: %s\n", dvd.getRating());
        System.out.printf("Director: %s\n", dvd.getDirector());
        System.out.printf("Studio: %s\n", dvd.getStudio());
        System.out.printf("User Review: %s\n", dvd.getUserReview());
    }

    public void loadFromFile() {
        io.println("--- LOAD DVD LIBRARY FROM FILE ---");
        System.out.println("Loading library from file...");
        io.println("done!");
    }

    public void saveToFile() {
        io.println("--- SAVE DVD LIBRARY ---");
        io.println("Saving...");
        io.println("Saved.");
    }

    public String getFile() {
        return io.readString("Enter the name of the file to load: ");
    }

    public String getFileToWrite() {
        return io.readString("Enter the name of the file to write to: ");
    }

    public void writeString(String string) {
        io.println(string);
    }

}
