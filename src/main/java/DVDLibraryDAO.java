import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public interface DVDLibraryDAO {
    void addDVD(DVD dvd);

    void removeDVD(DVD dvd);

    void editDVD(DVD dvd, int category, String value);

    Map<String, DVD> displayDVDList();

    void displayDVDInfo(DVD dvd);

    DVD searchDVD(String title);

    boolean loadLibFile(String filename) throws FileNotFoundException;

    void saveLibFile(String filename) throws IOException;
}
