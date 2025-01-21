import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class ProductReader {

    public static void main(String[] args) {
        // Create a JFileChooser to allow user to select a file
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);

        // If the user selects a file, display its contents
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            displayFileContents(selectedFile);
        } else {
            System.out.println("No file selected.");
        }
    }

    private static void displayFileContents(File file) {
        try (Scanner fileScanner = new Scanner(file)) {
            // Display header with appropriate formatting
            System.out.println(String.format("%-10s %-20s %-30s %-10s", "ID", "Name", "Description", "Cost"));
            System.out.println("------------------------------------------------------------");

            // Read and process each line from the file
            while (fileScanner.hasNextLine()) {
                String[] productData = fileScanner.nextLine().split(",\\s*");

                // Parse and display the product details
                String id = productData[0];
                String name = productData[1];
                String description = productData[2];
                String costString = productData[3];

                // Try parsing the cost and handle possible errors
                try {
                    double cost = Double.parseDouble(costString);
                    System.out.println(String.format("%-10s %-20s %-30s $%-10.2f", id, name, description, cost));
                } catch (NumberFormatException e) {
                    // If cost is not a valid number, print an error message
                    System.out.println(String.format("%-10s %-20s %-30s %-10s", id, name, description, "Invalid cost"));
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
}