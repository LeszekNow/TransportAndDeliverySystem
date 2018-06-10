package com.leszeknowinski.controllers;

import com.leszeknowinski.User.UserType;
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

public class StartMenuController implements Initializable {

    @FXML
    ChoiceBox<UserType>userType;

    @FXML
    Button go;

    @FXML
    Button exit;

    @FXML
    Label message;


    public void initialize(URL location, ResourceBundle resources) {
        loadOptions();
    }

    @FXML
    public void loadOptions(){
        userType.getItems().add(UserType.CUSTOMER);
        userType.getItems().add(UserType.EMPLOYEE);
    }

    @FXML
    public void getOut(){
        System.exit(0);
    }

    @FXML
    public void displayUserMenu() throws Exception{
        FXMLLoader fxmlLoader;
        Pane pane;
        Scene scene;
        if(userType.getValue() == null) {
            message.setText("You have to choose an option before clicking go!");
        }
        else if(userType.getValue().equals(UserType.CUSTOMER)){
            fxmlLoader = new FXMLLoader(this.getClass().getClassLoader().getResource("customerFXMLs/CustomerStartScreen.fxml"));
            pane = fxmlLoader.load();
            scene = new Scene(pane);
            ((Stage)userType.getScene().getWindow()).setScene(scene);
        }
        else if(userType.getValue().equals(UserType.EMPLOYEE)){
            fxmlLoader = new FXMLLoader(this.getClass().getClassLoader().getResource("adminManagerFXMLs/EmployeeMenu.fxml"));
            pane = fxmlLoader.load();
            scene = new Scene(pane);
            ((Stage)userType.getScene().getWindow()).setScene(scene);
        }

    }


}
