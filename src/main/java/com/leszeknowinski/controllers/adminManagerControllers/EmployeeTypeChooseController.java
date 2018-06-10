package com.leszeknowinski.controllers.adminManagerControllers;

import com.leszeknowinski.User.EmployeeType;
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
    ChoiceBox<EmployeeType>employeeType;

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
        employeeType.getItems().add(EmployeeType.ADMIN);
        employeeType.getItems().add(EmployeeType.DRIVER);
        employeeType.getItems().add(EmployeeType.MANAGER);
    }

    @FXML
    public void executeEmployeeAdding()throws Exception{
        ControllersHelper controllersHelper = new ControllersHelper();
        if(employeeType.getValue() == null){
            message.setText("You have to choose an option before clicking select!");
        }
        else if(employeeType.getValue().equals(EmployeeType.ADMIN)) {
            ((Stage) select.getScene().getWindow()).setScene(controllersHelper.loadFXMLAnchorPaneScreen("adminManagerFXMLs/AdminAddingScreen.fxml"));
        }
        else if(employeeType.getValue().equals(EmployeeType.DRIVER)){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLAnchorPaneScreen("driverFXMLs/DriverAddingScreen.fxml"));
        }
        else if(employeeType.getValue().equals(EmployeeType.MANAGER)){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLAnchorPaneScreen("adminManagerFXMLs/ManagerAddingScreen.fxml"));
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
