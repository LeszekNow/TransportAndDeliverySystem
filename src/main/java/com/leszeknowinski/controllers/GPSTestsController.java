package com.leszeknowinski.controllers;

import com.leszeknowinski.Cargo.Cargo;
import com.leszeknowinski.DataBaseSupport.DBCargoHelper;
import com.leszeknowinski.DataBaseSupport.DBHandler;
import com.leszeknowinski.DataBaseSupport.DBOrderHelper;
import com.leszeknowinski.GPS.GPSRandomDataGenerator;
import com.leszeknowinski.GPS.GeoHelper;
import com.leszeknowinski.GPS.Location;
import com.leszeknowinski.Order.Order;
import com.leszeknowinski.comparators.LatitudeComparator;
import com.leszeknowinski.comparators.LongitudeComparator;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;

public class GPSTestsController {


    @FXML
    TextField startPoint;

    @FXML
    TextField endPoint;

    @FXML
    TextField username;

    @FXML
    TextArea summary;

    @FXML
    Button submit;

    @FXML
    Button clear;

    @FXML
    Button exit;

    @FXML
    Label message;

    ControllersHelper controllersHelper = new ControllersHelper();
    DBCargoHelper dbCargoHelper = new DBCargoHelper();
    DBHandler dbHandler = new DBHandler();
    GeoHelper geoHelper = new GeoHelper();
    DBOrderHelper dbOrderHelper = new DBOrderHelper();
    GPSRandomDataGenerator gpsRandomDataGenerator = new GPSRandomDataGenerator();

    @FXML
    public void checkGPS() throws Exception {
        double arrivalDistance = 0.0;
        double totalArrivalDistance = 0.0;
        final double factor = 0.2;
    //factor na longitude i latitude
        int carLocation = gpsRandomDataGenerator.getRandomIdOfLocation();
        double carLat = gpsRandomDataGenerator.getLatitude(carLocation);
        double carLon = gpsRandomDataGenerator.getLongitude(carLocation);
        // summary.appendText(carLat + ":" + carLon + ":");
        //midpoints and distance between them and total value

        double startLat = geoHelper.getLocation(startPoint.getText()).getLatitude();
        double startLon = geoHelper.getLocation(startPoint.getText()).getLongitude();
        double endLat = geoHelper.getLocation(endPoint.getText()).getLatitude();
        double endLon = geoHelper.getLocation(endPoint.getText()).getLongitude();

        ArrayList<Location> arrivalWayPoints = new ArrayList<Location>();
        ArrayList<Location> distanceWayPoints = new ArrayList<Location>();
        if (geoHelper.setDirection(startLat, endLat, startLon, endLon).equals("SE")) {
            arrivalWayPoints = geoHelper.getAllLocations(
                    "SELECT * FROM tlocation WHERE latitude < " + carLat + " AND latitude > " + startLat + " AND longitude > " + carLon + " AND longitude < " + startLon + ";");

            distanceWayPoints = geoHelper.getAllLocations(
                    "SELECT * FROM tlocation WHERE latitude < " + (startLat - factor) + " AND latitude > " + (endLat + factor) + " AND longitude > " + startLon + " AND longitude < " + endLon + ";");
        } else if (geoHelper.setDirection(startLat, endLat, startLon, endLon).equals("SW")) {
            arrivalWayPoints = geoHelper.getAllLocations(
                    "SELECT * FROM tlocation WHERE latitude < " + carLat + " AND latitude > " + startLat + " AND longitude < " + carLon + " AND longitude > " + startLon + ";");
            distanceWayPoints = geoHelper.getAllLocations(
                    "SELECT * FROM tlocation WHERE latitude < " + (startLat - factor) + " AND latitude > " + (endLat + factor) + " AND longitude < " + startLon + " AND longitude > " + endLon + ";");
        } else if (geoHelper.setDirection(startLat, endLat, startLon, endLon).equals("NE")) {
            arrivalWayPoints = geoHelper.getAllLocations(
                    "SELECT * FROM tlocation WHERE latitude > " + carLat + " AND latitude < " + startLat + " AND longitude > " + carLon + " AND longitude < " + startLon + ";");
            distanceWayPoints = geoHelper.getAllLocations(
                    "SELECT * FROM tlocation WHERE latitude > " + (startLat + factor) + " AND latitude < " + (endLat - factor) + " AND longitude > " + startLon + " AND longitude < " + endLon + ";");
        } else if (geoHelper.setDirection(startLat, endLat, startLon, endLon).equals("NW")) {
            arrivalWayPoints = geoHelper.getAllLocations(
                    "SELECT * FROM tlocation WHERE latitude > " + carLat + " AND latitude < " + startLat + " AND longitude < " + carLon + " AND longitude > " + startLon + ";");
            distanceWayPoints = geoHelper.getAllLocations(
                    "SELECT * FROM tlocation WHERE latitude > " + (startLat + factor) + " AND latitude < " + (endLat - factor) + " AND longitude < " + startLon + " AND longitude > " + endLon + ";");
        } else if (geoHelper.setDirection(startLat, endLat, startLon, endLon).equals("S")) {
            arrivalWayPoints = geoHelper.getAllLocations(
                    "SELECT * FROM tlocation WHERE latitude < " + carLat + " AND latitude > " + startLat + " AND longitude = " + carLon + " AND longitude = " + startLon + ";");
            distanceWayPoints = geoHelper.getAllLocations(
                    "SELECT * FROM tlocation WHERE latitude < " + (startLat - factor) + " AND latitude > " + (endLat + factor) + ";");
        } else if (geoHelper.setDirection(startLat, endLat, startLon, endLon).equals("N")) {
            arrivalWayPoints = geoHelper.getAllLocations(
                    "SELECT * FROM tlocation WHERE latitude > " + carLat + " AND latitude < " + startLat + " AND longitude = " + carLon + " AND longitude = " + startLon + ";");
            distanceWayPoints = geoHelper.getAllLocations(
                    "SELECT * FROM tlocation WHERE latitude > " + (startLat + factor) + " AND latitude < " + (endLat - factor) + ";");
        } else if (geoHelper.setDirection(startLat, endLat, startLon, endLon).equals("E")) {
            arrivalWayPoints = geoHelper.getAllLocations(
                    "SELECT * FROM tlocation WHERE longitude > " + carLon + " AND longitude < " + startLat + " AND latitude = " + carLat + " AND latitude = " + startLat + ";");
            distanceWayPoints = geoHelper.getAllLocations(
                    "SELECT * FROM tlocation WHERE longitude > " + (startLon + factor) + " AND longitude < " + (endLon - factor) + ";");
        } else if (geoHelper.setDirection(startLat, endLat, startLon, endLon).equals("W")) {
            arrivalWayPoints = geoHelper.getAllLocations(
                    "SELECT * FROM tlocation WHERE longitude < " + carLon + " AND longitude > " + startLat + " AND latitude = " + carLat + ";");
            distanceWayPoints = geoHelper.getAllLocations(
                    "SELECT * FROM tlocation WHERE longitude < " + (startLon - factor) + " AND longitude > " + (endLon + factor) + ";");
        }

        distanceWayPoints.add(geoHelper.getLocation(startPoint.getText()));
        distanceWayPoints.add(geoHelper.getLocation(endPoint.getText()));

//        for(Location location : distanceWayPoints){
//            if(location.getLatitude() > startLat-0.5){
//                distanceWayPoints.remove(location);
//            }
    //}

        Collections.sort(distanceWayPoints, new LatitudeComparator());


        for(Location location : distanceWayPoints){
            summary.appendText(location.toString() +"\n");
        }

//
//            for (Location location : wayPoints) {
//                summary.setText(location.toString());
//            }
//            for (int i = 0; i < wayPoints.size() - 1; i++) {
//                arrivalDistance += geoHelper.getDistanceInKM(wayPoints.get(i).getLatitude(), wayPoints.get(i).getLongitude(), wayPoints.get(i + 1).getLatitude(), wayPoints.get(i + 1).getLongitude());
//                summary.setText("arrival distance :" + arrivalDistance + ":");
//            }
//            //  midpoints and distance between them and total distance
//
//
//            double distance = geoHelper.getDistanceInKM(startLat, endLat, startLon, endLon);
//
//            message.setText("New order accepted!");
//
//            double arrivalDistance = geoHelper.getDistanceInKM(gpsRandomDataGenerator.getLatitude(carLocation), startLat, gpsRandomDataGenerator.getLongitude(carLocation), startLon);
//            int mileageIncrement = (int) arrivalDistance;
//            dbHandler.connectToDataBase("UPDATE tvehicle SET mileage = " + mileageIncrement + " WHERE id = " + adjustedVehicle + ";");
//            String arrivalTime = geoHelper.calculateTimeFromDistance(arrivalDistance);
//            summary.setText("Arrival time: " + arrivalTime + "\nOrder date: " +
//                    dbHandler.getStringFromDB("SELECT orderDate FROM torder WHERE customerId = " + customerId + ";", "orderDate") +
//                    "\nDelivery time: " + geoHelper.calculateTimeFromDistance(distance) + "\nDistance: " + distance + " km. " +
//                    "\nDriver: " + dbHandler.getStringFromDB("SELECT name FROM tdriver WHERE id = " + adjustedDriver + ";", "name") +
//                    "\nVehicle: " + dbHandler.getStringFromDB("SELECT brand FROM tvehicle WHERE id = " + adjustedVehicle + ";", "brand") +
//                    "-" + dbHandler.getStringFromDB("SELECT model FROM tvehicle WHERE id = " + adjustedVehicle + ";", "model") +
//                    ", Registration number: " + dbHandler.getStringFromDB("SELECT registrationNumber FROM tvehicle WHERE id = " + adjustedVehicle + ";", "registrationNumber"));
//            //add driverId and inProgress to an order
//        }
    }

    @FXML
    public void clearDisplay() throws Exception {
        summary.clear();
    }

    @FXML
    public void getOut() {
        Platform.exit();
    }
}
