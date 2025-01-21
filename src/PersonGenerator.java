import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> persons = new ArrayList<>();

        boolean morePersons = true;
        while (morePersons) {
            // Collecting data for each person
            String id = SafeInput.getNonZeroLenString(scanner, "Enter ID");
            String firstName = SafeInput.getNonZeroLenString(scanner, "Enter First Name");
            String lastName = SafeInput.getNonZeroLenString(scanner, "Enter Last Name");
            String title = SafeInput.getNonZeroLenString(scanner, "Enter Title");
            int yearOfBirth = SafeInput.getInt(scanner, "Enter Year of Birth");

            // Add the person's data in a CSV-friendly format
            persons.add(String.format("%s, %s, %s, %s, %d", id, firstName, lastName, title, yearOfBirth));

            // Ask if user wants to enter another person
            System.out.print("Do you want to enter another person? (y/n): ");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("y")) {
                morePersons = false;
            }
        }

        // Save the collected data to a CSV file
        try {
            System.out.print("Enter the file name to save the data (e.g., persons.csv): ");
            String fileName = scanner.nextLine();
            try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
                // Print formatted header for CSV
                out.println("ID, First Name, Last Name, Title, Year of Birth");
                for (String person : persons) {
                    out.println(person);
                }
            }
            System.out.println("Data saved to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

        scanner.close();
    }
}