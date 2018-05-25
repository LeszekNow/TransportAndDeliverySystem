package com.leszeknowinski.Vehicle;

import com.leszeknowinski.DataBaseSupport.DBHandler;
import com.leszeknowinski.DataBaseSupport.DBUserHelper;
import com.leszeknowinski.DataBaseSupport.DBVehicleHelper;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VehicleHelper {

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

    public static double doubleScanner(String parameterName) {
        double result = 0;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print(parameterName);
                result = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print("Improper value entered! You have to enter number in: xx.xxx!");
                continue;
            }
            break;
        }
        return result;
    }

}
