package com.leszeknowinski.Order;

public class OrderHelper {
    public double calculateOrderPrice(double distance, String cargoType){
        double pricePerKm = 0.0;
        if(cargoType.equals("Cargo")) {
            pricePerKm = 2.5;
        }else if(cargoType.equals("Package")){
            pricePerKm = 2.0;
        }else if(cargoType.equals("People")){
            pricePerKm = 1.5;
        }
        return distance*pricePerKm;
        }

}
