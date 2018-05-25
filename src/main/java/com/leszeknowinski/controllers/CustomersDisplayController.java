package com.leszeknowinski.controllers;

import com.leszeknowinski.DataBaseSupport.DBHandler;
import com.leszeknowinski.User.Customer;
import com.leszeknowinski.User.UserRepository;
import com.leszeknowinski.Vehicle.Truck;
import com.leszeknowinski.Vehicle.VehicleRepository;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomersDisplayController implements Initializable {

    @FXML
    TextArea show;

    @FXML
    Button back;

    @FXML
    Button exit;


    UserRepository userRepository = new UserRepository();
    DBHandler dbHandler = new DBHandler();
    ControllersHelper controllersHelper = new ControllersHelper();

    public void initialize(URL location, ResourceBundle resources) {
        showCustomers();
    }

    @FXML
    public void showCustomers() {
        for(Customer customer: userRepository.getCustomer()){
            show.appendText(customer.toString() +"\n");
        }
    }

    @FXML
    public void getBack()throws Exception{
        ((Stage)back.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("EmployeeMainMenu.fxml"));
    }

    @FXML
    public void getOut(){
        Platform.exit();
    }
}
