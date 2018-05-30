package com.leszeknowinski.Vehicle;

public class Motorcycle extends Car {
    private int maxPackageWeight;

    public Motorcycle(String brand, String model, String colour, int mileage, int engineCapacity,
                      double fuelConsumption, String vin, String registrationNumber, int maxPackageWeight, String vehicleType, boolean arrested) {
        super(brand, model, colour, mileage, engineCapacity, fuelConsumption, vin, registrationNumber, vehicleType, arrested);
        this.maxPackageWeight = maxPackageWeight;
    }

    public Motorcycle(int id, String brand, String model, String colour, int mileage, int engineCapacity,
                      double fuelConsumption, String vin, String registrationNumber, int maxPackageWeight, String vehicleType, boolean arrested, String inspectionDate) {
        super(id, brand, model, colour, mileage, engineCapacity, fuelConsumption, vin, registrationNumber, vehicleType, arrested, inspectionDate);
        this.maxPackageWeight = maxPackageWeight;
    }

    public Motorcycle(VehicleDataWrapper vehicleDataWrapper, int maxPackageWeight) {
        super(vehicleDataWrapper);
        this.maxPackageWeight = maxPackageWeight;
    }

    public Motorcycle() {
    }

    public void setMaxPackageWeight(int maxPackageWeight) {
        this.maxPackageWeight = maxPackageWeight;
    }

    public int getMaxPackageWeight() {
        return maxPackageWeight;
    }

    @Override
    public String toString() {

        return super.toString() + " Max Package Weight - " + maxPackageWeight + " kg.";
    }
}
