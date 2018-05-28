package com.leszeknowinski.controllers.driverControllers;

import com.leszeknowinski.App.UserData;
import com.leszeknowinski.DataBaseSupport.DBHandler;
import com.leszeknowinski.Vehicle.Car;
import com.leszeknowinski.Vehicle.VehicleRepository;
import com.leszeknowinski.controllers.ControllersHelper;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AdjustedVehicleShowController implements Initializable {

    @FXML
    TextArea show;

    @FXML
    Button display;

    @FXML
    Button back;

    @FXML
    Button exit;


    VehicleRepository vehicleRepository = new VehicleRepository();
    DBHandler dbHandler = new DBHandler();
    ControllersHelper controllersHelper = new ControllersHelper();

    public void initialize(URL location, ResourceBundle resources) {
        showAllVehicles();
    }

    @FXML
    public void showAllVehicles() {
        for (Car car : vehicleRepository.getAllVehicles()) {
            show.appendText(car.toString() + "\n");
        }
    }

    @FXML
    public void showAdjustedVehicle(){
        int driverId = dbHandler.getSthIdFromDB("SELECT id FROM tdriver WHERE username = '" + UserData.getInstance().getUsernameMemory() + "';");
        int vehicleId = dbHandler.getIntFromDB("SELECT vehicleId FROM torder WHERE driverId = " + driverId + ";", "vehicleId");
        show.clear();
        show.appendText(vehicleRepository.getCar(vehicleId).toString());
        }

    @FXML
    public void getBack() throws Exception {
        ((Stage) back.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("driverFXMLs/DriverMainMenuScreen.fxml"));
    }

    @FXML
    public void getOut() {
        Platform.exit();
    }
}
