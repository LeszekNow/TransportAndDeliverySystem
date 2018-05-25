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

public class EmployeeTypeChooseController implements Initializable {

    @FXML
    ChoiceBox<String>employeeType;

    @FXML
    Button select;

    @FXML
    Button back;


    public void initialize(URL location, ResourceBundle resources) {
    loadOptions();
    }

    @FXML
    public void loadOptions(){
        employeeType.getItems().add("admin");
        employeeType.getItems().add("driver");
        employeeType.getItems().add("manager");
    }

    @FXML
    public void executeEmployeeAdding()throws Exception{
        String employee = employeeType.getValue();
        ControllersHelper controllersHelper = new ControllersHelper();
        if(employee.equals("admin")) {
            ((Stage) select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("AdminAddingScreen.fxml"));
        }
        else if(employee.equals("driver")){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("DriverAddingScreen.fxml"));
        }
        else if(employee.equals("manager")){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("ManagerAddingScreen.fxml"));
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
