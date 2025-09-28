class Car extends Vehicle {
    int seats;

    Car(String brand, double pricePerDay, int seats) {
        super(brand, pricePerDay);
        this.seats = seats;
    }

    @Override
    double calculateRentalCost(int days) {
        return getPricePerDay() * days;
    }
}