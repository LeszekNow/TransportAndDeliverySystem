package com.leszeknowinski.controllers.vehicleControllers;

import com.leszeknowinski.controllers.ControllersHelper;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
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

    @FXML
    Label message;


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
        ControllersHelper controllersHelper = new ControllersHelper();
        if(vehicleType.getValue() == null){
            message.setText("You have to choose an option before clicking select!");
        }
        else if(vehicleType.getValue().equals("Bus")) {
            ((Stage) select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("vehicleFXMLs/BusesDisplayScreen.fxml"));
        }
        else if(vehicleType.getValue().equals("Car")){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("vehicleFXMLs/CarsDisplayScreen.fxml"));
        }
        else if(vehicleType.getValue().equals("Motorcycle")){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("vehicleFXMLs/MotorcyclesDisplayScreen.fxml"));
        }
        else if(vehicleType.getValue().equals("Truck")){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("vehicleFXMLs/TrucksDisplayScreen.fxml"));
        }
        else if(vehicleType.getValue().equals("Van")){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("vehicleFXMLs/VansDisplayScreen.fxml"));
        }
        else if(vehicleType.getValue().equals("Show all")){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("vehicleFXMLs/VehiclesDisplayScreen.fxml"));
        }
    }

    @FXML
    public void getBack() throws Exception{
       FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getClassLoader().getResource("adminManagerFXMLs/EmployeeMainMenu.fxml"));
       Pane pane = fxmlLoader.load();
       Scene scene = new Scene(pane);
        ((Stage)back.getScene().getWindow()).setScene(scene);
    }
}
