package com.leszeknowinski.Order;

import com.leszeknowinski.Cargo.CargoType;
import com.leszeknowinski.DataBaseSupport.DBHandler;

public class OrderHelper {
    DBHandler dbHandler = new DBHandler();
    public double calculateOrderPrice(double distance, CargoType cargoType){
        double pricePerKm = 0.0;
        if(cargoType.equals(CargoType.CARGO)) {
            pricePerKm = dbHandler.getDoubleFromDB("SELECT price FROM tservice WHERE category = 'cargo';", "price");
        }else if(cargoType.equals(CargoType.PACKAGE)){
            pricePerKm = dbHandler.getDoubleFromDB("SELECT price FROM tservice WHERE category = 'package';", "price");;
        }else if(cargoType.equals(CargoType.PEOPLE)){
            pricePerKm = dbHandler.getDoubleFromDB("SELECT price FROM tservice WHERE category = 'people';", "price");;
        }
        return distance*pricePerKm;
        }

}
