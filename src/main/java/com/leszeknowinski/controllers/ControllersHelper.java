package com.leszeknowinski.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ControllersHelper {

    //Pane is the highest point on the ladder so is will be fit for every pane

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

    public static int intScanner(String parameterName) {
        int result = 0;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print(parameterName);
                result = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Improper value entered! You must use integers!");
                continue;
            }
            break;
        }
        return result;
    }

    public double doubleCheck(double input) {
        double result = 0;
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

}
