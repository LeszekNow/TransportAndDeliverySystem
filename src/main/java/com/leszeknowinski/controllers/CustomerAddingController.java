package com.leszeknowinski.controllers;

import com.leszeknowinski.DataBaseSupport.DBUserHelper;
import com.leszeknowinski.User.Admin;
import com.leszeknowinski.User.Customer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CustomerAddingController {

    @FXML
    TextField name;

    @FXML
    TextField surname;

    @FXML
    TextField pesel;

    @FXML
    TextField phone;

    @FXML
    TextField username;

    @FXML
    TextField password;

    @FXML
    Button submit;

    @FXML
    Button back;

    @FXML
    Button exit;

    @FXML
    Label message;

    DBUserHelper dbUserHelper = new DBUserHelper();

    @FXML
    public void createCustomer(){
        Customer customer = new Customer(name.getText(), surname.getText(), pesel.getText(), phone.getText(),
                username.getText(), password.getText(), "customer");
        dbUserHelper.insertCustomer(customer);
        message.setText("New customer added successfully!");
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
