package com.leszeknowinski.controllers.vehicleControllers;

import com.leszeknowinski.DataBaseSupport.DBVehicleHelper;
import com.leszeknowinski.Vehicle.Truck;
import com.leszeknowinski.Vehicle.VehicleType;
import com.leszeknowinski.controllers.ControllersHelper;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TruckAddingController {

    @FXML
    TextField brand;

    @FXML
    TextField model;

    @FXML
    TextField colour;

    @FXML
    TextField mileage;

    @FXML
    TextField engineCapacity;

    @FXML
    TextField fuelConsumption;

    @FXML
    TextField vin;

    @FXML
    TextField registrationNumber;


    @FXML
    Button submit;

    @FXML
    Button back;

    @FXML
    Button exit;

    @FXML
    Label message;

    @FXML
    public void createTruck(){
        Truck truck = new Truck(brand.getText(), model.getText(), colour.getText(), Integer.parseInt(mileage.getText()),
                Integer.parseInt(engineCapacity.getText()), Double.parseDouble(fuelConsumption.getText()),
                vin.getText(), registrationNumber.getText(), VehicleType.TRUCK, false);
        DBVehicleHelper.insertTruck(truck);
        message.setText("New vehicle added successfully!");
    }

    @FXML
    public void getBack() throws Exception{
        ControllersHelper controllersHelper = new ControllersHelper();
        ((Stage)submit.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("adminManagerFXMLs/EmployeeMainMenu.fxml"));
    }

    @FXML
    public void getOut(){
        Platform.exit();
    }
}
