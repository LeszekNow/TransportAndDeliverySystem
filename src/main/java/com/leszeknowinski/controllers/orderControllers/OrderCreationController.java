package com.leszeknowinski.controllers.orderControllers;

import com.leszeknowinski.Cargo.CargoType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderCreationController implements Initializable {

    @FXML
    ChoiceBox<CargoType>cargoType;


    @FXML
    Button go;


    public void initialize(URL location, ResourceBundle resources) {
        loadChoices();
    }

    public void loadChoices(){
        cargoType.getItems().addAll(CargoType.CARGO, CargoType.PACKAGE, CargoType.PEOPLE);

    }
}
