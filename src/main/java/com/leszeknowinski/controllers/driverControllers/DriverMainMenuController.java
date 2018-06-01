package com.leszeknowinski.controllers.driverControllers;

import com.leszeknowinski.Vehicle.Car;
import com.leszeknowinski.Vehicle.VehicleRepository;
import com.leszeknowinski.controllers.ControllersHelper;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.joda.time.DateTime;

import java.net.URL;
import java.util.ResourceBundle;

public class DriverMainMenuController implements Initializable {

    @FXML
    Button startOrder;

    @FXML
    Button showOrders;

    @FXML
    Button finishOrder;

    @FXML
    Button showVehicle;

    @FXML
    TextArea alert;

    @FXML
    TextField vehicleId;

    @FXML
    Button serviceAndInspect;

    @FXML
    Label message;

    @FXML
    Button back;

    @FXML
    Button exit;

    ControllersHelper controllersHelper = new ControllersHelper();
    VehicleRepository vehicleRepository = new VehicleRepository();

    public void initialize(URL location, ResourceBundle resources) {
        setDailyInfo();
    }

    @FXML
    public void loadStartOrderScreen() throws Exception {
        ((Stage) startOrder.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("driverFXMLs/DriverOrderAcceptationScreen.fxml"));
    }

    @FXML
    public void loadAllOrdersScreen() throws Exception {
        ((Stage) showOrders.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("orderFXMLs/AllOrdersScreen.fxml"));
    }

    @FXML
    public void loadFinishOrderScreen() throws Exception {
        ((Stage) finishOrder.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("driverFXMLs/DriverOrderFinishScreen.fxml"));
    }

    @FXML
    public void loadVehiclesShowScreen() throws Exception {
        ((Stage) showVehicle.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("driverFXMLs/AdjustedVehicleShowScreen.fxml"));
    }

    @FXML
    public void serviceAndInspectVehicle(){

    }

    @FXML
    public void setDailyInfo(){
        alert.setText("Welcome!\nToday we have: " + controllersHelper.transformDate(DateTime.now()));
        displayAlerts();
        displayInspectionInfo();
    }

    @FXML
    public void displayInspectionInfo() {
        alert.appendText("\n\nVehicles for technical inspection: \n");
        for (Car car : vehicleRepository.getAllVehicles()) {
            if (controllersHelper.transformStringOnDate(car.getInspectionDate()).compareTo(DateTime.now().minusDays(358)) < 0) {
                alert.appendText("Vehicle id - " + car.getId() + " : " + car.getBrand() + " " + car.getModel() + ", technical inspection date - " + controllersHelper.transformDate(controllersHelper.transformStringOnDate(car.getInspectionDate()).plusDays(365)) + ".\n");
            }
        }
    }

    @FXML
    public void displayAlerts() {
        alert.appendText("\n\nVehicles for service: \n");
        final int serviceInterval = 15000;
        for (Car car : vehicleRepository.getAllVehicles()) {
            if (car.getMileage() % serviceInterval > 14000) {
                alert.appendText("Vehicle id - " + car.getId() + " : " + car.getBrand() + " " + car.getModel() + ", mileage - " + car.getMileage() + "km.\n");
            }
        }
    }


    @FXML
    public void getBack() throws Exception {
        ((Stage) back.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("adminManagerFXMLs/EmployeeMenu.fxml"));
    }

    @FXML
    public void getOut() {
        Platform.exit();
    }


}

