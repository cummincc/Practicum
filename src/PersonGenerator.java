import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> persons = new ArrayList<>();

        boolean morePersons = true;
        while (morePersons) {
            String id = SafeInput.getNonZeroLenString(scanner, "Enter ID");
            String firstName = SafeInput.getNonZeroLenString(scanner, "Enter First Name");
            String lastName = SafeInput.getNonZeroLenString(scanner, "Enter Last Name");
            String title = SafeInput.getNonZeroLenString(scanner, "Enter Title");
            int yearOfBirth = SafeInput.getInt(scanner, "Enter Year of Birth");

            persons.add(id + ", " + firstName + ", " + lastName + ", " + title + ", " + yearOfBirth);

            System.out.print("Do you want to enter another person? (y/n): ");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("y")) {
                morePersons = false;
            }
        }

        // Save the data to a file
        try {
            System.out.print("Enter the file name to save the data: ");
            String fileName = scanner.nextLine();
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
            for (String person : persons) {
                out.println(person);
            }
            out.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        }

        scanner.close();
    }
}