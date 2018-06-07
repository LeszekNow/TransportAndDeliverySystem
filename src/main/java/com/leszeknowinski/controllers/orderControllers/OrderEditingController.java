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
import com.leszeknowinski.Vehicle.VehicleRepository;
import com.leszeknowinski.controllers.ControllersHelper;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class OrderEditingController implements Initializable {

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
    Button cancelOrder;

    @FXML
    Button back;

    @FXML
    Button exit;

    @FXML
    Label message;

    ControllersHelper controllersHelper = new ControllersHelper();
    DBHandler dbHandler = new DBHandler();
    GeoHelper geoHelper = new GeoHelper();
    OrderHelper orderHelper = new OrderHelper();
    DBOrderHelper dbOrderHelper = new DBOrderHelper();
    VehicleRepository vehicleRepository = new VehicleRepository();

    public void initialize(URL location, ResourceBundle resources) {
        loadOrderScreen();
    }

    @FXML
    public void loadOrderScreen() {
        int userId = dbHandler.getSthIdFromDB("SELECT id FROM tclient WHERE username = '" + UserData.getInstance().getUsernameMemory() + "';");
        Order order = dbOrderHelper.getOrder(userId);
        summary.appendText("Order date: " + order.getStartDate() + "\nStart point - " + order.getStartPoint() +
                "\nEnd point - " + order.getEndPoint() + "\nDistance - " + controllersHelper.roundDouble(order.getDistance()) + " km" +
                "\nCargo amount - " + order.getCargoAmount() +
                "\nDelivery time - " + geoHelper.calculateTimeFromDistance(order.getDistance()) + "\nDriver - " + dbHandler.getStringFromDB("SELECT name FROM tdriver WHERE id = " + order.getDriverId() + ";", "name") +
                "\nVehicle - " + vehicleRepository.getVehicle(order.getVehicleId()).getBrand() + " " + vehicleRepository.getVehicle(order.getVehicleId()).getModel() +
                ", Registration number - " + vehicleRepository.getVehicle(order.getVehicleId()).getRegistrationNumber() +
                "\nService price - " + orderHelper.calculateOrderPrice(order.getDistance(), order.getCargoType()) + " PLN.");
    }

    @FXML
    public void editOrder() {
        double startLat = geoHelper.getLocation(startPoint.getText()).getLatitude();
        double startLon = geoHelper.getLocation(startPoint.getText()).getLongitude();
        double endLat = geoHelper.getLocation(endPoint.getText()).getLatitude();
        double endLon = geoHelper.getLocation(endPoint.getText()).getLongitude();
        if (startLat == 0.0 || endLat == 0.0 || endLon == 0.0 || startLon == 0.0) {
            message.setText("Sorry, We don't support such connection!");
        } else {
            int userId = dbHandler.getSthIdFromDB("SELECT id FROM tclient WHERE username = '" + UserData.getInstance().getUsernameMemory() + "';");
            CargoType cargoType = CargoType.valueOf(dbHandler.getStringFromDB("SELECT cargoType FROM torder WHERE customerId = " + userId + ";", "cargoType"));
            double distance = geoHelper.getDistanceInKM(startLat, endLat, startLon, endLon);
            double price = orderHelper.calculateOrderPrice(distance, cargoType);
            dbHandler.connectToDataBase("UPDATE torder SET startPoint = '" + startPoint.getText() + "', endPoint = '" + endPoint.getText() + "', cargoAmount = " + Integer.parseInt(amount.getText()) + ", distance = " + distance + " WHERE customerId = " + userId + ";");
            message.setText("Order updated successfully!");
            summary.setText("Order updates: " +
                    dbHandler.getStringFromDB("SELECT orderDate FROM torder WHERE customerId = " + userId + ";", "orderDate") +
                    "\nDelivery time: " + geoHelper.calculateTimeFromDistance(distance) + "\nDistance: " + controllersHelper.roundDouble(distance) + " km. " +
                    "\nService price: " + controllersHelper.roundDouble(price) + " PLN.");
        }
    }

    @FXML
    public void deleteOrder() {
        int userId = dbHandler.getSthIdFromDB("SELECT id FROM tclient WHERE username = '" + UserData.getInstance().getUsernameMemory() + "';");
        dbHandler.connectToDataBase("DELETE FROM torder WHERE customerId = " + userId + ";");
        message.setText("Order cancelled successfully!");

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
