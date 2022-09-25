import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class DVDLibraryDAOImpl implements DVDLibraryDAO {
    private Map<String, DVD> dvds = new HashMap<>();

    @Override
    public void addDVD(DVD dvd) {
        dvds.put(dvd.getTitle(), dvd);
    }

    @Override
    public void removeDVD(DVD dvd) {
        dvds.remove(dvd.getTitle());
    }

    @Override
    public void editDVD(DVD dvd, int category, String value) {
        switch (category) {
            case 1 -> dvd.setTitle(value);
            case 2 -> dvd.setReleaseDate(LocalDate.parse(value));
            case 3 -> dvd.setRating(value);
            case 4 -> dvd.setDirector(value);
            case 5 -> dvd.setStudio(value);
            case 6 -> dvd.setUserReview(value);
        }
    }

    @Override
    public Map<String, DVD> displayDVDList() {
        return dvds;
    }

    @Override
    public void displayDVDInfo(DVD dvd) {

    }

    @Override
    public DVD searchDVD(String title) {
        return dvds.get(title);
    }

    @Override
    public boolean loadLibFile(String filename) throws FileNotFoundException {
        // read dvd library in from text file.
        try {
            Scanner file = new Scanner(new BufferedReader(new FileReader(filename)));
            while (file.hasNextLine()) {
                String line = file.nextLine();
                String[] vals = line.split(", ");
                DVD dvd = new DVD(vals[0], LocalDate.parse(vals[1]), vals[2], vals[3], vals[4], vals[5]);
                dvds.put(vals[0], dvd);
            }
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    @Override
    public void saveLibFile(String filename) throws IOException {
        // save current dvd library into textfile.
        PrintWriter out = new PrintWriter(new FileWriter(filename));
        for ( DVD dvd : dvds.values() ) {
            System.out.println(dvd);
            out.println(dvd.getTitle() + ", " +
                    dvd.getReleaseDate().toString() + ", " +
                    dvd.getRating() + ", " +
                    dvd.getDirector() + ", " +
                    dvd.getStudio() + ", " +
                    dvd.getUserReview());
        }
        out.flush();
        out.close();

    }

}
