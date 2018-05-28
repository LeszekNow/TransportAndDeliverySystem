package com.leszeknowinski.controllers.vehicleControllers;

import com.leszeknowinski.controllers.ControllersHelper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class VehicleTypeChooseForRemoveController implements Initializable {

    @FXML
    ChoiceBox<String>vehicleType;

    @FXML
    Button select;

    @FXML
    Button back;

    ControllersHelper controllersHelper = new ControllersHelper();
    VehicleTypeChooseController vehicleTypeChooseController = new VehicleTypeChooseController();

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
        vehicleType.getItems().add("Delete all");
    }

    @FXML
    public void executeVehicleTypeShow()throws Exception{
        String vehicle = vehicleType.getValue();
        if(vehicle.equals("Bus")) {
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLAnchorPaneScreen("vehicleFXMLs/BusShowScreen.fxml"));
        }
        else if(vehicle.equals("Car")){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("vehicleFXMLs/CarShowScreen.fxml"));
        }
        else if(vehicle.equals("Motorcycle")){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("vehicleFXMLs/MotorcycleShowScreen.fxml"));
        }
        else if(vehicle.equals("Truck")){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("vehicleFXMLs/TruckShowScreen.fxml"));
        }
        else if(vehicle.equals("Van")){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("vehicleFXMLs/VanShowScreen.fxml"));
        }
        else if(vehicle.equals("Delete all")){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("vehicleFXMLs/VehiclesShowScreen.fxml"));
        }
    }

    @FXML
    public void getBack() throws Exception{
        ((Stage)back.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("adminManagerFXMLs/EmployeeMainMenu.fxml"));
    }
}
