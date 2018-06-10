package com.leszeknowinski.controllers.orderControllers;

import com.leszeknowinski.App.UserData;
import com.leszeknowinski.Cargo.Cargo;
import com.leszeknowinski.Cargo.CargoType;
import com.leszeknowinski.DataBaseSupport.DBCargoHelper;
import com.leszeknowinski.DataBaseSupport.DBHandler;
import com.leszeknowinski.DataBaseSupport.DBOrderHelper;
import com.leszeknowinski.GPS.GPSRandomDataGenerator;
import com.leszeknowinski.GPS.GeoHelper;
import com.leszeknowinski.Order.Order;
import com.leszeknowinski.Order.OrderHelper;
import com.leszeknowinski.User.CustomerType;
import com.leszeknowinski.Vehicle.VehicleType;
import com.leszeknowinski.controllers.ControllersHelper;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class PeopleOrderDataController {

    @FXML
    TextField amount;

    @FXML
    TextField startPoint;

    @FXML
    TextField endPoint;

    @FXML
    TextArea summary;

    @FXML
    Button submit;

    @FXML
    Button back;

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
    OrderHelper orderHelper = new OrderHelper();

    @FXML
    public void createOrder()  {
        VehicleType vehicleType;
        int adjustedVehicle;
        int adjustedDriver;
        if (Integer.parseInt(amount.getText()) > 3) {
            vehicleType = VehicleType.BUS;
            adjustedVehicle = dbHandler.getSthIdFromDB("SELECT id FROM tvehicle WHERE vehicleType = 'BUS' AND arrested = false ORDER BY RAND() LIMIT 1;");
            adjustedDriver = dbHandler.getSthIdFromDB("SELECT id FROM tdriver WHERE drivingLicence = 'ABC' OR 'AB' OR 'ALL' AND arrested = false ORDER BY RAND() LIMIT 1;");
        } else {
            vehicleType = VehicleType.CAR;
            adjustedVehicle = dbHandler.getSthIdFromDB("SELECT id FROM tvehicle WHERE vehicleType = 'CAR' AND arrested = false ORDER BY RAND() LIMIT 1;");
            adjustedDriver = dbHandler.getSthIdFromDB("SELECT id FROM tdriver WHERE drivingLicence = 'ABC' OR 'AB' OR 'B' AND arrested = false ORDER BY RAND() LIMIT 1;");
        }
        if (adjustedVehicle == 0 || adjustedDriver == 0) {
            message.setText("Sorry, Currently all vehicles or drivers are arrested! Try again later. ");
        } else {
            int customerId = dbHandler.getSthIdFromDB("SELECT id FROM tclient WHERE username = '" + UserData.getInstance().getUsernameMemory() + "';");
            CustomerType customerType = CustomerType.valueOf(dbHandler.getStringFromDB("SELECT customerType FROM tclient WHERE username = '" + UserData.getInstance().getUsernameMemory() + "';", "customerType"));
            double startLat = geoHelper.getLocation(startPoint.getText()).getLatitude();
            double startLon = geoHelper.getLocation(startPoint.getText()).getLongitude();
            double endLat = geoHelper.getLocation(endPoint.getText()).getLatitude();
            double endLon = geoHelper.getLocation(endPoint.getText()).getLongitude();
            if (startLat == 0.0 || endLat == 0.0 || endLon == 0.0 || startLon == 0.0) {
                message.setText("Sorry, We don't support such connection!");
            } else {
                double distance = geoHelper.getDistanceInKM(startLat, endLat, startLon, endLon);
                double price = orderHelper.calculateOrderPrice(distance, CargoType.PEOPLE);
                dbHandler.connectToDataBase("UPDATE tvehicle SET arrested = true WHERE id = " + adjustedVehicle + ";");
                dbHandler.connectToDataBase("UPDATE tdriver SET arrested = true WHERE id = " + adjustedDriver + ";");
                Order order = new Order(CargoType.PEOPLE, vehicleType, adjustedVehicle, Integer.parseInt(amount.getText()), customerId, customerType, startPoint.getText(), endPoint.getText(), distance, false, false, adjustedDriver);
                Cargo cargo = new Cargo(customerId, adjustedVehicle, CargoType.PEOPLE, Integer.parseInt(amount.getText()));
                dbOrderHelper.insertOrder(order);
                dbCargoHelper.insertPeopleCargo(cargo);
                message.setText("New order accepted!");
                int carLocation = gpsRandomDataGenerator.getRandomIdOfLocation();
                double arrivalDistance = geoHelper.getDistanceInKM(gpsRandomDataGenerator.getLatitude(carLocation), startLat, gpsRandomDataGenerator.getLongitude(carLocation), startLon);
                int mileageIncrement = (int)arrivalDistance;
                dbHandler.connectToDataBase("UPDATE tvehicle SET mileage = " + mileageIncrement + " WHERE id = " + adjustedVehicle + ";");
                String arrivalTime = geoHelper.calculateTimeFromDistance(arrivalDistance);
                summary.setText("Arrival time: " + arrivalTime + "\nOrder date: " +
                        dbHandler.getStringFromDB("SELECT orderDate FROM torder WHERE customerId = " + customerId + ";", "orderDate") +
                        "\nDelivery time: " + geoHelper.calculateTimeFromDistance(distance) + "\nDistance: " + controllersHelper.roundDouble(distance) + " km. " +
                        "\nDriver: " + dbHandler.getStringFromDB("SELECT name FROM tdriver WHERE id = " + adjustedDriver + ";", "name") +
                        "\nVehicle: " + dbHandler.getStringFromDB("SELECT brand FROM tvehicle WHERE id = " + adjustedVehicle + ";", "brand") +
                        "-" + dbHandler.getStringFromDB("SELECT model FROM tvehicle WHERE id = " + adjustedVehicle + ";", "model") + ", Registration number: " + dbHandler.getStringFromDB("SELECT registrationNumber FROM tvehicle WHERE id = " + adjustedVehicle + ";", "registrationNumber") +
                        "\nService price: " + controllersHelper.roundDouble(price) + " PLN.");
            }
        }
    }

    @FXML
    public void getBack() throws Exception {
        ((Stage) submit.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("customerFXMLs/CustomerMainMenuScreen.fxml"));
    }

    @FXML
    public void getOut() {
        Platform.exit();
    }
}
