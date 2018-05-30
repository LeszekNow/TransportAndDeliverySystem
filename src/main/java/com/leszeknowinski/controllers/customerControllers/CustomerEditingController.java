package com.leszeknowinski.controllers.customerControllers;

import com.leszeknowinski.App.UserData;
import com.leszeknowinski.DataBaseSupport.DBHandler;
import com.leszeknowinski.DataBaseSupport.DBUserHelper;
import com.leszeknowinski.User.Customer;
import com.leszeknowinski.controllers.ControllersHelper;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CustomerEditingController {

    @FXML
    TextField name;

    @FXML
    TextField surname;

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
    public void updateCustomer(){
        dbHandler.connectToDataBase("UPDATE tclient SET (name, surname, phone) VALUES('" + name.getText() + "', '" + surname.getText() + "', '" + phone.getText() + "') WHERE username = '" + UserData.getInstance().getUsernameMemory() + "';");
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
