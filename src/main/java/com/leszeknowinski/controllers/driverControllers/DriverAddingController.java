package com.leszeknowinski.controllers.driverControllers;

import com.leszeknowinski.DataBaseSupport.DBUserHelper;
import com.leszeknowinski.User.Driver;
import com.leszeknowinski.User.DrivingLicenceType;
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
    ChoiceBox<DrivingLicenceType> drivingLicence;

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
        drivingLicence.getItems().add(DrivingLicenceType.A);
        drivingLicence.getItems().add(DrivingLicenceType.B);
        drivingLicence.getItems().add(DrivingLicenceType.C);
        drivingLicence.getItems().add(DrivingLicenceType.D);
        drivingLicence.getItems().add(DrivingLicenceType.AB);
        drivingLicence.getItems().add(DrivingLicenceType.BC);
        drivingLicence.getItems().add(DrivingLicenceType.ABC);
        drivingLicence.getItems().add(DrivingLicenceType.BCD);
        drivingLicence.getItems().add(DrivingLicenceType.ABCD);
        drivingLicence.getItems().add(DrivingLicenceType.ALL);
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
