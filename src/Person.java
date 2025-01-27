import java.util.Calendar;

public class Person {
    private String firstName;
    private String lastName;
    private String ID;
    private String title;
    private int yearOfBirth;

    // Constructors
    public Person(String firstName, String lastName, String ID, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        this.yearOfBirth = YOB;
    }

    public String fullName() {
        return firstName + " " + lastName;
    }

    public String formalName() {
        return title + " " + fullName();
    }

    public String getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return String.valueOf(currentYear - yearOfBirth);
    }

    public String getAge(int year) {
        return String.valueOf(year - yearOfBirth);
    }

    // Method to return a CSV record
    public String toCSVRecord() {
        // Make sure the order matches the test expectation
        return ID + ", " + firstName + ", " + lastName + ", " + title + ", " + yearOfBirth;
    }
}

