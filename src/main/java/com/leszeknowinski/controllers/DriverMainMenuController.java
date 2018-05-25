package com.leszeknowinski.controllers;

import com.leszeknowinski.Vehicle.Car;
import com.leszeknowinski.Vehicle.VehicleDataWrapper;
import com.leszeknowinski.Vehicle.VehicleRepository;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DriverMainMenuController {

    @FXML
    Button startOrder;

    @FXML
    Button showOrders;
    //inside show adjusted vehicle
    @FXML
    Button finishOrder;

    @FXML
    Button showVehicle;

    @FXML
    Button back;

    @FXML
    Button exit;

    ControllersHelper controllersHelper = new ControllersHelper();
    VehicleRepository vehicleRepository = new VehicleRepository();

    @FXML
    public void loadStartOrderScreen() throws Exception {
        ((Stage) startOrder.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("DriverOrderAcceptationScreen.fxml"));
    }

    @FXML
    public void loadAllOrdersScreen() throws Exception {
        ((Stage) showOrders.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("AllOrdersScreen.fxml"));
    }

    @FXML
    public void loadFinishOrderScreen() throws Exception {
        ((Stage) finishOrder.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("DriverOrderFinishScreen.fxml"));
    }

    @FXML
    public void loadVehiclesShowScreen() throws Exception {
        ((Stage) showVehicle.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("AdjustedVehicleShowScreen.fxml"));
    }


    @FXML
    public void getBack() throws Exception {
        ((Stage) back.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("EmployeeMenu.fxml"));
    }

    @FXML
    public void getOut() {
        Platform.exit();
    }

    //usuń wybór rodzaju klienta przy logowaniu customera
}

