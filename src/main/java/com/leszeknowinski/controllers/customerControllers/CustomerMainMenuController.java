package com.leszeknowinski.controllers.customerControllers;

import com.leszeknowinski.App.UserData;
import com.leszeknowinski.DataBaseSupport.DBHandler;
import com.leszeknowinski.User.CustomerType;
import com.leszeknowinski.controllers.ControllersHelper;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javax.jws.soap.SOAPBinding;

public class CustomerMainMenuController {

    @FXML
    Button newOrder;

    @FXML
    Button myOrders;

    @FXML
    Button editOrder;

    @FXML
    Button editAccount;

    @FXML
    Button deleteAccount;

    @FXML
    Label message;

    @FXML
    Button back;

    @FXML
    Button exit;

    ControllersHelper controllersHelper = new ControllersHelper();
    DBHandler dbHandler = new DBHandler();

    @FXML
    public void loadCargoTypeChooseScreen() throws Exception{
        ((Stage) newOrder.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("orderFXMLs/CargoTypeChooseScreen.fxml"));
    }

    @FXML
    public void loadOrderSummaryScreen() throws Exception{
        ((Stage) myOrders.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("orderFXMLs/OrderSummaryScreen.fxml"));
    }

    @FXML
    public void loadOrderEditScreen()throws Exception {
        int userId = dbHandler.getSthIdFromDB("SELECT id FROM tclient WHERE username = '" + UserData.getInstance().getUsernameMemory() + "';");
        boolean inProgress = dbHandler.getSthBooleanFromDB("SELECT inProgress FROM torder WHERE customerId = " + userId + ";", "inProgress");
        if (inProgress == true) {
            message.setText("Order in progress! Editing unavailable!");
        } else {
                ((Stage) editOrder.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("orderFXMLs/OrderEditingScreen.fxml"));
        }
    }

    @FXML
    public void loadAccountEditScreen()throws Exception {
        String customerType = dbHandler.getStringFromDB("SELECT customerType FROM tclient WHERE username = '" + UserData.getInstance().getUsernameMemory() + "';", "customerType");
        if (customerType.equals(String.valueOf(CustomerType.CUSTOMER))) {
            ((Stage) editAccount.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("customerFXMLs/CustomerEditingScreen.fxml"));
        }else{
            ((Stage) editAccount.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("customerFXMLs/CustomerB2BEditingScreen.fxml"));
        }
    }

    @FXML
    public void loadConfirmationScreen()throws Exception{
        ((Stage)deleteAccount.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("customerFXMLs/AccountDeletingConfirmationScreen.fxml"));
    }


    @FXML
    public void getBack()throws Exception{
        ((Stage) back.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("customerFXMLs/CustomerStartScreen.fxml"));
    }

    @FXML
    public void getOut(){
        Platform.exit();
    }

    }

