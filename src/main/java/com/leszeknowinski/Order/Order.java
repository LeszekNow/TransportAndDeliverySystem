package com.leszeknowinski.Order;

import com.leszeknowinski.User.CustomerType;
import com.leszeknowinski.Vehicle.VehicleType;

import java.util.Date;

public class Order {
    private int id;
    private String cargoType;
    private String vehicleType;
    private int vehicleId;
    private int cargoAmount;
    private int customerId;
    private String customerType;
    private String startPoint;
    private String endPoint;
    private double distance;
    private Date startDate;
    private boolean completed;
    private boolean inProgress;
    private int driverId;

    public Order(int id, String cargoType, String vehicleType, int vehicleId, int cargoAmount, int customerId, String customerType, String startPoint, String endPoint, double distance, Date startDate, boolean completed, boolean inProgress, int driverId) {
        this.id = id;
        this.cargoType = cargoType;
        this.vehicleType = vehicleType;
        this.vehicleId = vehicleId;
        this.cargoAmount = cargoAmount;
        this.customerId = customerId;
        this.customerType = customerType;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.distance = distance;
        this.startDate = startDate;
        this.completed = completed;
        this.driverId = driverId;
        this.inProgress = inProgress;
    }

    public Order(String cargoType, String vehicleType, int vehicleId, int cargoAmount, int customerId, String customerType, String startPoint, String endPoint, double distance, Date startDate, boolean completed, boolean inProgress, int driverId) {
        this.cargoType = cargoType;
        this.vehicleType = vehicleType;
        this.vehicleId = vehicleId;
        this.cargoAmount = cargoAmount;
        this.customerId = customerId;
        this.customerType = customerType;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.distance = distance;
        this.startDate = startDate;
        this.completed = completed;
        this.driverId = driverId;
        this.inProgress = inProgress;
    }

    public Order(String cargoType, String vehicleType, int vehicleId, int cargoAmount, int customerId, String customerType, String startPoint, String endPoint, double distance, boolean completed, boolean inProgress, int driverId) {
        this.cargoType = cargoType;
        this.vehicleType = vehicleType;
        this.vehicleId = vehicleId;
        this.cargoAmount = cargoAmount;
        this.customerId = customerId;
        this.customerType = customerType;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.distance = distance;
        this.completed = completed;
        this.driverId = driverId;
        this.inProgress = inProgress;
    }

    public Order(){}


    public boolean getInProgress() {
        return inProgress;
    }

    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    public int getCargoAmount() {
        return cargoAmount;
    }

    public void setCargoAmount(int cargoAmount) {
        this.cargoAmount = cargoAmount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;

    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "Order: Id: " + id + ", Cargo type: " + cargoType + ", Cargo amount: " + cargoAmount + ", Customer id: " + customerId +
                ", Customer type: " + customerType + ", Start point: " + startPoint + ", End point: " + endPoint + ", Distance in km: " + distance +
                ", Start date: " + startDate + ", completed: " + completed + ", progress: " + inProgress + ", Driver id: " + driverId + ".";
    }

    public String toString2() {
        return "Order: Id: " + id + ", Cargo type: " + cargoType + ", Cargo amount: " + cargoAmount + ", Start point: " + startPoint + ", Destination point: " + endPoint + ", Distance: " + distance +
                "km, Start date: " + startDate + ", completed: " + completed + ", progress: " + inProgress + ", Driver id: " + driverId + ".";
    }
}

    //during making an order using cargo characteristic car is assigned by cargo type - truck or delivery car
    //if people than bus or ordinary car.

    //DB for different users different tables or the same table with sth what differentiates types of users

