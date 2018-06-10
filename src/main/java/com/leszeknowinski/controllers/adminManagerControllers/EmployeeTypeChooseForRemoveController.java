package com.leszeknowinski.controllers.adminManagerControllers;

import com.leszeknowinski.User.EmployeeType;
import com.leszeknowinski.controllers.ControllersHelper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeTypeChooseForRemoveController implements Initializable {

    @FXML
    ChoiceBox<EmployeeType>employeeType;

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
        employeeType.getItems().add(EmployeeType.ADMIN);
        employeeType.getItems().add(EmployeeType.DRIVER);
        employeeType.getItems().add(EmployeeType.MANAGER);
    }

    @FXML
    public void executeEmployeeDeleting()throws Exception{
        ControllersHelper controllersHelper = new ControllersHelper();
        if(employeeType.getValue() == null){
            message.setText("You have to choose an option before clicking select!");
        }
        else if(employeeType.getValue().equals(EmployeeType.ADMIN)) {
            ((Stage) select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("adminManagerFXMLs/AdminShowScreen.fxml"));
        }
        else if(employeeType.getValue().equals(EmployeeType.DRIVER)){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("driverFXMLs/DriverShowScreen.fxml"));
        }
        else if(employeeType.getValue().equals(EmployeeType.MANAGER)){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("adminManagerFXMLs/ManagerShowScreen.fxml"));
        }
    }

    @FXML
    public void getBack() throws Exception{
        ((Stage)back.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("adminManagerFXMLs/EmployeeMainMenu.fxml"));
    }
}
