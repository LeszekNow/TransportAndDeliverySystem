package com.leszeknowinski.controllers.vehicleControllers;

import com.leszeknowinski.DataBaseSupport.DBVehicleHelper;
import com.leszeknowinski.Vehicle.Van;
import com.leszeknowinski.controllers.ControllersHelper;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VanAddingController {

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
    TextField maxCargoHeight;

    @FXML
    TextField maxCargoLength;

    @FXML
    TextField maxCargoWidth;

    @FXML
    TextField maxCargoWeight;


    @FXML
    Button submit;

    @FXML
    Button back;

    @FXML
    Button exit;

    @FXML
    Label message;

    @FXML
    public void createVan() {
        Van van = new Van(brand.getText(), model.getText(), colour.getText(), Integer.parseInt(mileage.getText()),
                Integer.parseInt(engineCapacity.getText()), Double.parseDouble(fuelConsumption.getText()),
                vin.getText(), registrationNumber.getText(), Integer.parseInt(maxCargoHeight.getText()),
                Integer.parseInt(maxCargoLength.getText()), Integer.parseInt(maxCargoWidth.getText()),
                Integer.parseInt(maxCargoWeight.getText()), "van", false);
        DBVehicleHelper.insertVan(van);
        message.setText("New vehicle added successfully!");

    }

    @FXML
    public void getBack() throws Exception {
        ControllersHelper controllersHelper = new ControllersHelper();
        ((Stage) submit.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("adminManagerFXMLs/EmployeeMainMenu.fxml"));
    }

    @FXML
    public void getOut() {
        Platform.exit();
    }
}
