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

public class StartMenuController implements Initializable {

    @FXML
    ChoiceBox<String>userType;

    @FXML
    Button go;

    @FXML
    Button exit;


    public void initialize(URL location, ResourceBundle resources) {
        loadOptions();
    }

    @FXML
    public void loadOptions(){
        userType.getItems().add("Customer");
        userType.getItems().add("Employee");
    }

    @FXML
    public void getOut(){
        System.exit(0);
    }

    @FXML
    public void displayUserMenu() throws Exception{
        String user = userType.getValue();
        FXMLLoader fxmlLoader;
        Pane pane;
        Scene scene;
        if(user.equals("Customer")){
            fxmlLoader = new FXMLLoader(this.getClass().getClassLoader().getResource("CustomerStartScreen.fxml"));
            pane = fxmlLoader.load();
            scene = new Scene(pane);
            ((Stage)userType.getScene().getWindow()).setScene(scene);
        }
        else if(user.equals("Employee")){
            fxmlLoader = new FXMLLoader(this.getClass().getClassLoader().getResource("EmployeeMenu.fxml"));
            pane = fxmlLoader.load();
            scene = new Scene(pane);
            ((Stage)userType.getScene().getWindow()).setScene(scene);

        }

    }


}
