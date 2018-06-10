package com.leszeknowinski.controllers.orderControllers;

import com.leszeknowinski.Cargo.CargoType;
import com.leszeknowinski.User.DrivingLicenceType;
import com.leszeknowinski.controllers.ControllersHelper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CargoTypeChooseController implements Initializable {

    @FXML
    ChoiceBox<CargoType>cargoType;

    @FXML
    Button select;

    @FXML
    Button back;

    @FXML
    Label message;

    ControllersHelper controllersHelper = new ControllersHelper();

    public void initialize(URL location, ResourceBundle resources) {
    loadOptions();
    }

    @FXML
    public void loadOptions(){
        cargoType.getItems().add(CargoType.CARGO);
        cargoType.getItems().add(CargoType.PACKAGE);
        cargoType.getItems().add(CargoType.PEOPLE);
    }

    @FXML
    public void executeChosenOption()throws Exception{
        if(cargoType.getValue() == null){
            message.setText("You have to choose an option before clicking select!");
        }
        else if(cargoType.getValue().equals(CargoType.CARGO)) {
            ((Stage) select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("orderFXMLs/CargoOrderDataScreen.fxml"));
        }
        else if(cargoType.getValue().equals(CargoType.PACKAGE)){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("orderFXMLs/PackageOrderDataScreen.fxml"));
        }
        else if(cargoType.getValue().equals(CargoType.PEOPLE)){
            ((Stage)select.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("orderFXMLs/PeopleOrderDataScreen.fxml"));
        }
    }

    @FXML
    public void getBack() throws Exception{
        ((Stage) back.getScene().getWindow()).setScene(controllersHelper.loadFXMLScreen("CustomerMainMenu.fxml"));
    }
}
