package com.leszeknowinski.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DriverMainMenuForEmployeeController {

    @FXML
    Button showOrders;

    @FXML
    Button startOrder;
    //inside show adjusted vehicle

    @FXML
    Button finishOrder;

    @FXML
    Button back;

    @FXML
    Button exit;

    ControllersHelper controllersHelper = new ControllersHelper();

    @FXML
    public void loadCargoTypeChooseScreen() throws Exception{
        ((Stage) showOrders.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("CargoTypeChooseScreen.fxml"));
    }

    public void loadOrderSummaryScreen() throws Exception{
        ((Stage) startOrder.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("OrderSummaryScreen.fxml"));
    }

    public void loadOrderSummaryScreenXXX() throws Exception{
        ((Stage) startOrder.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("OrderSummaryScreen.fxml"));
    }


    @FXML
    public void getBack()throws Exception{
        ((Stage) back.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("EmployeeMainMenu.fxml"));
    }

    @FXML
    public void getOut(){
        Platform.exit();
    }

    //usuń wybór rodzaju klienta przy logowaniu customera
    }

