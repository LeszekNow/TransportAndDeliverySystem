package com.leszeknowinski.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CustomerStartController {

    @FXML
    Button login;

    @FXML
    Button register;

    @FXML
    Button services;

    @FXML
    Button prices;

    @FXML
    Button vehicles;

    @FXML
    Button back;

    @FXML
    Button exit;

    ControllersHelper controllersHelper = new ControllersHelper();

    @FXML
    public void loadCustomerLoginScreen() throws Exception {
        ((Stage) login.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("CustomerLoginScreen.fxml"));
    }

    @FXML
    public void loadCustomerRegistrationScreen() throws Exception {
        ((Stage) register.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("CustomerTypeChooseScreen3.fxml"));
    }

    @FXML
    public void showServicesList(){

    }

    @FXML
    public void showPricesList(){

    }

    public void showVehicleTypeChooseScreen() throws Exception{
        ((Stage)vehicles.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("VehicleTypeChooseForDisplayScreen.fxml"));

    }

    @FXML
    public void getBack() throws Exception {
        ((Stage)back.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("StartMenu.fxml"));
    }

    @FXML
    public void getOut() {
        Platform.exit();
    }


}

