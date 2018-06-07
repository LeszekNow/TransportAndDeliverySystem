package com.leszeknowinski.Vehicle;

public class Bus extends Car {
    private int places;

    public Bus(String brand, String model, String colour, int mileage, int engineCapacity,
               double fuelConsumption, String vin, String registrationNumber, int places, VehicleType vehicleType, boolean arrested) {
        super(brand, model, colour, mileage, engineCapacity, fuelConsumption, vin, registrationNumber, vehicleType, arrested);
        this.places = places;
    }

    public Bus(int id, String brand, String model, String colour, int mileage, int engineCapacity,
               double fuelConsumption, String vin, String registrationNumber, int places, VehicleType vehicleType, boolean arrested, String inspectionDate) {
        super(id, brand, model, colour, mileage, engineCapacity, fuelConsumption, vin, registrationNumber, vehicleType, arrested, inspectionDate);
        this.places = places;
    }


    public Bus(){}

    public void setPlaces(int places) {
        this.places = places;
    }

    public int getPlaces() {
        return places;
    }

    @Override
    public String toString() {

        return super.toString() + ", places - " + places + ".";
    }
}
