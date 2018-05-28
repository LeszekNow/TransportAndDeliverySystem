package com.leszeknowinski.controllers.locationControllers;

import com.leszeknowinski.DataBaseSupport.DBHandler;
import com.leszeknowinski.GPS.GeoHelper;
import com.leszeknowinski.GPS.Location;
import com.leszeknowinski.controllers.ControllersHelper;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LocationShowController implements Initializable {

    @FXML
    TextArea show;

    @FXML
    TextField id;

    @FXML
    Button delete;

    @FXML
    Button back;

    @FXML
    Button exit;

    @FXML
    Label message;

    GeoHelper geoHelper = new GeoHelper();
    DBHandler dbHandler = new DBHandler();
    ControllersHelper controllersHelper = new ControllersHelper();

    public void initialize(URL location, ResourceBundle resources) {
        showLocations();
    }

    @FXML
    public void showLocations() {
        for(Location location : geoHelper.getAllLocations()){
            show.appendText(location.toString() +"\n");
        }
    }

    public void showRefreshedLocationsList(){
        show.clear();
        for(Location location : geoHelper.getAllLocations()){
            show.appendText(location.toString() +"\n");
        }
    }

    @FXML
    public void executeLocationDeleting() {
            dbHandler.connectToDataBase("DELETE FROM tlocation WHERE id = " + Integer.parseInt(id.getText()) + ";");
            message.setText("Location removed successfully!");
            showRefreshedLocationsList();
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
