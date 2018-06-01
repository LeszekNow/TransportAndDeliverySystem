package com.leszeknowinski.controllers.serviceControllers;

import com.leszeknowinski.DataBaseSupport.DBUserHelper;
import com.leszeknowinski.User.Admin;
import com.leszeknowinski.controllers.ControllersHelper;
import com.leszeknowinski.service.Service;
import com.leszeknowinski.service.ServiceRepository;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ServiceAddingController {

    @FXML
    TextField category;

    @FXML
    TextField description;

    @FXML
    TextField price;

    @FXML
    Button submit;

    @FXML
    Button back;

    @FXML
    Button exit;

    @FXML
    Label message;

    ControllersHelper controllersHelper = new ControllersHelper();
    ServiceRepository serviceRepository = new ServiceRepository();

    @FXML
    public void createService(){
        Service service = new Service(category.getText(), description.getText(), Double.parseDouble(price.getText()));
        serviceRepository.insertService(service);
        message.setText("New service added successfully!");
    }

    @FXML
    public void getBack() throws Exception{
        ((Stage)submit.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("adminManagerFXMLs/EmployeeMainMenu.fxml"));
    }

    @FXML
    public void getOut(){
        Platform.exit();
    }


}
