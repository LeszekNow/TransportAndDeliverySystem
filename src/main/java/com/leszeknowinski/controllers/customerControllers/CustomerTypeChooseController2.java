package com.leszeknowinski.controllers.customerControllers;

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
    ChoiceBox<String>customerType;

    @FXML
    Button select;

    @FXML
    Button back;

    @FXML
    Label message;


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
        ControllersHelper controllersHelper = new ControllersHelper();
        if(customerType.getValue() == null){
            message.setText("You have to choose an option before clicking select!");
        }
        else if(customerType.getValue().equals("Customer")) {
            ((Stage) select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("customerFXMLs/CustomersDisplayScreen.fxml"));
        }
        else if(customerType.getValue().equals("Customer B2B / VAT")) {
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