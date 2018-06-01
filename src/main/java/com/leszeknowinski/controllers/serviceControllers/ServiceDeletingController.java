package com.leszeknowinski.controllers.serviceControllers;

import com.leszeknowinski.DataBaseSupport.DBHandler;
import com.leszeknowinski.controllers.ControllersHelper;
import com.leszeknowinski.service.ServiceRepository;
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

public class ServiceDeletingController implements Initializable {

    @FXML
    TextField serviceId;

    @FXML
    Button deleteService;

    @FXML
    Button back;

    @FXML
    Button exit;

    @FXML
    TextArea show;

    @FXML
    Label message;

    ControllersHelper controllersHelper = new ControllersHelper();
    ServiceRepository serviceRepository = new ServiceRepository();
    DBHandler dbHandler = new DBHandler();

    public void initialize(URL location, ResourceBundle resources) {
            loadAllServices();
    }

    @FXML
    public void removeService() {
        if (serviceId == null) {
            message.setText("You have to enter service id first!");
        } else {
            dbHandler.connectToDataBase("DELETE FROM tservice WHERE id = " + Integer.parseInt(serviceId.getText()) + ";");
            message.setText("Service removed successfully!");
        }
    }

    @FXML
    public void loadAllServices(){

        serviceRepository.showServices(serviceRepository.getServices(), show);
    }

    @FXML
    public void getBack() throws Exception{
        ((Stage)back.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("adminManagerFXMLs/EmployeeMainMenu.fxml"));
    }

    @FXML
    public void getOut(){
        Platform.exit();
    }



}
