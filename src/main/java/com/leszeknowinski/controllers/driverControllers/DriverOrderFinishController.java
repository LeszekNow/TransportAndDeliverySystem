package com.leszeknowinski.controllers.driverControllers;

import com.leszeknowinski.App.UserData;
import com.leszeknowinski.DataBaseSupport.DBHandler;
import com.leszeknowinski.Order.Order;
import com.leszeknowinski.Order.OrderRepository;
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

public class DriverOrderFinishController implements Initializable {

    @FXML
    TextArea show;

    @FXML
    Button finish;

    @FXML
    Button back;

    @FXML
    Button exit;

    DBHandler dbHandler = new DBHandler();
    ControllersHelper controllersHelper = new ControllersHelper();
    OrderRepository orderRepository = new OrderRepository();

    public void initialize(URL location, ResourceBundle resources) {
        showOrder();
    }

    @FXML
    public void showOrder() {
        int driverId = dbHandler.getSthIdFromDB("SELECT id FROM tdriver WHERE username = '" + UserData.getInstance().getUsernameMemory() + "';");
        for (Order order : orderRepository.getDriverOrders(driverId)) {
            show.appendText(order.toString2());
        }
    }

    @FXML
    public void finishOrder() {
        dbHandler.connectToDataBase("UPDATE torder SET inProgress = false, completed = true WHERE driverId = " + dbHandler.getSthIdFromDB("SELECT id FROM tdriver WHERE username = '" + UserData.getInstance().getUsernameMemory() + "';"));
        int driverId = dbHandler.getSthIdFromDB("SELECT id FROM tdriver WHERE username = '" + UserData.getInstance().getUsernameMemory() + "';");
        double mileage = dbHandler.getDoubleFromDB("SELECT distance FROM torder WHERE driverId = " + driverId + ";", "distance");
        int adjustedMileage = (int)mileage;
        int vehicleId = dbHandler.getIntFromDB("SELECT vehicleId FROM torder WHERE driverId = " + driverId + ";", "vehicleId");
        dbHandler.connectToDataBase("UPDATE tvehicle SET mileage = mileage + " + adjustedMileage + " WHERE id = " + vehicleId + ";");
        dbHandler.connectToDataBase("UPDATE tdriver SET arrested = false WHERE id = " + driverId + ";");
        dbHandler.connectToDataBase("UPDATE tvehicle SET arrested = false WHERE id = " + vehicleId + ";");
        dbHandler.connectToDataBase("DELETE FROM tcargo WHERE vehicleId = " + vehicleId + ";");
        dbHandler.connectToDataBase("DELETE FROM torder WHERE driverId = " + driverId + ";");
        show.clear();
        show.setText("Order realisation has ended!\nDriver and Vehicle released!\nGreat job!.");
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
