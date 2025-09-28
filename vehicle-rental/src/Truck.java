class Truck extends Vehicle implements HeavyLoad {
    int loadCapacity;

    Truck(String brand, double pricePerDay, int loadCapacity) {
        super(brand, pricePerDay);
        this.loadCapacity = loadCapacity;
    }

    @Override
    double calculateRentalCost(int days) {
        return getPricePerDay() * days + (loadCapacity * 0.5);
    }

    @Override
    public boolean requiresSpecialLicense() {
        return loadCapacity > 1000;
    }
}