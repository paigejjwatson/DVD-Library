import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class UserIOImpl implements UserIO {

    final private Scanner console = new Scanner(System.in);

    @Override
    public void println(String msg) {
        System.out.println(msg);
    }

    public void printf(String msg) {
        System.out.printf(msg);
    }

    @Override
    public LocalDate readDate(String prompt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            try {
                return LocalDate.parse(this.readString(prompt), formatter);
            } catch (DateTimeParseException e) {
                this.println("Invalid format. Please enter the date again.");
            }
        }
    }

    @Override
    public double readDouble(String prompt) {
        while (true) {
            try {
                // parse double from string
                return Double.parseDouble(this.readString(prompt));
            } catch (NumberFormatException e) {
                this.println("Input is not valid. Please try again!");
            }
        }
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double result;
        do {
            result = readDouble(prompt);
        } while ( result < min || result > max );
        return result;
    }

    @Override
    public float readFloat(String prompt) {
        while (true) {
            try {
                // parse float from string
                return Float.parseFloat(this.readString(prompt));
            } catch (NumberFormatException e) {
                this.println("Input is not valid. Please try again!");
            }
        }
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float result;
        do {
            result = readFloat(prompt);
        } while ( result < min || result > max );
        return result;
    }

    @Override
    public int readInt(String prompt) {
        while (true) {
            try {
                return Integer.parseInt(this.readString(prompt));
            } catch (NumberFormatException e) {
                this.println("Input is not valid. Please try again!");
            }
        }
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int result;
        do {
            result = readInt(prompt);
        } while ( result < min || result > max );
        return result;
    }

    @Override
    public long readLong(String prompt) {
        while (true) {
            try {
                return Long.parseLong(this.readString(prompt));
            } catch (NumberFormatException e) {
                this.println("Input is not valid. Please try again!");
            }
        }
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long result;
        do {
            result = readLong(prompt);
        } while ( result < min || result > max );
        return result;
    }

    @Override
    public String readString(String prompt) {
        System.out.printf(prompt);
        return console.nextLine();
    }
}
