package com.leszeknowinski.Order;

import com.leszeknowinski.DataBaseSupport.DBHandler;

public class OrderHelper {
    DBHandler dbHandler = new DBHandler();
    public double calculateOrderPrice(double distance, String cargoType){
        double pricePerKm = 0.0;
        if(cargoType.equals("cargo")) {
            pricePerKm = dbHandler.getDoubleFromDB("SELECT price FROM tservice WHERE category = 'cargo';", "price");
        }else if(cargoType.equals("package")){
            pricePerKm = dbHandler.getDoubleFromDB("SELECT price FROM tservice WHERE category = 'package';", "price");;
        }else if(cargoType.equals("people")){
            pricePerKm = dbHandler.getDoubleFromDB("SELECT price FROM tservice WHERE category = 'people';", "price");;
        }
        return distance*pricePerKm;
        }

}
