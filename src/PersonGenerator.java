import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Person> persons = new ArrayList<>();

        boolean morePersons = true;
        while (morePersons) {
            String id = SafeInput.getNonZeroLenString(scanner, "Enter ID");
            String firstName = SafeInput.getNonZeroLenString(scanner, "Enter First Name");
            String lastName = SafeInput.getNonZeroLenString(scanner, "Enter Last Name");
            String title = SafeInput.getNonZeroLenString(scanner, "Enter Title");
            int yearOfBirth = SafeInput.getInt(scanner, "Enter Year of Birth");

            // Create person object and add it to the ArrayList
            Person person = new Person(id, firstName, lastName, title, yearOfBirth);
            persons.add(person);

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
                for (Person person : persons) {
                    out.println(person.toCSVRecord());
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