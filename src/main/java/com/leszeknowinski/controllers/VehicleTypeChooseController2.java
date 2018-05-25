package com.leszeknowinski.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class VehicleTypeChooseController2 implements Initializable {

    @FXML
    ChoiceBox<String>vehicleType;

    @FXML
    Button select;

    @FXML
    Button back;


    public void initialize(URL location, ResourceBundle resources) {
    loadOptions();
    }

    @FXML
    public void loadOptions(){
        vehicleType.getItems().add("Bus");
        vehicleType.getItems().add("Car");
        vehicleType.getItems().add("Motorcycle");
        vehicleType.getItems().add("Truck");
        vehicleType.getItems().add("Van");
        vehicleType.getItems().add("Show all");
    }

    @FXML
    public void executeVehicleShow()throws Exception{
        String vehicle = vehicleType.getValue();
        ControllersHelper controllersHelper = new ControllersHelper();
        if(vehicle.equals("Bus")) {
            ((Stage) select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("BusesDisplayScreen.fxml"));
        }
        else if(vehicle.equals("Car")){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("CarsDisplayScreen.fxml"));
        }
        else if(vehicle.equals("Motorcycle")){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("MotorcyclesDisplayScreen.fxml"));
        }
        else if(vehicle.equals("Truck")){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("TrucksDisplayScreen.fxml"));
        }
        else if(vehicle.equals("Van")){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("VansDisplayScreen.fxml"));
        }
        else if(vehicle.equals("Show all")){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("VehiclesDisplayScreen.fxml"));
        }
    }

    @FXML
    public void getBack() throws Exception{
       FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getClassLoader().getResource("EmployeeMainMenu.fxml"));
       Pane pane = fxmlLoader.load();
       Scene scene = new Scene(pane);
        ((Stage)back.getScene().getWindow()).setScene(scene);
    }
}
