package com.leszeknowinski.controllers.customerControllers;

import com.leszeknowinski.App.UserData;
import com.leszeknowinski.DataBaseSupport.DBHandler;
import com.leszeknowinski.DataBaseSupport.DBUserHelper;
import com.leszeknowinski.User.CustomerB2B;
import com.leszeknowinski.controllers.ControllersHelper;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CustomerB2BEditingController {

    @FXML
    TextField company;

    @FXML
    TextField nip;

    @FXML
    TextField phone;

    @FXML
    Button submit;

    @FXML
    Button back;

    @FXML
    Button exit;

    @FXML
    Label message;

    DBHandler dbHandler = new DBHandler();

    @FXML
    public void updateCustomerB2B(){
        dbHandler.connectToDataBase("UPDATE tclient SET (company, nip, phone) VALUES('" + company.getText() + "', '" + nip.getText() + "', '" + phone.getText() + "') WHERE username = '" + UserData.getInstance().getUsernameMemory() + "';");
        message.setText("Account updated successfully!");
    }

    @FXML
    public void getBack() throws Exception{
        ControllersHelper controllersHelper = new ControllersHelper();
        ((Stage)submit.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("customerFXMLs/CustomerMainMenuScreen.fxml"));
    }

    @FXML
    public void getOut(){
        Platform.exit();
    }
}
