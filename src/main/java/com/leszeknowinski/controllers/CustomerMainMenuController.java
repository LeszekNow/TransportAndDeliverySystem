package com.leszeknowinski.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CustomerMainMenuController {

    @FXML
    Button newOrder;

    @FXML
    Button myOrders;

    @FXML
    Button editOrder;

    @FXML
    Button terms;

    @FXML
    Button deleteAccount;

    @FXML
    Button back;

    @FXML
    Button exit;

    ControllersHelper controllersHelper = new ControllersHelper();

    @FXML
    public void loadCargoTypeChooseScreen() throws Exception{
        ((Stage) newOrder.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("CargoTypeChooseScreen.fxml"));
    }

    public void loadOrderSummaryScreen() throws Exception{
        ((Stage) myOrders.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("OrderSummaryScreen.fxml"));
    }


    @FXML
    public void getBack()throws Exception{
        ((Stage) back.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("CustomerStartScreen.fxml"));
    }

    @FXML
    public void getOut(){
        Platform.exit();
    }

    //usuń wybór rodzaju klienta przy logowaniu customera
    }

