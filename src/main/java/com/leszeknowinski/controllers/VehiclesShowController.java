package com.leszeknowinski.controllers;

import com.leszeknowinski.DataBaseSupport.DBHandler;
import com.leszeknowinski.Vehicle.Car;
import com.leszeknowinski.Vehicle.Van;
import com.leszeknowinski.Vehicle.VehicleRepository;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class VehiclesShowController implements Initializable {

    @FXML
    TextArea show;

    @FXML
    Button deleteAll;

    @FXML
    Button back;

    @FXML
    Button exit;

    @FXML
    Label message;

    VehicleRepository vehicleRepository = new VehicleRepository();
    DBHandler dbHandler = new DBHandler();
    ControllersHelper controllersHelper = new ControllersHelper();

    public void initialize(URL location, ResourceBundle resources) {
        showVehicles();
    }

    @FXML
    public void showVehicles() {
        for(Car car: vehicleRepository.getCars()){
            show.appendText(car.toString() +"\n");
        }
    }

    public void showRefreshedVehiclesList(){
        show.clear();
        for(Car car: vehicleRepository.getCars()){
            show.appendText(car.toString() +"\n");
        }
    }

    @FXML
    public void executeVehicleDeleting() {
        dbHandler.connectToDataBase("DELETE FROM tvehicle;");
        message.setText("Vehicle was removed successfully!");
        showRefreshedVehiclesList();
    }

    @FXML
    public void getBack()throws Exception{
        ((Stage)deleteAll.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("EmployeeMainMenu.fxml"));
    }

    @FXML
    public void getOut(){
        Platform.exit();
    }
}
