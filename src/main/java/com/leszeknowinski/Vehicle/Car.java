package com.leszeknowinski.Vehicle;

public class Car {
    private int id;
    private String brand;
    private String model;
    private String colour;
    private int mileage;
    private int engineCapacity;
    private double fuelConsumption;
    private String vin;
    private String registrationNumber;
    private VehicleType vehicleType;
    private boolean arrested;
    private String inspectionDate;

    public Car(String brand, String model, String colour, int mileage, int engineCapacity,
               double fuelConsumption, String vin, String registrationNumber, VehicleType vehicleType, boolean arrested) {
        this.brand = brand;
        this.model = model;
        this.colour = colour;
        this.mileage = mileage;
        this.engineCapacity = engineCapacity;
        this.fuelConsumption = fuelConsumption;
        this.vin = vin;
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
        this.arrested = arrested;
        VehicleRepository.vehiclesList.add(this);
    }

    public Car(int id, String brand, String model, String colour, int mileage, int engineCapacity,
               double fuelConsumption, String vin, String registrationNumber, VehicleType vehicleType, boolean arrested, String inspectionDate){
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.colour = colour;
        this.mileage = mileage;
        this.engineCapacity = engineCapacity;
        this.fuelConsumption = fuelConsumption;
        this.vin = vin;
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
        this.arrested = arrested;
        this.inspectionDate = inspectionDate;
    }

    public Car(){
    }

    public boolean isArrested() {
        return arrested;
    }

    public void setArrested(boolean arrested) {
        this.arrested = arrested;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getMileage() {
        return mileage;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColour() {
        return colour;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public String getVin() {
        return vin;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(String inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

    @Override
    public String toString() {
        return "Vehicle id - " + id + ": " + brand + " " + model + ", mileage: " + mileage + ", registration number: " + registrationNumber + " " + colour + ". Vehicle type:  " + vehicleType;
                   }
}
