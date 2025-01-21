import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductWriter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> products = new ArrayList<>();

        boolean moreInput = true;

        while (moreInput) {
            System.out.println("Enter product details:");

            String id = SafeInput.getNonZeroLenString(scanner, "Enter ID");
            String name = SafeInput.getNonZeroLenString(scanner, "Enter Product Name");
            String description = SafeInput.getNonZeroLenString(scanner, "Enter Product Description");
            double cost = SafeInput.getDouble(scanner, "Enter Product Cost");

            String productRecord = String.format("%s, %s, %s, %.2f", id, name, description, cost);
            products.add(productRecord);

            moreInput = SafeInput.getYNConfirm(scanner, "Do you want to add another product?");
        }

        String fileName = "ProductTestData.txt"; // You can change this to ask the user for a file name
        saveToFile(products, fileName);
    }

    private static void saveToFile(ArrayList<String> data, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (String record : data) {
                writer.write(record + "\n");
            }
            System.out.println("Product data saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }
}