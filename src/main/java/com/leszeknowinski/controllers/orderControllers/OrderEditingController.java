package com.leszeknowinski.controllers.orderControllers;

import com.leszeknowinski.App.UserData;
import com.leszeknowinski.Cargo.Cargo;
import com.leszeknowinski.DataBaseSupport.DBCargoHelper;
import com.leszeknowinski.DataBaseSupport.DBHandler;
import com.leszeknowinski.DataBaseSupport.DBOrderHelper;
import com.leszeknowinski.GPS.GPSRandomDataGenerator;
import com.leszeknowinski.GPS.GeoHelper;
import com.leszeknowinski.Order.Order;
import com.leszeknowinski.Order.OrderHelper;
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

    public void initialize(URL location, ResourceBundle resources) {
        loadOrderScreen();
    }

    @FXML
    public void loadOrderScreen(){
        int userId = dbHandler.getSthIdFromDB("SELECT id FROM tclient WHERE username = '" + UserData.getInstance().getUsernameMemory() + "';");
       // summary.appendText();
    }

    @FXML
    public void editOrder() {
        double startLat = geoHelper.getDoubleFromDB("SELECT latitude FROM tlocation WHERE city = '" + startPoint.getText() + "';", "latitude");
        double startLon = geoHelper.getDoubleFromDB("SELECT longitude FROM tlocation WHERE city = '" + startPoint.getText() + "';", "longitude");
        double endLat = geoHelper.getDoubleFromDB("SELECT latitude FROM tlocation WHERE city = '" + endPoint.getText() + "';", "latitude");
        double endLon = geoHelper.getDoubleFromDB("SELECT longitude FROM tlocation WHERE city = '" + endPoint.getText() + "';", "longitude");
        if (startLat == 0.0 || endLat == 0.0 || endLon == 0.0 || startLon == 0.0) {
            message.setText("Sorry, We don't support such connection!");
        } else {
            int userId = dbHandler.getSthIdFromDB("SELECT id FROM tclient WHERE username = '" + UserData.getInstance().getUsernameMemory() + "';");
            String cargoType = dbHandler.getStringFromDB("SELECT cargoType FROM torder WHERE customerId = " + userId + ";", "cargoType");
            double distance = geoHelper.getDistanceInKM(startLat, endLat, startLon, endLon);
            double price = orderHelper.calculateOrderPrice(distance, cargoType);
            dbHandler.connectToDataBase("UPDATE torder SET startPoint = '" + startPoint.getText() + "', endPoint = '" + endPoint.getText() + "', cargoAmount = " + Integer.parseInt(amount.getText()) + ", distance = " + distance + " WHERE customerId = " + userId + ";");
            message.setText("Order updated successfully!");
            summary.setText("Order updates: " +
                    dbHandler.getStringFromDB("SELECT orderDate FROM torder WHERE customerId = " + userId + ";", "orderDate") +
                    "\nDelivery time: " + geoHelper.calculateTimeFromDistance(distance) + "\nDistance: " + distance + " km. " +
                    "\nService price: " + price + " PLN.");
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
