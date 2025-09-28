abstract class Vehicle {
    private String brand;
    private double pricePerDay;

    Vehicle(String brand, double pricePerDay) {
        this.brand = brand;
        this.pricePerDay = pricePerDay;
    }

    abstract double calculateRentalCost(int days);

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPricePerDay() {
        return this.pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    void displayInfo() {
        System.out.println("Brand: " + getBrand() + ", Price per Day: " + getPricePerDay());
    }
}