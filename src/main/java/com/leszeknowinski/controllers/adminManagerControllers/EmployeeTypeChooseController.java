package com.leszeknowinski.controllers.adminManagerControllers;

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

public class EmployeeTypeChooseController implements Initializable {

    @FXML
    ChoiceBox<String>employeeType;

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
        employeeType.getItems().add("admin");
        employeeType.getItems().add("driver");
        employeeType.getItems().add("manager");
    }

    @FXML
    public void executeEmployeeAdding()throws Exception{
        ControllersHelper controllersHelper = new ControllersHelper();
        if(employeeType.getValue() == null){
            message.setText("You have to choose an option before clicking select!");
        }
        else if(employeeType.getValue().equals("admin")) {
            ((Stage) select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("adminManagerFXMLs/AdminAddingScreen.fxml"));
        }
        else if(employeeType.getValue().equals("driver")){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("driverFXMLs/DriverAddingScreen.fxml"));
        }
        else if(employeeType.getValue().equals("manager")){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("adminManagerFXMLs/ManagerAddingScreen.fxml"));
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
