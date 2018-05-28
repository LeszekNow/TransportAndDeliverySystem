package com.leszeknowinski.controllers.adminManagerControllers;

import com.leszeknowinski.DataBaseSupport.DBHandler;
import com.leszeknowinski.User.Manager;
import com.leszeknowinski.User.UserRepository;
import com.leszeknowinski.controllers.ControllersHelper;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ManagerShowController implements Initializable {

    @FXML
    TextArea show;

    @FXML
    TextField id;

    @FXML
    Button delete;

    @FXML
    Button back;

    @FXML
    Button exit;

    @FXML
    Label message;

    UserRepository userRepository = new UserRepository();
    DBHandler dbHandler = new DBHandler();
    ControllersHelper controllersHelper = new ControllersHelper();

    public void initialize(URL location, ResourceBundle resources) {
        showManagers();
    }

    @FXML
    public void showManagers() {
        for(Manager manager : userRepository.getManager()){
            show.appendText(manager.toString() +"\n");
        }
    }

    public void showRefreshedManagersList(){
        show.clear();
        for(Manager manager : userRepository.getManager()){
            show.appendText(manager.toString() +"\n");
        }
    }

    @FXML
    public void executeEmployeeDeleting() {
            dbHandler.connectToDataBase("DELETE FROM tmanager WHERE id = " + Integer.parseInt(id.getText()) + ";");
            message.setText("Employee removed successfully!");
            showRefreshedManagersList();
    }

    @FXML
    public void getBack()throws Exception{
        ((Stage) delete.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("adminManagerFXMLs/EmployeeMainMenu.fxml"));
    }

    @FXML
    public void getOut(){
        Platform.exit();
    }
}
