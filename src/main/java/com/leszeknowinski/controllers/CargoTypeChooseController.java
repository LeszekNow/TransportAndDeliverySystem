package com.leszeknowinski.controllers;

import com.leszeknowinski.controllers.ControllersHelper;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CargoTypeChooseController implements Initializable {

    @FXML
    ChoiceBox<String>cargoType;

    @FXML
    Button select;

    @FXML
    Button back;

    ControllersHelper controllersHelper = new ControllersHelper();

    public void initialize(URL location, ResourceBundle resources) {
    loadOptions();
    }

    @FXML
    public void loadOptions(){
        cargoType.getItems().add("Cargo");
        cargoType.getItems().add("Package");
        cargoType.getItems().add("People");
    }

    @FXML
    public void executeChosenOption()throws Exception{
        String cargo = cargoType.getValue();
        ControllersHelper controllersHelper = new ControllersHelper();
        if(cargo.equals("Cargo")) {
            ((Stage) select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("CargoOrderDataScreen.fxml"));
        }
        else if(cargo.equals("Package")){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("PackageOrderDataScreen.fxml"));
        }
        else if(cargo.equals("People")){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("PeopleOrderDataScreen.fxml"));
        }
    }

    @FXML
    public void getBack() throws Exception{
        ((Stage) back.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("CustomerMainMenu.fxml"));
    }
}
