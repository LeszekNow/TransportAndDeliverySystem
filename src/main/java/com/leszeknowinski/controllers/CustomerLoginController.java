package com.leszeknowinski.controllers;

import com.leszeknowinski.App.LogIn;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerLoginController {

    @FXML
    TextField username;

    @FXML
    PasswordField password;

    @FXML
    Button go;

    @FXML
    Button back;

    @FXML
    Label message;

    ControllersHelper controllersHelper = new ControllersHelper();

    @FXML
    public void login() throws Exception {
        if(LogIn.authenticate(username.getText(), password.getText(), "client")) {
                ((Stage) go.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("CustomerMainMenuScreen.fxml"));
        } else{
            message.setText("Invalid username or password!\nTry again.");
        }
    }

    @FXML
    public void getBack()throws Exception{
        ((Stage) back.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("CustomerStartScreen.fxml"));

    }

}