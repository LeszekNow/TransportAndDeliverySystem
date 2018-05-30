package com.leszeknowinski.controllers.driverControllers;

import com.leszeknowinski.Vehicle.VehicleRepository;
import com.leszeknowinski.controllers.ControllersHelper;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

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
    Button back;

    @FXML
    Button exit;

    ControllersHelper controllersHelper = new ControllersHelper();
    VehicleRepository vehicleRepository = new VehicleRepository();

    public void initialize(URL location, ResourceBundle resources) {

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
    public void getBack() throws Exception {
        ((Stage) back.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("adminManagerFXMLs/EmployeeMenu.fxml"));
    }

    @FXML
    public void getOut() {
        Platform.exit();
    }


}

