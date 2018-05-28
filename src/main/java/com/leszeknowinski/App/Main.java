package com.leszeknowinski.App;

import com.leszeknowinski.DataBaseSupport.DBHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

//username - Admin1 password - 123abc# Employee - admin
//customer - Darcy Darcy
public class Main extends Application {
    public static void main(String[] args) {
        DBHandler.connect();
        launch(args);

    }
    //change positions generation for only arrested cars
    //dojazd do klienta z krakowa do startpoint
    //wywal zbędne metody

    //full screen (height 1366/width 768px)
    //refactoring
    //add input hints/prompts in textfields
    //modify simple directions such as S, N, E and W - and some kind of factor which won't be still fixed on one Latitude
    //modify midpoints selection using distances between them - two loops probably
    //zmień GPS - http://www.mobility-services.in.tum.de/?p=2335
        //walidacja wpisywanych w TextFieldy wartości - ustaw na polach Handlery reagujące na przyciśnięcie submit!!
        //program further option of customer start menu - services, prices(mthod for calculation price in PLN/km)
        //program further option of customer main menu - edit, terms, delete account

        public void start (Stage primaryStage) throws Exception {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(this.getClass().getClassLoader().getResource("StartMenu.fxml"));
            Pane pane = fxmlLoader.load();
            Scene scene = new Scene(pane);
            primaryStage.setScene(scene);
            primaryStage.setFullScreen(true);
            primaryStage.setMaximized(true);
            primaryStage.setTitle("TransportAndDeliverySystem");
            primaryStage.setResizable(true);
            primaryStage.show();
//  StartMenu.fxml  GPSTestsScreen.fxml
        }
    }