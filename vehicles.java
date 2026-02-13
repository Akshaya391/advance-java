// Base class demonstrating encapsulation
public class Vehicle {
    // Private fields (encapsulation)
    private String brand;
    private String model;
    private int year;
    private double price;
    
    // Constructor
    public Vehicle(String brand, String model, int year, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
    }
    
    // Getters and Setters
    public String getBrand() {
        return brand;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public int getYear() {
        return year;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    // Method that can be overridden (polymorphism)
    public void displayInfo() {
        System.out.println("\n=== Vehicle Information ===");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Price: $" + String.format("%.2f", price));
    }
    
    // Method to demonstrate behavior
    public void start() {
        System.out.println("The vehicle is starting...");
    }
    
    // Method to calculate depreciation
    public double calculateDepreciation(int currentYear) {
        int age = currentYear - year;
        double depreciationRate = 0.15; // 15% per year
        double currentValue = price * Math.pow(1 - depreciationRate, age);
        return Math.max(currentValue, price * 0.1); // Minimum 10% of original price
    }
}