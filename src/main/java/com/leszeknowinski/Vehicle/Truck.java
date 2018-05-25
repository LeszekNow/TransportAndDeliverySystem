package com.leszeknowinski.Vehicle;

public class Truck extends Car {

    public Truck(String brand, String model, String colour, int mileage, int engineCapacity,
                 double fuelConsumption, String vin, String registrationNumber, String vehicleType, boolean arrested) {
        super(brand, model, colour, mileage, engineCapacity, fuelConsumption, vin, registrationNumber, vehicleType, arrested);
        VehicleRepository.vehiclesList.add(this);
    }

    public Truck(int id, String brand, String model, String colour, int mileage, int engineCapacity,
                 double fuelConsumption, String vin, String registrationNumber, String vehicleType, boolean arrested) {
        super(id, brand, model, colour, mileage, engineCapacity, fuelConsumption, vin, registrationNumber, vehicleType, arrested);
    }

    public Truck(VehicleDataWrapper vehicleDataWrapper) {
        super(vehicleDataWrapper);
    }

    public Truck(){}

    @Override
    public String toString() {

        return super.toString();
    }
    //The truc is choosen when cargo size exeeds cargo size possible to carry by deliverycar or weight is
}
