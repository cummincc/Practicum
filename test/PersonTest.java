import org.junit.Test;
import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void testFullName() {
        // Create a Person object with yearOfBirth as an integer (2002)
        Person person = new Person("Casey", "Cummings", "000001", "Miss", 2002);
        // Test the fullName() method
        assertEquals("Casey Cummings", person.fullName());
    }

    @Test
    public void testFormalName() {
        // Create a Person object with yearOfBirth as an integer (2002)
        Person person = new Person("Casey", "Cummings", "000001", "Miss", 2002);
        // Test the formalName() method
        assertEquals("Miss Casey Cummings", person.formalName());
    }

    @Test
    public void testGetAge() {
        // Create a Person object with yearOfBirth as an integer (2002)
        Person person = new Person("Casey", "Cummings", "000001", "Miss", 2002);
        // Test the getAge() method for the current year (assuming 2025)
        String expectedAge = "23"; // Expected age assuming the year 2025
        assertEquals("Age should be 23 in 2025", expectedAge, person.getAge());
    }

    @Test
    public void testGetAgeWithYear() {
        // Create a Person object with yearOfBirth as an integer (1990)
        Person person = new Person("John", "Doe", "123456", "Mr.", 1990);
        // Test the getAge(int year) method for a specific year (e.g., 2033)
        String expectedAge = "43"; // Expected age in 2033
        assertEquals("Age should be 43 in 2033", expectedAge, person.getAge(2033));
    }

    @Test
    public void testToCSVDataRecord() {
        // Create a Person object with yearOfBirth as an integer (1990)
        Person person = new Person("John", "Doe", "123456", "Mr.", 1990);
        // Test the toCSVDataRecord() method to ensure the correct CSV format
        String expectedCSV = "123456, John, Doe, Mr., 1990";
        assertEquals("CSV format should match the expected format", expectedCSV, person.toCSVRecord());
    }
}