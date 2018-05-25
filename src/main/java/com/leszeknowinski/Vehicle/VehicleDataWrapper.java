package com.leszeknowinski.Vehicle;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VehicleDataWrapper {
    String brand;
    String model;
    String colour;
    int mileage;
    int engineCapacity;
    double fuelConsumption;
    String vin;
    String registrationNumber;
    String vehicleType;
    boolean arrested;


    private static VehicleDataWrapper readMainParameters() {
        Scanner scanner = new Scanner(System.in);
        VehicleDataWrapper vehicleDataWrapper = new VehicleDataWrapper();

        System.out.print(" Brand: ");
        vehicleDataWrapper.brand = scanner.nextLine();
        System.out.print(" Model: ");
        vehicleDataWrapper.model = scanner.nextLine();
        System.out.print(" Colour: ");
        vehicleDataWrapper.colour = scanner.nextLine();
        vehicleDataWrapper.mileage = ourScanner(" Mileage in km: ");
        System.out.println(" Engine Capacity in cm3: ");
        vehicleDataWrapper.engineCapacity = ourScanner(" Engine Capacity in cm3: ");
        vehicleDataWrapper.fuelConsumption = ourScanner(" Fuel consumption in L/100km: ");
        scanner.nextLine();
        System.out.println(" VIN number: ");
        vehicleDataWrapper.vin = scanner.nextLine();
        System.out.print(" Registration number: ");
        vehicleDataWrapper.registrationNumber = scanner.nextLine();
        System.out.println(" com.leszeknowinski.Vehicle type: ");
        vehicleDataWrapper.vehicleType = scanner.nextLine();

        return vehicleDataWrapper;
    }

    public static int ourScanner(String parameterName) {
        int result = 0;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print(parameterName + ": ");
                result = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Zjebało się!");
                continue;
            }
            break;
        }
        return result;
    }
}
