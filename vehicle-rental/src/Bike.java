class Bike extends Vehicle {
    boolean hasHelmet;

    Bike(String brand, double pricePerDay, boolean hasHelmet) {
        super(brand, pricePerDay);
        this.hasHelmet = hasHelmet;
    }

    @Override
    double calculateRentalCost(int days) {
        return getPricePerDay() * days * (hasHelmet ? 1.0 : 1.1);
    }
}