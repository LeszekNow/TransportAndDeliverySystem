package com.leszeknowinski.controllers.locationControllers;

import com.leszeknowinski.DataBaseSupport.DBHandler;
import com.leszeknowinski.GPS.GPSRandomDataGenerator;
import com.leszeknowinski.GPS.GeoHelper;
import com.leszeknowinski.Vehicle.Car;
import com.leszeknowinski.Vehicle.VehicleRepository;
import com.leszeknowinski.controllers.ControllersHelper;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class VehicleTrackChooseController implements Initializable {

    @FXML
    TextArea show;

    @FXML
    TextField vehicleId;

    @FXML
    Button track;

    @FXML
    Button clear;

    @FXML
    Button back;

    @FXML
    Button exit;

    public void initialize(URL location, ResourceBundle resources) {
        showAllArrestedVehicles();
    }


    VehicleRepository vehicleRepository = new VehicleRepository();
    GeoHelper geoHelper = new GeoHelper();
    DBHandler dbHandler = new DBHandler();
    ControllersHelper controllersHelper = new ControllersHelper();
    GPSRandomDataGenerator gpsRandomDataGenerator = new GPSRandomDataGenerator();

    @FXML
    public void showAllArrestedVehicles() {
        for(Car car : vehicleRepository.getAllArrestedVehicles()){
            show.appendText(car.toString() + "\n");
        }
    }

    @FXML
    public void trackSelectedVehicle() {
        int id = Integer.parseInt(vehicleId.getText());
        int location = gpsRandomDataGenerator.getRandomIdOfLocation();
        show.clear();
        show.appendText(vehicleRepository.getVehicle(id).toString() + "\nLocation: " +
                dbHandler.getStringFromDB("SELECT city FROM tlocation WHERE id = " + location + ";", "city" ) + "\nDistance from base: " +
        geoHelper.getDistanceInKM(geoHelper.getLatitude("Krakow"), geoHelper.getLatitude(location), geoHelper.getLongitude("Krakow"), geoHelper.getLongitude(location)) + "km");
    }

    @FXML
    public void clearScreen(){
        show.clear();
        showAllArrestedVehicles();
    }

    @FXML
    public void getBack() throws Exception {
        ((Stage) back.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("adminManagerFXMLs/EmployeeMainMenu.fxml"));
    }

    @FXML
    public void getOut() {
        Platform.exit();
    }


}
