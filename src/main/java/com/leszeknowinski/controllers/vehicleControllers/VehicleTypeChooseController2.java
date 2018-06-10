package com.leszeknowinski.controllers.vehicleControllers;

import com.leszeknowinski.Vehicle.VehicleType;
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
    ChoiceBox<VehicleType>vehicleType;

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
        vehicleType.getItems().add(VehicleType.BUS);
        vehicleType.getItems().add(VehicleType.CAR);
        vehicleType.getItems().add(VehicleType.MOTORCYCLE);
        vehicleType.getItems().add(VehicleType.TRUCK);
        vehicleType.getItems().add(VehicleType.VAN);
        vehicleType.getItems().add(VehicleType.ALL);
    }

    @FXML
    public void executeVehicleShow()throws Exception{
        ControllersHelper controllersHelper = new ControllersHelper();
        if(vehicleType.getValue() == null){
            message.setText("You have to choose an option before clicking select!");
        }
        else if(vehicleType.getValue().equals(VehicleType.BUS)) {
            ((Stage) select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("vehicleFXMLs/BusesDisplayScreen.fxml"));
        }
        else if(vehicleType.getValue().equals(VehicleType.CAR)){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("vehicleFXMLs/CarsDisplayScreen.fxml"));
        }
        else if(vehicleType.getValue().equals(VehicleType.MOTORCYCLE)){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("vehicleFXMLs/MotorcyclesDisplayScreen.fxml"));
        }
        else if(vehicleType.getValue().equals(VehicleType.TRUCK)){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("vehicleFXMLs/TrucksDisplayScreen.fxml"));
        }
        else if(vehicleType.getValue().equals(VehicleType.VAN)){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("vehicleFXMLs/VansDisplayScreen.fxml"));
        }
        else if(vehicleType.getValue().equals(VehicleType.ALL)){
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
