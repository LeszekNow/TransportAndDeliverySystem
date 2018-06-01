package com.leszeknowinski.service;

public class Service {
    private int id;
    private String category;
    private String description;
    private double priceKM;

    public Service(int id, String category, String description, double priceKM) {
        this.id = id;
        this.description = description;
        this.priceKM = priceKM;
        this.category = category;
    }

    public Service(String category, String description, double priceKM){
        this.description = description;
        this.priceKM = priceKM;
        this.category = category;
    }

    public Service(){}

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
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
