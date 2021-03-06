package com.leszeknowinski.controllers.adminManagerControllers;

import com.leszeknowinski.User.CustomerType;
import com.leszeknowinski.controllers.ControllersHelper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerTypeChooseForRemoveController implements Initializable {

    @FXML
    ChoiceBox<CustomerType>customerType;

    @FXML
    Button select;

    @FXML
    Button back;

    @FXML
    Label message;

    ControllersHelper controllersHelper = new ControllersHelper();

    public void initialize(URL location, ResourceBundle resources) {
    loadOptions();
    }

    @FXML
    public void loadOptions(){
        customerType.getItems().add(CustomerType.CUSTOMER);
        customerType.getItems().add(CustomerType.CUSTOMERB2B);
    }

    @FXML
    public void executeCustomerDeleting()throws Exception{
        if(customerType.getValue() == null){
            message.setText("You have to choose an option before clicking select!");
        }
        else if(customerType.getValue().equals(CustomerType.CUSTOMER)) {
            ((Stage) select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("customerFXMLs/CustomerShowScreen.fxml"));
        }
        else if(customerType.getValue().equals(CustomerType.CUSTOMERB2B)){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("customerFXMLs/CustomerB2BShowScreen.fxml"));
        }
    }

    @FXML
    public void getBack() throws Exception{
        ((Stage)back.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("adminManagerFXMLs/EmployeeMainMenu.fxml"));
    }
}
