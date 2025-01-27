import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void testProductCreation() {
        // Create a Product object with cost as a double (converted from a string like "$300.00")
        Product product = new Product("000001", "Bronzer", "Tan Powder", 300.00);

        // Assert that the product cost is correctly set
        assertEquals(300.00, product.getCost(), 0.01);
    }

    @Test
    public void testProductToCSVRecord() {
        // Create a Product object with cost as a double
        Product product = new Product("000001", "Bronzer", "Tan Powder", 300.00);

        // Assert that the CSV representation of the product is correct
        assertEquals("000001, Bronzer, Tan Powder, 300.0", product.toCSVRecord());
    }

    @Test
    public void testProductName() {
        // Create a Product object
        Product product = new Product("000001", "Bronzer", "Tan Powder", 300.00);

        // Assert that the product name is correctly set
        assertEquals("Bronzer", product.getName());
    }

    @Test
    public void testProductDescription() {
        // Create a Product object
        Product product = new Product("000001", "Bronzer", "Tan Powder", 300.00);

        // Assert that the product description is correctly set
        assertEquals("Tan Powder", product.getDescription());
    }
}