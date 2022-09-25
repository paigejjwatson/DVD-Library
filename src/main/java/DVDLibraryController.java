import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class DVDLibraryController {
    private DVDLibraryView view = new DVDLibraryView();
    private UserIO io = new UserIOImpl();
    private DVDLibraryDAO dao = new DVDLibraryDAOImpl();

    public void run() throws IOException {
        boolean running = true;
        int choice;

        while (running) {
            choice = getMenuChoice();

            switch (choice) {
                case 1 -> createDVD();
                case 2 -> removeDVD();
                case 3 -> editDVD();
                case 4 -> displayDVDList();
                case 5 -> displayDVDinfo();
                case 6 -> searchForDVD();
                case 7 -> loadFromFile();
                case 8 -> {
                    writeToFile();
                    running = false;
                }

            }

        }
        io.println("Exiting...");

    }

    private int getMenuChoice() {
        return view.menuChoice();
    }

    private void createDVD() {
        view.addDVDBanner();
        DVD dvd = view.getNewDVDInfo();
        dao.addDVD(dvd);
    }

    private void removeDVD() {
        view.removeDVDBanner();
        String title = view.getDVDName();
        DVD dvd = dao.searchDVD(title);
        dao.removeDVD(dvd);
    }

    private void displayDVDList() {
        view.listDVDsBanner();
        Map<String, DVD> dvds = dao.displayDVDList();
        view.displayDVDList(dvds);
    }

    private void editDVD() {
        String title = view.getDVDName();
        DVD dvd = dao.searchDVD(title);
        int choice = view.editCategoryChoice();
        String value = view.getValueGeneric();
        dao.editDVD(dvd, choice, value);
    }

    private void displayDVDinfo() {
        String title = view.getDVDName();
        DVD dvd = dao.searchDVD(title);
        view.displayDVDInfo(dvd);
    }

    private void searchForDVD() {
        String title = view.getDVDName();
        DVD dvd = dao.searchDVD(title);
        view.displayDVDInfo(dvd);
    }

    private void loadFromFile() throws FileNotFoundException {
        boolean okay = false;
        do {
            String file = view.getFile();
            okay = dao.loadLibFile(file);
            if (!okay) {
                view.writeString("File not found.");
            }
        } while (!okay);
        view.loadFromFile();
    }

    private void writeToFile() throws IOException {
        String file = view.getFileToWrite();
        dao.saveLibFile(file);
        view.saveToFile();
    }


}
