package com.leszeknowinski.App;

import com.leszeknowinski.DataBaseSupport.DBHandler;
import com.leszeknowinski.User.EmployeeType;
import com.leszeknowinski.Vehicle.VehicleType;
import com.leszeknowinski.controllers.ControllersHelper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimePrinter;

import javax.naming.ldap.Control;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//username - Admin1 password - 123abc# Employee - admin
//driver - Jason Jason
//customer - Darcy Darcy
public class Main extends Application {
    public static void main(String[] args) {
        DBHandler.connect();
        launch(args);

    }

    //walidacja wpisywanych w TextFieldy wartości - ustaw na polach Handlery reagujące na przyciśnięcie submit!!
    //obsłużyć wyjątek jak jakiś username już istnieje w bazie

    //modify simple directions such as S, N, E and W - and some kind of factor which won't be still fixed on one Latitude
    //modify midpoints selection using distances between them - two loops probably
    //zmień GPS - http://www.mobility-services.in.tum.de/?p=2335
    //http://www.baeldung.com/java-dijkstra

        public void start (Stage primaryStage) throws Exception {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(this.getClass().getClassLoader().getResource("GPSTestsScreen.fxml"));
            Pane pane = fxmlLoader.load();
            Scene scene = new Scene(pane);
            primaryStage.setScene(scene);
            primaryStage.setTitle("TransportAndDeliverySystem");
            primaryStage.setResizable(true);
            primaryStage.show();
//  StartMenu.fxml  GPSTestsScreen.fxml
        }
    }