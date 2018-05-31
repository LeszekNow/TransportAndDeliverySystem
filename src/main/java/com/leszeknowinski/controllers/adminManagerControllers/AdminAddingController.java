package com.leszeknowinski.controllers.adminManagerControllers;

import com.leszeknowinski.DataBaseSupport.DBUserHelper;
import com.leszeknowinski.User.Admin;
import com.leszeknowinski.controllers.ControllersHelper;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminAddingController {

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
    Button submit;

    @FXML
    Button back;

    @FXML
    Button exit;

    @FXML
    Label message;

    DBUserHelper dbUserHelper = new DBUserHelper();
    ControllersHelper controllersHelper = new ControllersHelper();

    @FXML
    public void createAdmin(){
        Admin admin = new Admin(name.getText(), surname.getText(), pesel.getText(), phone.getText(),
                username.getText(), password.getText());
        dbUserHelper.insertAdmin(admin);
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
