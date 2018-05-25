package com.leszeknowinski.controllers;

import com.leszeknowinski.DataBaseSupport.DBHandler;
import com.leszeknowinski.Order.Order;
import com.leszeknowinski.Order.OrderRepository;
import com.leszeknowinski.Vehicle.VehicleRepository;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DriverOrderAcceptationController {

    @FXML
    TextArea show;

    @FXML
    TextField username;

    @FXML
    Button display;

    @FXML
    Button accept;

    @FXML
    Button back;

    @FXML
    Button exit;


    VehicleRepository vehicleRepository = new VehicleRepository();
    DBHandler dbHandler = new DBHandler();
    ControllersHelper controllersHelper = new ControllersHelper();
    OrderRepository orderRepository = new OrderRepository();

    @FXML
    public void showOrder() {
        int driverId = dbHandler.getSthIdFromDB("SELECT id FROM tdriver WHERE username = '" + username.getText() + "';");
        for (Order order : orderRepository.getDriverOrders(driverId)) {
            show.appendText(order.toString2());
        }
    }

    @FXML
    public void acceptOrder() {
        dbHandler.connectToDataBase("UPDATE torder SET inProgress = true WHERE driverId = " + dbHandler.getSthIdFromDB("SELECT id FROM tdriver WHERE username = '" + username.getText() + "';"));
        show.clear();
        show.setText("Order realisation has started! \nDrive save.");
    }

    @FXML
    public void getBack() throws Exception {
        ((Stage) back.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("DriverMainMenuScreen.fxml"));
    }

    @FXML
    public void getOut() {
        Platform.exit();
    }
}
