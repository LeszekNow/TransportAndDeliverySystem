package com.leszeknowinski.controllers.vehicleControllers;

import com.leszeknowinski.DataBaseSupport.DBHandler;
import com.leszeknowinski.Vehicle.Bus;
import com.leszeknowinski.Vehicle.VehicleRepository;
import com.leszeknowinski.controllers.ControllersHelper;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class BusShowController implements Initializable {

    @FXML
    TextArea show;

    @FXML
    ChoiceBox<String> choiceOption;

    @FXML
    TextField idOrMileage;

    @FXML
    Button delete;

    @FXML
    Button back;

    @FXML
    Button exit;

    @FXML
    Label message;

    VehicleRepository vehicleRepository = new VehicleRepository();
    DBHandler dbHandler = new DBHandler();
    ControllersHelper controllersHelper = new ControllersHelper();

    public void initialize(URL location, ResourceBundle resources) {
        showBuses();
        loadOptions();
    }

    @FXML
    public void showBuses() {
        for(Bus bus : vehicleRepository.getBuses()){
            show.appendText(bus.toString() +"\n");
        }
    }

    public void showRefreshedBusesList(){
        show.clear();
        for(Bus bus : vehicleRepository.getBuses()){
            show.appendText(bus.toString() +"\n");
        }
    }

    @FXML
    public void loadOptions() {
        choiceOption.getItems().add("Id:");
        choiceOption.getItems().add("Mileage:");
    }

    @FXML
    public void executeVehicleDeleting() {
        if(choiceOption.getValue() == null){
            message.setText("You have to choose an option before clicking delete!");
        }
        else if (choiceOption.getValue().equals("Id:")) {
            dbHandler.connectToDataBase("DELETE FROM tvehicle WHERE id = " + Integer.parseInt(idOrMileage.getText()) + ";");
            message.setText("Vehicle was removed successfully!");
            showRefreshedBusesList();
        } else if (choiceOption.getValue().equals("Mileage:")) {
            dbHandler.connectToDataBase("DELETE FROM tvehicle WHERE mileage > " + Integer.parseInt(idOrMileage.getText()) + ";");
            message.setText("Vehicle was removed successfully!");
            showRefreshedBusesList();
        }
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
