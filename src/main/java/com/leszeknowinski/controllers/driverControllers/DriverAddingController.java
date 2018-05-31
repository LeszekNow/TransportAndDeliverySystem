package com.leszeknowinski.controllers.driverControllers;

import com.leszeknowinski.DataBaseSupport.DBUserHelper;
import com.leszeknowinski.User.Driver;
import com.leszeknowinski.controllers.ControllersHelper;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class DriverAddingController implements Initializable {

    @FXML
    TextField name;

    @FXML
    TextField surname;

    @FXML
    TextField pesel;

    @FXML
    TextField phone;

    @FXML
    TextField username;

    @FXML
    TextField password;

    @FXML
    ChoiceBox<String> drivingLicence;

    @FXML
    ChoiceBox<Integer> experience;

    @FXML
    Button submit;

    @FXML
    Button back;

    @FXML
    Button exit;

    @FXML
    Label message;

    DBUserHelper dbUserHelper = new DBUserHelper();
    ControllersHelper controllersHelper = new ControllersHelper();

    public void initialize(URL location, ResourceBundle resources) {
        loadOptions();
        loadOptions2();
    }

    @FXML
    public void loadOptions(){
        drivingLicence.getItems().add("A");
        drivingLicence.getItems().add("B");
        drivingLicence.getItems().add("C");
        drivingLicence.getItems().add("D");
        drivingLicence.getItems().add("A/B");
        drivingLicence.getItems().add("B/C");
        drivingLicence.getItems().add("A/B/C");
        drivingLicence.getItems().add("B/C/D");
        drivingLicence.getItems().add("A/B/C/D");
        drivingLicence.getItems().add("All");
    }

    @FXML
    public void loadOptions2(){
        experience.getItems().add(1);
        experience.getItems().add(2);
        experience.getItems().add(3);
        experience.getItems().add(5);
        experience.getItems().add(10);
        experience.getItems().add(15);
        experience.getItems().add(20);
        experience.getItems().add(25);
        experience.getItems().add(30);
        experience.getItems().add(35);
        experience.getItems().add(40);
        experience.getItems().add(50);

    }

    @FXML
    public void createDriver(){
        Driver driver = new Driver(name.getText(), surname.getText(), pesel.getText(), phone.getText(),
                username.getText(), password.getText(), drivingLicence.getValue(), experience.getValue(), false);
        dbUserHelper.insertDriver(driver);
        message.setText("New employee added successfully!");
    }

    @FXML
    public void getBack() throws Exception{
        ((Stage)submit.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("adminManagerFXMLs/EmployeeMainMenu.fxml"));
    }

    @FXML
    public void getOut(){
        Platform.exit();
    }


}
