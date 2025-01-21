import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class PersonReader {

    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            displayFileContents(selectedFile);
        } else {
            System.out.println("No file selected.");
        }
    }

    private static void displayFileContents(File file) {
        try (Scanner fileScanner = new Scanner(file)) {
            // Print header for the formatted table
            System.out.printf("%-10s %-15s %-15s %-10s %-4s\n", "ID", "First Name", "Last Name", "Title", "Year of Birth");
            System.out.println("==============================================================");

            // Process each line from the CSV file and display formatted data
            while (fileScanner.hasNextLine()) {
                String[] personData = fileScanner.nextLine().split(",\\s*"); // Split based on comma and optional space
                if (personData.length == 5) {
                    System.out.printf("%-10s %-15s %-15s %-10s %-4s\n",
                            personData[0], personData[1], personData[2], personData[3], personData[4]);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
}