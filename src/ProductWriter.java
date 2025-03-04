import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductWriter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();

        boolean moreInput = true;

        while (moreInput) {
            // Collecting product details
            System.out.println("Enter product details:");

            String id = SafeInput.getNonZeroLenString(scanner, "Enter ID");
            String name = SafeInput.getNonZeroLenString(scanner, "Enter Product Name");
            String description = SafeInput.getNonZeroLenString(scanner, "Enter Product Description");
            double cost = SafeInput.getDouble(scanner, "Enter Product Cost");

            // Create a new Product object and add it to the list
            Product product = new Product(id, name, description, cost);
            products.add(product);

            // Ask if the user wants to add another product
            moreInput = SafeInput.getYNConfirm(scanner, "Do you want to add another product?");
        }

        // File name for saving the product data (could be dynamically set)
        String fileName = "ProductData.csv"; // You can change this to ask the user for a file name
        saveToFile(products, fileName);
    }

    private static void saveToFile(ArrayList<Product> products, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            // Writing a header to the CSV file
            writer.write("ID, Product Name, Product Description, Cost\n");

            // Write each product record
            for (Product product : products) {
                writer.write(product.toCSVRecord() + "\n");
            }

            System.out.println("Product data saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }
}