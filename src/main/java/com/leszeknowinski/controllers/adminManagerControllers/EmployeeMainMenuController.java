package com.leszeknowinski.controllers.adminManagerControllers;

import com.leszeknowinski.controllers.ControllersHelper;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeMainMenuController implements Initializable {

    @FXML
    Button addNewCar;

    @FXML
    Button addNewEmployee;

    @FXML
    Button addNewLocation;

    @FXML
    Button addNewCustomer;

    @FXML
    Button deleteVehicle;

    @FXML
    Button deleteEmployee;

    @FXML
    Button deleteLocation;

    @FXML
    Button deleteRoute;

    @FXML
    Button deleteCustomer;

    @FXML
    Button showVehicles;

    @FXML
    Button showCustomers;

    @FXML
    Button trackVehicle;

    @FXML
    Button calculations;

    @FXML
    Button customerMenu;

    @FXML
    Button driverMenu;

    @FXML
    TextArea alert;

    @FXML
    Button back;

    @FXML
    Button exit;

    ControllersHelper controllersHelper = new ControllersHelper();

    public void initialize(URL location, ResourceBundle resources) {
            displayAlerts();
    }

    @FXML
    public void chooseVehicleType() throws Exception{
        ((Stage)addNewCar.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("vehicleFXMLs/VehicleTypeChooseScreen.fxml"));
    }

    @FXML
    public void chooseEmployeeType()throws Exception{
        ((Stage)addNewEmployee.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("adminManagerFXMLs/EmployeeTypeChooseScreen.fxml"));
    }

    @FXML
    public void chooseCustomerType()throws Exception{
        ((Stage)addNewCustomer.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("customerFXMLs/CustomerTypeChooseScreen.fxml"));
    }

    @FXML
    public void addLocation()throws Exception{
        ((Stage)addNewLocation.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("locationFXMLs/LocationAddingScreen.fxml"));
    }

    @FXML
    public void displayAlerts(){
        //change addRoute into AlertDisplay - display of cars list for service after exceed 15000km
        //other info
        //loaded automatically
    }


    @FXML
    public void deleteVehicle() throws Exception{
        ((Stage)deleteVehicle.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("vehicleFXMLs/VehicleTypeChooseForRemoveScreen.fxml"));
    }

    @FXML
    public void deleteEmployee()throws Exception{
        ((Stage)deleteEmployee.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("adminManagerFXMLs/EmployeeTypeChooseForRemoveScreen.fxml"));
    }

    @FXML
    public void deleteCustomer()throws Exception{
        ((Stage)deleteCustomer.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("adminManagerFXMLs/CustomerTypeChooseForRemoveScreen.fxml"));
    }

    @FXML
    public void deleteLocation()throws Exception{
        ((Stage)deleteLocation.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("locationFXMLs/LocationShowScreen.fxml"));
    }


    @FXML
    public void showVehicleTypeChooseScreen()throws Exception{
        ((Stage)deleteRoute.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("vehicleFXMLs/VehicleTypeChooseScreen2.fxml"));
    }
    @FXML
    public void showCustomers()throws Exception{
        ((Stage)deleteRoute.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("customerFXMLs/CustomerTypeChooseScreen2.fxml"));
    }

    @FXML
    public void loadVehicleShowScreen()throws Exception{
        ((Stage)trackVehicle.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("locationFXMLs/VehicleTrackChooseScreen.fxml"));

    }

    @FXML
    public void loadCustomerMenu()throws Exception{
        ((Stage)customerMenu.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("adminManagerFXMLs/CustomerMainMenuForEmployeeScreen.fxml"));
    }

    @FXML
    public void loadDriverMenu()throws Exception{
        ((Stage)driverMenu.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("adminManagerFXMLs/DriverMainMenuForEmployeeScreen.fxml"));
    }

    @FXML
    public void getBack()throws Exception{
        ((Stage) back.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("StartMenu.fxml"));
    }

    @FXML
    public void getOut(){
        Platform.exit();
    }



}

