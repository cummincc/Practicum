public class Product {
    private String id;
    private String name;
    private String description;
    private double cost;  // Store cost as a double

    // Constructor that accepts a double for the cost
    public Product(String id, String name, String description, double cost) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;  // Use the double value for cost
    }

    // Getter methods
    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;  // Return cost as a double
    }

    // Method to return product details as CSV (cost converted to string format)
    public String toCSVRecord() {
        // Return the cost as a plain number without the "$" symbol
        return id + ", " + name + ", " + description + ", " + cost;
    }
}