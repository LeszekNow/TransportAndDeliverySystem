package com.leszeknowinski.App;

import com.leszeknowinski.DataBaseSupport.DBHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

//username - Admin1 password - 123abc# Employee - admin
//driver -
//customer - Darcy Darcy
public class Main extends Application {
    public static void main(String[] args) {
        DBHandler.connect();
        launch(args);

    }
    //full size ??
    //OrderEditingController - loading order details on textarea
    //program further option of customer start menu - services
    //pozmieniaj cośType na enumy
    //walidacja wpisywanych w TextFieldy wartości - ustaw na polach Handlery reagujące na przyciśnięcie submit!!

    //refactoring
    //obsłużyć wyjątek jak jakiś username już istnieje w bazie

    //add input hints/prompts in textfields
    //modify simple directions such as S, N, E and W - and some kind of factor which won't be still fixed on one Latitude
    //modify midpoints selection using distances between them - two loops probably
    //zmień GPS - http://www.mobility-services.in.tum.de/?p=2335

        public void start (Stage primaryStage) throws Exception {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(this.getClass().getClassLoader().getResource("StartMenu.fxml"));
            Pane pane = fxmlLoader.load();
            Scene scene = new Scene(pane);
            primaryStage.setScene(scene);
           // primaryStage.setFullScreen(true);
           // primaryStage.setMaximized(true);
            primaryStage.setTitle("TransportAndDeliverySystem");
            primaryStage.setResizable(true);
//            Screen screen = Screen.getPrimary();
//            Rectangle2D bounds = screen.getVisualBounds();
//            primaryStage.setX(bounds.getMinX());
//            primaryStage.setY(bounds.getMinY());
//            primaryStage.setWidth(bounds.getWidth());
//            primaryStage.setHeight(bounds.getHeight());
            primaryStage.show();
//  StartMenu.fxml  GPSTestsScreen.fxml
        }
    }