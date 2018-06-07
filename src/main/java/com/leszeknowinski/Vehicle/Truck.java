package com.leszeknowinski.Vehicle;

public class Truck extends Car {

    public Truck(String brand, String model, String colour, int mileage, int engineCapacity,
                 double fuelConsumption, String vin, String registrationNumber, VehicleType vehicleType, boolean arrested) {
        super(brand, model, colour, mileage, engineCapacity, fuelConsumption, vin, registrationNumber, vehicleType, arrested);
        VehicleRepository.vehiclesList.add(this);
    }

    public Truck(int id, String brand, String model, String colour, int mileage, int engineCapacity,
                 double fuelConsumption, String vin, String registrationNumber, VehicleType vehicleType, boolean arrested, String inspectionDate) {
        super(id, brand, model, colour, mileage, engineCapacity, fuelConsumption, vin, registrationNumber, vehicleType, arrested, inspectionDate);
    }


    public Truck(){}

    @Override
    public String toString() {

        return super.toString();
    }
}
