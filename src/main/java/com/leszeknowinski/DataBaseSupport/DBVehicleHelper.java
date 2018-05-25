package com.leszeknowinski.DataBaseSupport;

import com.leszeknowinski.Vehicle.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;


import static com.leszeknowinski.DataBaseSupport.DBHandler.connect;

public class DBVehicleHelper {

    public static void insertCar(Car car) {
        String sqlInsert = "INSERT INTO tvehicle (brand, model, colour, mileage, engineCapacity, fuelConsumption, vin, registrationNumber, vehicleType, arrested)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connect.prepareStatement(sqlInsert);
            preparedStatement.setString(1, car.getBrand());
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setString(3, car.getColour());
            preparedStatement.setInt(4, car.getMileage());
            preparedStatement.setInt(5, car.getEngineCapacity());
            preparedStatement.setDouble(6, car.getFuelConsumption());
            preparedStatement.setString(7, car.getVin());
            preparedStatement.setString(8, car.getRegistrationNumber());
            preparedStatement.setString(9, car.getVehicleType());
            preparedStatement.setBoolean(10,false);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void insertTruck(Truck truck) {
        String sqlInsert = "INSERT INTO tvehicle (brand, model, colour, mileage, engineCapacity, fuelConsumption, vin, registrationNumber, vehicleType, arrested)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connect.prepareStatement(sqlInsert);
            preparedStatement.setString(1, truck.getBrand());
            preparedStatement.setString(2, truck.getModel());
            preparedStatement.setString(3, truck.getColour());
            preparedStatement.setInt(4, truck.getMileage());
            preparedStatement.setInt(5, truck.getEngineCapacity());
            preparedStatement.setDouble(6, truck.getFuelConsumption());
            preparedStatement.setString(7, truck.getVin());
            preparedStatement.setString(8, truck.getRegistrationNumber());
            preparedStatement.setString(9, truck.getVehicleType());
            preparedStatement.setBoolean(10,false);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public static void insertMotorcycle(Motorcycle motorcycle) {
        try {
            String sqlInsert = "INSERT INTO tvehicle (brand, model, colour, mileage, engineCapacity, fuelConsumption, vin, registrationNumber, maxPackageWeight, vehicleType, arrested)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = connect.prepareStatement(sqlInsert);
            preparedStatement.setString(1, motorcycle.getBrand());
            preparedStatement.setString(2, motorcycle.getModel());
            preparedStatement.setString(3, motorcycle.getColour());
            preparedStatement.setInt(4, motorcycle.getMileage());
            preparedStatement.setInt(5, motorcycle.getEngineCapacity());
            preparedStatement.setDouble(6, motorcycle.getFuelConsumption());
            preparedStatement.setString(7, motorcycle.getVin());
            preparedStatement.setString(8, motorcycle.getRegistrationNumber());
            preparedStatement.setInt(9, motorcycle.getMaxPackageWeight());
            preparedStatement.setString(10, motorcycle.getVehicleType());
            preparedStatement.setBoolean(11,false);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertVan(Van van){
            try {
                String sqlInsert = "INSERT INTO tvehicle (brand, model, colour, mileage, engineCapacity, fuelConsumption, vin, registrationNumber, maxCargoHeight, maxCargoLength, maxCargoWidth, maxCargoWeight, vehicleType, arrested)" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
                PreparedStatement preparedStatement = connect.prepareStatement(sqlInsert);
                preparedStatement.setString(1, van.getBrand());
                preparedStatement.setString(2, van.getModel());
                preparedStatement.setString(3, van.getColour());
                preparedStatement.setInt(4, van.getMileage());
                preparedStatement.setInt(5, van.getEngineCapacity());
                preparedStatement.setDouble(6, van.getFuelConsumption());
                preparedStatement.setString(7, van.getVin());
                preparedStatement.setString(8, van.getRegistrationNumber());
                preparedStatement.setInt(9, van.getMaxCargoHeight());
                preparedStatement.setInt(10, van.getMaxCargoLength());
                preparedStatement.setInt(11, van.getMaxCargoWidth());
                preparedStatement.setInt(12, van.getMaxCargoWeight());
                preparedStatement.setString(13, van.getVehicleType());
                preparedStatement.setBoolean(14,false);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    public static void insertBus(Bus bus){
        try {
            String sqlInsert = "INSERT INTO tvehicle (brand, model, colour, mileage, engineCapacity, fuelConsumption, vin, registrationNumber, places, vehicleType, arrested)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = connect.prepareStatement(sqlInsert);
            preparedStatement.setString(1, bus.getBrand());
            preparedStatement.setString(2, bus.getModel());
            preparedStatement.setString(3, bus.getColour());
            preparedStatement.setInt(4, bus.getMileage());
            preparedStatement.setInt(5, bus.getEngineCapacity());
            preparedStatement.setDouble(6, bus.getFuelConsumption());
            preparedStatement.setString(7, bus.getVin());
            preparedStatement.setString(8, bus.getRegistrationNumber());
            preparedStatement.setInt(9, bus.getPlaces());
            preparedStatement.setString(10, bus.getVehicleType());
            preparedStatement.setBoolean(11,false);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
