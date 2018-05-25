package com.leszeknowinski.controllers;

import com.leszeknowinski.DataBaseSupport.DBHandler;
import com.leszeknowinski.Vehicle.Truck;
import com.leszeknowinski.Vehicle.VehicleRepository;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class TrucksDisplayCustomerController implements Initializable {

    @FXML
    TextArea show;

    @FXML
    Button back;

    @FXML
    Button exit;


    VehicleRepository vehicleRepository = new VehicleRepository();
    DBHandler dbHandler = new DBHandler();
    ControllersHelper controllersHelper = new ControllersHelper();

    public void initialize(URL location, ResourceBundle resources) {
        showTrucks();
    }

    @FXML
    public void showTrucks() {
        for(Truck truck: vehicleRepository.getTrucks()){
            show.appendText(truck.toString() +"\n");
        }
    }

    @FXML
    public void getBack()throws Exception{
        ((Stage)back.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("CustomerStartScreen.fxml"));
    }

    @FXML
    public void getOut(){
        Platform.exit();
    }
}
