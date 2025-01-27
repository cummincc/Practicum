import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PersonReader {

    public static void main(String[] args) {
        String fileName = "PersonData.csv";
        displayFileContents(fileName);
    }

    public static void displayFileContents(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            // Skip the header line
            String line = reader.readLine();  // Read header

            // Now read the actual data lines
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(", ");

                // Ensure the data contains enough fields
                if (data.length == 5) {
                    String firstName = data[0];
                    String lastName = data[1];
                    String id = data[2];
                    String title = data[3];
                    int yob = Integer.parseInt(data[4]); // Parse year of birth

                    System.out.printf("%-10s %-15s %-15s %-10s %d\n", id, firstName, lastName, title, yob);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing number: " + e.getMessage());
        }
    }
}