import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("Person.csv");

        ArrayList<Person> personList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of persons:");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter person " + (i + 1) + " details (ID, First Name, Last Name, Title, Year of Birth):");
            String id = scanner.next();     // Get ID from user
            String firstName = scanner.next(); // Get First Name from user
            String lastName = scanner.next();  // Get Last Name from user
            String title = scanner.next();    // Get Title from user
            int yob = scanner.nextInt();      // Get Year of Birth

            Person person = new Person(id, firstName, lastName, title, yob);

            personList.add(person);
        }

        for (Person person : personList) {
            String personData = person.toCSVRecord();
            fw.write(personData);
            fw.write(System.lineSeparator());
        }

        System.out.println("Persons' data has been saved to 'Person.csv'.");

        fw.close();

        scanner.close();
    }
}