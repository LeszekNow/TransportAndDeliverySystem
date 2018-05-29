package com.leszeknowinski.Order;

public class OrderHelper {
    public double calculateOrderPrice(double distance, String cargoType){
        double pricePerKm = 0.0;
        if(cargoType.equals("cargo")) {
            pricePerKm = 2.5;
        }else if(cargoType.equals("package")){
            pricePerKm = 2.0;
        }else if(cargoType.equals("people")){
            pricePerKm = 1.5;
        }
        return distance*pricePerKm;
        }

}
