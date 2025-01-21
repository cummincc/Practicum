import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class PersonReader {

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
            System.out.println(String.format("%-10s %-15s %-15s %-10s %-4s", "ID#", "Firstname", "Lastname", "Title", "YOB"));
            System.out.println("===========================================================");

            while (fileScanner.hasNextLine()) {
                String[] personData = fileScanner.nextLine().split(",\\s*");
                System.out.println(String.format("%-10s %-15s %-15s %-10s %-4s",
                        personData[0], personData[1], personData[2], personData[3], personData[4]));
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
}