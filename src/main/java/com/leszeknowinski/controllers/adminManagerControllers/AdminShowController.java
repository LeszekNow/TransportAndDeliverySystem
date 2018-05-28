package com.leszeknowinski.controllers.adminManagerControllers;

import com.leszeknowinski.DataBaseSupport.DBHandler;
import com.leszeknowinski.User.Admin;
import com.leszeknowinski.User.UserRepository;
import com.leszeknowinski.controllers.ControllersHelper;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminShowController implements Initializable {

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
        showAdmins();
    }

    @FXML
    public void showAdmins() {
        for(Admin admin : userRepository.getAdmin()){
            show.appendText(admin.toString() +"\n");
        }
    }

    public void showRefreshedAdminsList(){
        show.clear();
        for(Admin admin : userRepository.getAdmin()){
            show.appendText(admin.toString() +"\n");
        }
    }

    @FXML
    public void executeEmployeeDeleting() {
            dbHandler.connectToDataBase("DELETE FROM tadmin WHERE id = " + Integer.parseInt(id.getText()) + ";");
            message.setText("Employee removed successfully!");
            showRefreshedAdminsList();
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
