package com.leszeknowinski.controllers;

import com.leszeknowinski.DataBaseSupport.DBVehicleHelper;
import com.leszeknowinski.Vehicle.Bus;
import com.leszeknowinski.Vehicle.Car;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.InputMismatchException;

public class CarAddingController {

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

    ControllersHelper controllersHelper = new ControllersHelper();

    @FXML
    public void createCar(){
        try {
            Car car = new Car(brand.getText(), model.getText(), colour.getText(), Integer.parseInt(mileage.getText()),
                    Integer.parseInt(engineCapacity.getText()), Double.parseDouble(fuelConsumption.getText()),
                    vin.getText(), registrationNumber.getText(), "car", false);
            DBVehicleHelper.insertCar(car);
            message.setText("New vehicle added successfully!");
        }catch (InputMismatchException e){
            message.setText("Invalid value entered!");
        }
    }

    @FXML
    public void getBack() throws Exception{
        ControllersHelper controllersHelper = new ControllersHelper();
        ((Stage)submit.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("EmployeeMainMenu.fxml"));
    }

    @FXML
    public void getOut(){
        Platform.exit();
    }
}
