package com.leszeknowinski.controllers;

import com.leszeknowinski.DataBaseSupport.DBCargoHelper;
import com.leszeknowinski.DataBaseSupport.DBHandler;
import com.leszeknowinski.DataBaseSupport.DBOrderHelper;
import com.leszeknowinski.GPS.GPSRandomDataGenerator;
import com.leszeknowinski.GPS.GeoHelper;
import com.leszeknowinski.GPS.Location;
import com.leszeknowinski.GPS.LocationRepository;
import com.leszeknowinski.comparators.LatitudeComparatorN;
import com.leszeknowinski.comparators.LatitudeComparatorS;
import com.leszeknowinski.comparators.LongitudeComparatorE;
import com.leszeknowinski.comparators.LongitudeComparatorW;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.*;
import java.util.stream.Collectors;

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
    LocationRepository locationRepository = new LocationRepository();

    @FXML
    public void checkGPS() throws Exception {
        double arrivalDistance = 0.0;
        double totalArrivalDistance = 0.0;
        final double factor = 0.2;
        //factor na longitude i latitude
        int carLocation = gpsRandomDataGenerator.getRandomIdOfLocation();
        double carLat = gpsRandomDataGenerator.getLatitude(carLocation);
        double carLon = gpsRandomDataGenerator.getLongitude(carLocation);
        //summary.appendText(carLat + ":" + carLon + ":");
        //midpoints and distance between them and total value

        double startLat = geoHelper.getLocation(startPoint.getText()).getLatitude();
        double startLon = geoHelper.getLocation(startPoint.getText()).getLongitude();
        double endLat = geoHelper.getLocation(endPoint.getText()).getLatitude();
        double endLon = geoHelper.getLocation(endPoint.getText()).getLongitude();

        List<Location>locations = new ArrayList<>();
        LatitudeComparatorS latitudeComparatorS = new LatitudeComparatorS();
        if (geoHelper.setDirection(startLat, endLat, startLon, endLon).equals("SE")) {
            locations = geoHelper.getAllLocations("SELECT * FROM tlocation WHERE latitude < " + startLat + " AND latitude > " + endLat + " AND longitude > " + startLon + " AND longitude < " + endLon + ";");
        } else if (geoHelper.setDirection(startLat, endLat, startLon, endLon).equals("NW")) {
           locations = geoHelper.getAllLocations("SELECT * FROM tlocation WHERE latitude > " + startLat + " AND latitude < " + endLat + " AND longitude < " + startLon + " AND longitude > " + endLon + ";");
        } else if (geoHelper.setDirection(startLat, endLat, startLon, endLon).equals("SW")) {
           locations = geoHelper.getAllLocations("SELECT * FROM tlocation WHERE latitude < " + startLat + " AND latitude > " + endLat + " AND longitude < " + startLon + " AND longitude > " + endLon + ";");
        } else if (geoHelper.setDirection(startLat, endLat, startLon, endLon).equals("NE")) {
            locations = geoHelper.getAllLocations("SELECT * FROM tlocation WHERE latitude > " + startLat + " AND latitude < " + endLat + " AND longitude > " + startLon + " AND longitude < " + endLon + ";");
        } else if (geoHelper.setDirection(startLat, endLat, startLon, endLon).equals("N")) {
            locations = geoHelper.getAllLocations("SELECT * FROM tlocation WHERE latitude > " + startLat + " AND latitude < " + endLat + ";");
        } else if (geoHelper.setDirection(startLat, endLat, startLon, endLon).equals("S")) {
           locations = geoHelper.getAllLocations("SELECT * FROM tlocation WHERE latitude < " + startLat + " AND latitude > " + endLat + ";");
        } else if (geoHelper.setDirection(startLat, endLat, startLon, endLon).equals("E")) {
            locations = geoHelper.getAllLocations("SELECT * FROM tlocation WHERE longitude > " + startLon + " AND longitude < " + endLon + ";");
        } else if (geoHelper.setDirection(startLat, endLat, startLon, endLon).equals("W")) {
            locations = geoHelper.getAllLocations("SELECT * FROM tlocation WHERE longitude < " + startLon + " AND longitude > " + endLon + ";");
        }

        Set<Location>route = new HashSet<>();
        Location start = geoHelper.getLocation(startPoint.getText());
        Location end = geoHelper.getLocation(endPoint.getText());
        for(int i = 0; i < locations.size(); i++){
            route.add(geoHelper.setClosestLocation(locations, start, end));
            start = geoHelper.setClosestLocation(locations, start, end);
            locations.remove(geoHelper.setClosestLocation(locations, start, end));
        }

        for(Location location : route){
            summary.appendText(location.toString() + "\n");
        }




//        int start = 0;
//        double totalDistance = 0;
//        for(int i = 1; i < distanceWayPoints.size(); i++){
//            totalDistance += geoHelper.getDistanceInKM(distanceWayPoints.get(start).getLatitude(), distanceWayPoints.get(i).getLatitude(),
//                    distanceWayPoints.get(start).getLongitude(), distanceWayPoints.get(i).getLongitude());
//            start = i;
//        }
//
//        for(Location location : distanceWayPoints){
//            summary.appendText(location.toString() + "\n");
//        }
//        summary.appendText("Distance: " + totalDistance);


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
