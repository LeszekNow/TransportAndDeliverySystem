package com.leszeknowinski.controllers.customerControllers;

import com.leszeknowinski.DataBaseSupport.DBUserHelper;
import com.leszeknowinski.User.CustomerB2B;
import com.leszeknowinski.User.CustomerType;
import com.leszeknowinski.controllers.ControllersHelper;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CustomerB2BAddingController {

    @FXML
    TextField company;

    @FXML
    TextField nip;

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
    ControllersHelper controllersHelper = new ControllersHelper();

    @FXML
    public void createCustomerB2B(){
        CustomerB2B b2B = new CustomerB2B(company.getText(), nip.getText(), phone.getText(),
                username.getText(), password.getText(), CustomerType.CUSTOMERB2B);
        dbUserHelper.insertB2BCustomer(b2B);
        message.setText("New customer added successfully!");
    }

    @FXML
    public void getBack() throws Exception{
        ((Stage)submit.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("adminManagerFXMLs/EmployeeMainMenu.fxml"));
    }

    @FXML
    public void getOut(){
        Platform.exit();
    }
}
