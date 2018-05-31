package com.leszeknowinski.controllers.adminManagerControllers;

import com.leszeknowinski.Vehicle.VehicleRepository;
import com.leszeknowinski.controllers.ControllersHelper;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DriverMainMenuForEmployeeController {

    @FXML
    Button startOrder;

    @FXML
    Button showOrder;

    @FXML
    Button finishOrder;

    @FXML
    Button showVehicle;

    @FXML
    Button back;

    @FXML
    Button exit;

    ControllersHelper controllersHelper = new ControllersHelper();


    @FXML
    public void loadStartOrderScreen() throws Exception {
        ((Stage) startOrder.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("driverFXMLs/DriverOrderAcceptationScreen.fxml"));
    }

    @FXML
    public void loadAllOrdersScreen() throws Exception {
        ((Stage) showOrder.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("orderFXMLs/AllOrdersScreen.fxml"));
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
    public void getBack()throws Exception{
        ((Stage) back.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("adminManagerFXMLs/EmployeeMainMenu.fxml"));
    }

    @FXML
    public void getOut(){
        Platform.exit();
    }

    }

