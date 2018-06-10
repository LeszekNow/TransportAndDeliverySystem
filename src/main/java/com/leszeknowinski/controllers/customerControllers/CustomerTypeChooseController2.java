package com.leszeknowinski.controllers.customerControllers;

import com.leszeknowinski.User.CustomerType;
import com.leszeknowinski.controllers.ControllersHelper;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerTypeChooseController2 implements Initializable {

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
    public void executeCustomersDisplay()throws Exception{
        if(customerType.getValue() == null){
            message.setText("You have to choose an option before clicking select!");
        }
        else if(customerType.getValue().equals(CustomerType.CUSTOMER)) {
            ((Stage) select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("customerFXMLs/CustomersDisplayScreen.fxml"));
        }
        else if(customerType.getValue().equals(CustomerType.CUSTOMERB2B)) {
            ((Stage) select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("customerFXMLs/CustomersB2BDisplayScreen.fxml"));
        }
    }

    @FXML
    public void getBack() throws Exception{
       FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getClassLoader().getResource("adminManagerFXMLs/EmployeeMainMenu.fxml"));
       Pane pane = fxmlLoader.load();
       Scene scene = new Scene(pane);
        ((Stage)back.getScene().getWindow()).setScene(scene);
    }
}
