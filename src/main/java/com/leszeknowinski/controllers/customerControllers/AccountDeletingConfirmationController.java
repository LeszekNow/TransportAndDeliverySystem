package com.leszeknowinski.controllers.customerControllers;

import com.leszeknowinski.App.LogIn;
import com.leszeknowinski.App.UserData;
import com.leszeknowinski.DataBaseSupport.DBHandler;
import com.leszeknowinski.controllers.ControllersHelper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.concurrent.TimeUnit;

public class AccountDeletingConfirmationController {

    @FXML
    TextField username;

    @FXML
    PasswordField password;

    @FXML
    Button delete;

    @FXML
    Button back;

    @FXML
    Label message;

    ControllersHelper controllersHelper = new ControllersHelper();
    DBHandler dbHandler = new DBHandler();


    @FXML
    public void validateData() throws Exception {
        if(LogIn.authenticate(username.getText(), password.getText(), "client")) {
            dbHandler.connectToDataBase("DELETE FROM tclient WHERE username = '" + username.getText() + "';");
            message.setText("Account removed successfully");
            TimeUnit.SECONDS.sleep(3);
            loadCustomerStartScreen();
                } else{
            message.setText("Invalid username or password!\nTry again.");
        }
    }

    @FXML
    public void loadCustomerStartScreen()throws Exception{
        ((Stage)delete.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("customerFXMLs/CustomerStartScreen.fxml"));
    }

    @FXML
    public void getBack()throws Exception{
        ((Stage) back.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("customerFXMLs/CustomerMainMenuScreen.fxml"));

    }

}