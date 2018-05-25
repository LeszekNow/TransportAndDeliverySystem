package com.leszeknowinski.GPS;

import com.leszeknowinski.DataBaseSupport.DBHandler;

import java.util.Random;

public class GPSRandomDataGenerator {

    GeoHelper geoHelper = new GeoHelper();
    DBHandler dbHandler = new DBHandler();

    public int getRandomIdOfLocation(){
        return dbHandler.getSthIdFromDB("SELECT id FROM tlocation ORDER BY RAND() LIMIT 1;");
    }

    public double getLongitude(int locationId){
        return geoHelper.getDoubleFromDB("SELECT longitude FROM tlocation WHERE id = " + locationId + ";", "longitude");
    }

    public double getLatitude(int locationId){
        return geoHelper.getDoubleFromDB("SELECT latitude FROM tlocation WHERE id = " + locationId + ";", "latitude");
    }
}
