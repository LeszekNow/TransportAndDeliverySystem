package com.leszeknowinski.Vehicle;

public class Van extends Car {
    private int maxCargoHeight;
    private int maxCargoLength;
    private int maxCargoWidth;
    private int maxCargoWeight;

    public Van(String brand, String model, String colour, int mileage, int engineCapacity,
               double fuelConsumption, String vin, String registrationNumber,
               int maxCargoHeight, int maxCargoLength, int maxCargoWidth, int maxCargoWeight, String vehicleType, boolean arrested) {
        super(brand, model, colour, mileage, engineCapacity, fuelConsumption, vin, registrationNumber, vehicleType, arrested);
        this.maxCargoHeight = maxCargoHeight;
        this.maxCargoLength = maxCargoLength;
        this.maxCargoWidth = maxCargoWidth;
        this.maxCargoWeight = maxCargoWeight;
        VehicleRepository.vehiclesList.add(this);
    }

    public Van(int id, String brand, String model, String colour, int mileage, int engineCapacity,
               double fuelConsumption, String vin, String registrationNumber,
               int maxCargoHeight, int maxCargoLength, int maxCargoWidth, int maxCargoWeight, String vehicleType, boolean arrested, String inspectionDate) {
        super(id, brand, model, colour, mileage, engineCapacity, fuelConsumption, vin, registrationNumber, vehicleType, arrested, inspectionDate);
        this.maxCargoHeight = maxCargoHeight;
        this.maxCargoLength = maxCargoLength;
        this.maxCargoWidth = maxCargoWidth;
        this.maxCargoWeight = maxCargoWeight;
    }

    public Van(VehicleDataWrapper vehicleDataWrapper, int maxCargoHeight, int maxCargoLength,
               int maxCargoWidth, int maxCargoWeight) {
        super(vehicleDataWrapper);
        this.maxCargoHeight = maxCargoHeight;
        this.maxCargoLength = maxCargoLength;
        this.maxCargoWidth = maxCargoWidth;
        this.maxCargoWeight = maxCargoWeight;
    }

    public Van(){}

    public void setMaxCargoHeight(int maxCargoHeight) {
        this.maxCargoHeight = maxCargoHeight;
    }

    public void setMaxCargoLength(int maxCargoLength) {
        this.maxCargoLength = maxCargoLength;
    }

    public void setMaxCargoWidth(int maxCargoWidth) {
        this.maxCargoWidth = maxCargoWidth;
    }

    public void setMaxCargoWeight(int maxCargoWeight) {
        this.maxCargoWeight = maxCargoWeight;
    }

    public int getMaxCargoHeight() {
        return maxCargoHeight;
    }

    public int getMaxCargoLength() {
        return maxCargoLength;
    }

    public int getMaxCargoWidth() {
        return maxCargoWidth;
    }

    public int getMaxCargoWeight() {
        return maxCargoWeight;
    }

    @Override
    public String toString() {
        return super.toString() + ", Max com.leszeknowinski.Cargo Size in cm - Height/Length/Width - " + maxCargoHeight +
                "/" + maxCargoLength + "/" + maxCargoWidth + " and Max com.leszeknowinski.Cargo Weight - " + maxCargoWeight + " kg.";
    }

}
