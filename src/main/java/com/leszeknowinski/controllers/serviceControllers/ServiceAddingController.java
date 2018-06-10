package com.leszeknowinski.controllers.serviceControllers;

import com.leszeknowinski.Cargo.CargoType;
import com.leszeknowinski.DataBaseSupport.DBUserHelper;
import com.leszeknowinski.User.Admin;
import com.leszeknowinski.controllers.ControllersHelper;
import com.leszeknowinski.service.Service;
import com.leszeknowinski.service.ServiceRepository;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ServiceAddingController implements Initializable {

    @FXML
    ChoiceBox<CargoType> category;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadOptions();
    }

    @FXML
    public void loadOptions(){
        category.getItems().add(CargoType.CARGO);
        category.getItems().add(CargoType.PACKAGE);
        category.getItems().add(CargoType.PEOPLE);
    }

    @FXML
    public void createService(){
        Service service = new Service(category.getValue(), description.getText(), Double.parseDouble(price.getText()));
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
