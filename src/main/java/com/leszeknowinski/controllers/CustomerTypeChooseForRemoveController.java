package com.leszeknowinski.controllers;

import com.leszeknowinski.User.UserRepository;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerTypeChooseForRemoveController implements Initializable {

    @FXML
    ChoiceBox<String>customerType;

    @FXML
    Button select;

    @FXML
    Button back;

    ControllersHelper controllersHelper = new ControllersHelper();

    public void initialize(URL location, ResourceBundle resources) {
    loadOptions();
    }

    @FXML
    public void loadOptions(){
        customerType.getItems().add("Customer");
        customerType.getItems().add("Customer B2B / VAT");
    }

    @FXML
    public void executeCustomerDeleting()throws Exception{
        String customer = customerType.getValue();
        ControllersHelper controllersHelper = new ControllersHelper();
        if(customer.equals("Customer")) {
            ((Stage) select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("CustomerShowScreen.fxml"));
        }
        else if(customer.equals("Customer B2B / VAT")){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("CustomerB2BShowScreen.fxml"));
        }
    }

    @FXML
    public void getBack() throws Exception{
        ((Stage)back.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("EmployeeMainMenu.fxml"));
    }
}
