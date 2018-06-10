package com.leszeknowinski.controllers.vehicleControllers;

import com.leszeknowinski.Vehicle.VehicleType;
import com.leszeknowinski.controllers.ControllersHelper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class VehicleTypeChooseForRemoveController implements Initializable {

    @FXML
    ChoiceBox<VehicleType>vehicleType;

    @FXML
    Button select;

    @FXML
    Button back;

    @FXML
    Label message;

    ControllersHelper controllersHelper = new ControllersHelper();

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
    public void executeVehicleTypeShow()throws Exception{
        if(vehicleType.getValue() == null){
            message.setText("You have to choose an option before clicking select!");
        }
        else if(vehicleType.getValue().equals(VehicleType.BUS)) {
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLAnchorPaneScreen("vehicleFXMLs/BusShowScreen.fxml"));
        }
        else if(vehicleType.getValue().equals(VehicleType.CAR)){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("vehicleFXMLs/CarShowScreen.fxml"));
        }
        else if(vehicleType.getValue().equals(VehicleType.MOTORCYCLE)){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("vehicleFXMLs/MotorcycleShowScreen.fxml"));
        }
        else if(vehicleType.getValue().equals(VehicleType.TRUCK)){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("vehicleFXMLs/TruckShowScreen.fxml"));
        }
        else if(vehicleType.getValue().equals(VehicleType.VAN)){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("vehicleFXMLs/VanShowScreen.fxml"));
        }
        else if(vehicleType.getValue().equals(VehicleType.ALL)){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("vehicleFXMLs/VehiclesShowScreen.fxml"));
        }
    }

    @FXML
    public void getBack() throws Exception{
        ((Stage)back.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("adminManagerFXMLs/EmployeeMainMenu.fxml"));
    }
}
