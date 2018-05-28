package com.leszeknowinski.controllers.adminManagerControllers;

import com.leszeknowinski.controllers.ControllersHelper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeTypeChooseForRemoveController implements Initializable {

    @FXML
    ChoiceBox<String>employeeType;

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
        employeeType.getItems().add("admin");
        employeeType.getItems().add("driver");
        employeeType.getItems().add("manager");
    }

    @FXML
    public void executeEmployeeDeleting()throws Exception{
        String employee = employeeType.getValue();
        ControllersHelper controllersHelper = new ControllersHelper();
        if(employee.equals("admin")) {
            ((Stage) select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("adminManagerFXMLs/AdminShowScreen.fxml"));
        }
        else if(employee.equals("driver")){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("driverFXMLs/DriverShowScreen.fxml"));
        }
        else if(employee.equals("manager")){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("adminManagerFXMLs/ManagerShowScreen.fxml"));
        }
    }

    @FXML
    public void getBack() throws Exception{
        ((Stage)back.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("adminManagerFXMLs/EmployeeMainMenu.fxml"));
    }
}
