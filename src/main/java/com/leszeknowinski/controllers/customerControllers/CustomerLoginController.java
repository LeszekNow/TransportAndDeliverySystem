package com.leszeknowinski.controllers.customerControllers;

import com.leszeknowinski.App.LogIn;
import com.leszeknowinski.App.UserData;
import com.leszeknowinski.controllers.ControllersHelper;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

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
        UserData.getInstance().setUsernameMemory(username.getText());
        if(LogIn.authenticate(username.getText(), password.getText(), "client")) {
                ((Stage) go.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("customerFXMLs/CustomerMainMenuScreen.fxml"));
        } else{
            message.setText("Invalid username or password!\nTry again.");
        }
    }

    @FXML
    public void getBack()throws Exception{
        ((Stage) back.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("customerFXMLs/CustomerStartScreen.fxml"));

    }

}