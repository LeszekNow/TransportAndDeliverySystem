package com.leszeknowinski.controllers.customerControllers;

import com.leszeknowinski.DataBaseSupport.DBHandler;
import com.leszeknowinski.User.CustomerB2B;
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

public class CustomerB2BShowController implements Initializable {

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
        showCustomersB2B();
    }

    @FXML
    public void showCustomersB2B() {
        for (CustomerB2B b2B : userRepository.getCustomerB2B()) {
            show.appendText(b2B.toString() + "\n");
        }
    }

    @FXML
    public void showRefreshedCustomersB2BList() {
        show.clear();
        for (CustomerB2B b2B : userRepository.getCustomerB2B()) {
            show.appendText(b2B.toString() + "\n");
        }
    }

    @FXML
    public void executeCustomerB2BDeleting() {
        dbHandler.connectToDataBase("DELETE FROM tclient WHERE id = " + Integer.parseInt(id.getText()) + ";");
        message.setText("Customer removed successfully!");
        showRefreshedCustomersB2BList();
    }

    @FXML
    public void getBack() throws Exception {
        ((Stage) delete.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("adminManagerFXMLs/EmployeeMainMenu.fxml"));
    }

    @FXML
    public void getOut() {
        Platform.exit();
    }
}
