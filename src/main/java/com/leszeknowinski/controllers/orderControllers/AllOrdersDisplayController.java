package com.leszeknowinski.controllers.orderControllers;

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

public class AllOrdersDisplayController implements Initializable {

    @FXML
    TextArea show;

    @FXML
    Button showMyOrder;

    @FXML
    Button back;

    @FXML
    Button exit;

    DBHandler dbHandler = new DBHandler();
    ControllersHelper controllersHelper = new ControllersHelper();
    OrderRepository orderRepository = new OrderRepository();

    public void initialize(URL location, ResourceBundle resources) {
    showAllOrders();
    }

    @FXML
    public void showAllOrders() {
        for(Order order : orderRepository.getAllOrders()){
            show.appendText(order.toString2() + "\n");
        }
        }

        @FXML
        public void showMyOrderSummary(){
        int driverId = dbHandler.getSthIdFromDB("SELECT id FROM tdriver WHERE username = '" + UserData.getInstance().getUsernameMemory() + "';");
        for(Order order : orderRepository.getDriverOrders(driverId)){
            show.clear();
            show.appendText(order.toString2() + "\n");
        }
        }

    @FXML
    public void getBack()throws Exception{
        ((Stage)back.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("driverFXMLs/DriverMainMenuScreen.fxml"));
    }

    @FXML
    public void getOut(){
        Platform.exit();
    }
}
