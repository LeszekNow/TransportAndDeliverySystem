package com.leszeknowinski.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControllersHelper {

    public Scene loadFXMLScreen(String fileName)throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getClassLoader().getResource(fileName));
        Pane pane = fxmlLoader.load();
        Scene scene = new Scene(pane);
        return scene;
        }

    public Scene loadFXMLAnchorPaneScreen(String fileName)throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getClassLoader().getResource(fileName));
        AnchorPane anchorPane = fxmlLoader.load();
        Scene scene = new Scene(anchorPane);
        return scene;
    }


    public double doubleCheck(double input) {
        double result = 0.0;
        while (true) {
            try {
                result = input;
            } catch (InputMismatchException e) {
                continue;
            }
            break;
        }
        return result;
    }

    public double roundDouble(double input){
        double result = Math.round(input);
        return result;
    }

    public String transformDate(String dateStamp){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(dateStamp));
            dateStamp = sdf.format(c.getTime());
        }catch (ParseException e){
            e.printStackTrace();
        }
        return dateStamp;
    }

    public String incrementDateByYear(String dateStamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(dateStamp));
            c.add(Calendar.DATE, 372);  // number of days to add
            dateStamp = sdf.format(c.getTime());  // dt is now the new date
        }catch (ParseException e){
            e.printStackTrace();
        }
        return dateStamp;
    }

}
