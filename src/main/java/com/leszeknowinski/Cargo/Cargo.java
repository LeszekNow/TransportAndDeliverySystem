package com.leszeknowinski.Cargo;

public class Cargo {
    private int id;
    private int customerId;
    private int vehicleId;
    private String cargoType;
    private int amount;
    private int cargoLength;
    private int cargoHeight;
    private int cargoWidth;
    private int cargoWeight;

    public Cargo(int id, int customerId, int vehicleId, String cargoType, int amount, int cargoLength, int cargoHeight, int cargoWidth, int cargoWeight) {
        this.id = id;
        this.customerId = customerId;
        this.vehicleId = vehicleId;
        this.cargoType = cargoType;
        this.amount = amount;
        this.cargoLength = cargoLength;
        this.cargoHeight = cargoHeight;
        this.cargoWidth = cargoWidth;
        this.cargoWeight = cargoWeight;
    }

    public Cargo(int customerId, int vehicleId, String cargoType, int amount, int cargoLength, int cargoHeight, int cargoWidth, int cargoWeight) {
        this.customerId = customerId;
        this.vehicleId = vehicleId;
        this.cargoType = cargoType;
        this.amount = amount;
        this.cargoLength = cargoLength;
        this.cargoHeight = cargoHeight;
        this.cargoWidth = cargoWidth;
        this.cargoWeight = cargoWeight;
        CargoRepository.cargoList.add(this);
    }

    public Cargo(int customerId, int vehicleId, String cargoType, int amount){
        this.customerId = customerId;
        this.vehicleId = vehicleId;
        this.cargoType = cargoType;
        this.amount = amount;
    }

    public Cargo(int customerId, int vehicleId, String cargoType, int amount, int cargoWeight){
        this.customerId = customerId;
        this.vehicleId = vehicleId;
        this.cargoType = cargoType;
        this.amount = amount;
        this.cargoWeight = cargoWeight;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setCargoLength(int cargoLength) {
        this.cargoLength = cargoLength;
    }

    public void setCargoHeight(int cargoHeight) {
        this.cargoHeight = cargoHeight;
    }

    public void setCargoWidth(int cargoWidth) {
        this.cargoWidth = cargoWidth;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public String getCargoType() {
        return cargoType;
    }

    public int getCargoLength() {
        return cargoLength;
    }

    public int getCargoHeight() {
        return cargoHeight;
    }

    public int getCargoWidth() {
        return cargoWidth;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }


    @Override
    public String toString() {
        return "Cargo: type - " + cargoType + ", size in cm (Length x Height x Width) - "
                + cargoLength + " X " + cargoHeight + " X " + cargoWidth +
                ", weight in kg - " + cargoWeight + ", vehicle id - " + vehicleId + ", customer id - " + customerId +".";

    }
}
