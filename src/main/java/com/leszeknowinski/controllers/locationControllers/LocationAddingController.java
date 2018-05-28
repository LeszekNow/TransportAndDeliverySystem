package com.leszeknowinski.controllers.locationControllers;

import com.leszeknowinski.DataBaseSupport.DBHandler;
import com.leszeknowinski.GPS.GeoHelper;
import com.leszeknowinski.GPS.Location;
import com.leszeknowinski.controllers.ControllersHelper;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LocationAddingController {

    @FXML
    TextField city;

    @FXML
    TextField longitude;

    @FXML
    TextField latitude;

    @FXML
    Button submit;

    @FXML
    Button back;

    @FXML
    Button exit;

    @FXML
    Label message;

    @FXML
    public void createLocation(){
        DBHandler dbHandler = new DBHandler();
        GeoHelper geoHelper = new GeoHelper();
        if(city.getText().equals(dbHandler.getStringFromDB("SELECT city FROM tlocation;", "city"))){
            message.setText("Entered location already exist!");
        }else{
            Location location = new Location(city.getText(), Double.parseDouble(longitude.getText()), Double.parseDouble(latitude.getText()));
            geoHelper.insertLocation(location);
            message.setText("New location added successfully!");
        }
    }

    @FXML
    public void getBack() throws Exception{
        ControllersHelper controllersHelper = new ControllersHelper();
        ((Stage)submit.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("adminManagerFXMLs/EmployeeMainMenu.fxml"));
    }

    @FXML
    public void getOut(){
        Platform.exit();
    }
}
