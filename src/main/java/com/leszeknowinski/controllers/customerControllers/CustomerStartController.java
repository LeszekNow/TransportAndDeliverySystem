package com.leszeknowinski.controllers.customerControllers;

import com.leszeknowinski.controllers.ControllersHelper;
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
        ((Stage) login.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("customerFXMLs/CustomerLoginScreen.fxml"));
    }

    @FXML
    public void loadCustomerRegistrationScreen() throws Exception {
        ((Stage) register.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("customerFXMLs/CustomerTypeChooseScreen3.fxml"));
    }

    @FXML
    public void showServicesList(){

    }

    @FXML
    public void showPricesList(){

    }

    public void showVehicleTypeChooseScreen() throws Exception{
        ((Stage)vehicles.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("vehicleFXMLs/VehicleTypeChooseForDisplayScreen.fxml"));

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

