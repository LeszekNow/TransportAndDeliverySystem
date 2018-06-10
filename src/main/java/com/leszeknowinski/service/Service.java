package com.leszeknowinski.service;

import com.leszeknowinski.Cargo.CargoType;

public class Service {
    private int id;
    private CargoType category;
    private String description;
    private double priceKM;

    public Service(int id, CargoType category, String description, double priceKM) {
        this.id = id;
        this.description = description;
        this.priceKM = priceKM;
        this.category = category;
    }

    public Service(CargoType category, String description, double priceKM){
        this.description = description;
        this.priceKM = priceKM;
        this.category = category;
    }

    public Service(){}

    public CargoType getCategory() {
        return category;
    }

    public void setCategory(CargoType category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPriceKM() {
        return priceKM;
    }

    public void setPriceKM(double priceKM) {
        this.priceKM = priceKM;
    }

    @Override
    public String toString() {
        return "Service id: " + id + "/ Category: " + category + "/ Cargo type: " + description + "/ Price - " + priceKM + " PLN/km \n";

    }
}
