import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class ProductReader {

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
            ArrayList<Product> products = new ArrayList<>();

            // Display header with appropriate formatting for CSV columns
            System.out.printf("%-10s %-20s %-30s %-10s%n", "ID", "Product Name", "Product Description", "Cost");
            System.out.println("------------------------------------------------------------");

            // Read and process each line from the file
            while (fileScanner.hasNextLine()) {
                String[] productData = fileScanner.nextLine().split(",\\s*");

                if (productData.length == 4) {
                    String id = productData[0];
                    String name = productData[1];
                    String description = productData[2];
                    String costString = productData[3];

                    try {
                        double cost = Double.parseDouble(costString);
                        Product product = new Product(id, name, description, cost);
                        products.add(product);

                        System.out.printf("%-10s %-20s %-30s $%-10.2f%n", id, name, description, cost);
                    } catch (NumberFormatException e) {
                        System.out.printf("%-10s %-20s %-30s %-10s%n", id, name, description, "Valid cost");
                    }
                } else {
                    System.out.println("Invalid data format in line: " + String.join(", ", productData));
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
}
