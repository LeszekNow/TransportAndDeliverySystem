package com.leszeknowinski.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerTypeChooseController2 implements Initializable {

    @FXML
    ChoiceBox<String>customerType;

    @FXML
    Button select;

    @FXML
    Button back;


    public void initialize(URL location, ResourceBundle resources) {
    loadOptions();
    }

    @FXML
    public void loadOptions(){
        customerType.getItems().add("Customer");
        customerType.getItems().add("Customer B2B / VAT");
    }

    @FXML
    public void executeCustomersDisplay()throws Exception{
        String customer = customerType.getValue();
        ControllersHelper controllersHelper = new ControllersHelper();
        if(customer.equals("Customer")) {
            ((Stage) select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("CustomersDisplayScreen.fxml"));
        }
        else if(customer.equals("Customer B2B / VAT")) {
            ((Stage) select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("CustomersB2BDisplayScreen.fxml"));
        }
    }

    @FXML
    public void getBack() throws Exception{
       FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getClassLoader().getResource("EmployeeMainMenu.fxml"));
       Pane pane = fxmlLoader.load();
       Scene scene = new Scene(pane);
        ((Stage)back.getScene().getWindow()).setScene(scene);
    }
}
