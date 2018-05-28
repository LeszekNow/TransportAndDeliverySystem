package com.leszeknowinski.controllers.adminManagerControllers;

import com.leszeknowinski.App.LogIn;
import com.leszeknowinski.App.UserData;
import com.leszeknowinski.controllers.ControllersHelper;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeMenuController implements Initializable {
    //For managers and admins

    @FXML
    ChoiceBox<String> employeeType;

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

    public void initialize(URL location, ResourceBundle resources) {
        loadOptions();
    }

    @FXML
    public void loadOptions() {
        employeeType.getItems().add("admin");
        employeeType.getItems().add("driver");
        employeeType.getItems().add("manager");
    }



    @FXML
    public void login() throws Exception {
        UserData.getInstance().setUsernameMemory(username.getText());
        UserData.getInstance().setUserTypeMemory(employeeType.getValue());
        if(LogIn.authenticate(username.getText(), password.getText(), employeeType.getValue())) {
            if(employeeType.getValue().equals("admin")) {
                ((Stage)go.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("adminManagerFXMLs/EmployeeMainMenu.fxml"));
            }
            else if(employeeType.getValue().equals("manager")){
                ((Stage)go.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("adminManagerFXMLs/EmployeeMainMenu.fxml"));
            }
            else if(employeeType.getValue().equals("driver")){
                ((Stage)go.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("driverFXMLs/DriverMainMenuScreen.fxml"));
            }
        } else{
            message.setText("Invalid username or password!\nTry again.");
        }
    }

    @FXML
    public void getBack()throws Exception{
        getStartMenu();

    }

    public void getStartMenu() throws Exception{
        FXMLLoader fxmlLoader;
        Pane pane;
        Scene scene;
        fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("StartMenu.fxml"));
        pane = fxmlLoader.load();
        scene = new Scene(pane);
        ((Stage) back.getScene().getWindow()).setScene(scene);
    }


}