package com.leszeknowinski.Vehicle;

import java.sql.*;
import java.util.ArrayList;

import static com.leszeknowinski.DataBaseSupport.DBHandler.connect;

public class VehicleRepository {
    static ArrayList<Car> vehiclesList = new ArrayList<Car>();



    public ArrayList<Car> getCars() {
        ResultSet resultSet = null;
        Statement statement = null;
        ArrayList<Car> carsList = new ArrayList<Car>();
        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM tvehicle WHERE vehicleType = 'car';");
            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setBrand(resultSet.getString("brand"));
                car.setModel(resultSet.getString("model"));
                car.setColour(resultSet.getString("colour"));
                car.setMileage(resultSet.getInt("mileage"));
                car.setEngineCapacity(resultSet.getInt("engineCapacity"));
                car.setFuelConsumption(resultSet.getDouble("fuelConsumption"));
                car.setVin(resultSet.getString("vin"));
                car.setRegistrationNumber(resultSet.getString("registrationNumber"));
                car.setVehicleType(VehicleType.valueOf(resultSet.getString("vehicleType")));
                carsList.add(car);
                vehiclesList.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carsList;
    }

    public Car getCar(int id) {
        ResultSet resultSet = null;
        Statement statement = null;
        Car car = new Car();
        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM tvehicle WHERE id = " + id + ";");
            while (resultSet.next()) {
                car.setId(resultSet.getInt("id"));
                car.setBrand(resultSet.getString("brand"));
                car.setModel(resultSet.getString("model"));
                car.setColour(resultSet.getString("colour"));
                car.setMileage(resultSet.getInt("mileage"));
                car.setEngineCapacity(resultSet.getInt("engineCapacity"));
                car.setFuelConsumption(resultSet.getDouble("fuelConsumption"));
                car.setVin(resultSet.getString("vin"));
                car.setRegistrationNumber(resultSet.getString("registrationNumber"));
                car.setVehicleType(VehicleType.valueOf(resultSet.getString("vehicleType")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }


    public ArrayList<Truck> getTrucks() {
        ResultSet resultSet = null;
        Statement statement = null;
        ArrayList<Truck> trucksList = new ArrayList<Truck>();
        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM tvehicle WHERE vehicleType = 'truck';");
            while (resultSet.next()) {
                Truck truck = new Truck();
                truck.setId(resultSet.getInt("id"));
                truck.setBrand(resultSet.getString("brand"));
                truck.setModel(resultSet.getString("model"));
                truck.setColour(resultSet.getString("colour"));
                truck.setMileage(resultSet.getInt("mileage"));
                truck.setEngineCapacity(resultSet.getInt("engineCapacity"));
                truck.setFuelConsumption(resultSet.getDouble("fuelConsumption"));
                truck.setVin(resultSet.getString("vin"));
                truck.setRegistrationNumber(resultSet.getString("registrationNumber"));
                truck.setVehicleType(VehicleType.valueOf(resultSet.getString("vehicleType")));
                trucksList.add(truck);
                vehiclesList.add(truck);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trucksList;
    }

    public ArrayList<Bus> getBuses() {
        ResultSet resultSet = null;
        Statement statement = null;
        ArrayList<Bus> busesList = new ArrayList<Bus>();
        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM tvehicle WHERE vehicleType = 'bus';");
            while (resultSet.next()) {
                Bus bus = new Bus();
                bus.setId(resultSet.getInt("id"));
                bus.setBrand(resultSet.getString("brand"));
                bus.setModel(resultSet.getString("model"));
                bus.setColour(resultSet.getString("colour"));
                bus.setMileage(resultSet.getInt("mileage"));
                bus.setEngineCapacity(resultSet.getInt("engineCapacity"));
                bus.setFuelConsumption(resultSet.getDouble("fuelConsumption"));
                bus.setVin(resultSet.getString("vin"));
                bus.setRegistrationNumber(resultSet.getString("registrationNumber"));
                bus.setPlaces(resultSet.getInt("places"));
                bus.setVehicleType(VehicleType.valueOf(resultSet.getString("vehicleType")));
                busesList.add(bus);
                vehiclesList.add(bus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return busesList;
    }

    public ArrayList<Motorcycle> getMotorcycles() {
        ResultSet resultSet = null;
        Statement statement = null;
        ArrayList<Motorcycle> motorcyclesList = new ArrayList<Motorcycle>();
        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM tvehicle WHERE vehicleType = 'motorcycle';");
            while (resultSet.next()) {
                Motorcycle motorcycle = new Motorcycle();
                motorcycle.setId(resultSet.getInt("id"));
                motorcycle.setBrand(resultSet.getString("brand"));
                motorcycle.setModel(resultSet.getString("model"));
                motorcycle.setColour(resultSet.getString("colour"));
                motorcycle.setMileage(resultSet.getInt("mileage"));
                motorcycle.setEngineCapacity(resultSet.getInt("engineCapacity"));
                motorcycle.setFuelConsumption(resultSet.getDouble("fuelConsumption"));
                motorcycle.setVin(resultSet.getString("vin"));
                motorcycle.setRegistrationNumber(resultSet.getString("registrationNumber"));
                motorcycle.setMaxPackageWeight(resultSet.getInt("maxPackageWeight"));
                motorcycle.setVehicleType(VehicleType.valueOf(resultSet.getString("vehicleType")));
                motorcyclesList.add(motorcycle);
                vehiclesList.add(motorcycle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return motorcyclesList;
    }

    public ArrayList<Van> getVans(){
        ResultSet resultSet = null;
        Statement statement = null;
        ArrayList<Van>vansList = new ArrayList<Van>();
        try{
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM tvehicle WHERE vehicleType = 'van';");
            while(resultSet.next()) {
                Van van = new Van();
                van.setId(resultSet.getInt("id"));
                van.setBrand(resultSet.getString("brand"));
                van.setModel(resultSet.getString("model"));
                van.setColour(resultSet.getString("colour"));
                van.setMileage(resultSet.getInt("mileage"));
                van.setEngineCapacity(resultSet.getInt("engineCapacity"));
                van.setFuelConsumption(resultSet.getDouble("fuelConsumption"));
                van.setVin(resultSet.getString("vin"));
                van.setRegistrationNumber(resultSet.getString("registrationNumber"));
                van.setMaxCargoHeight(resultSet.getInt("maxCargoHeight"));
                van.setMaxCargoLength(resultSet.getInt("maxCargoLength"));
                van.setMaxCargoWidth(resultSet.getInt("maxCargoWidth"));
                van.setMaxCargoWeight(resultSet.getInt("maxCargoWeight"));
                van.setVehicleType(VehicleType.valueOf(resultSet.getString("vehicleType")));
                vansList.add(van);
                vehiclesList.add(van);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return vansList;
    }

    public ArrayList<Car> getAllVehicles(){
        ResultSet resultSet = null;
        Statement statement = null;
        ArrayList<Car>vehiclesList = new ArrayList<Car>();
        try{
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM tvehicle");
            while(resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setBrand(resultSet.getString("brand"));
                car.setModel(resultSet.getString("model"));
                car.setColour(resultSet.getString("colour"));
                car.setMileage(resultSet.getInt("mileage"));
                car.setEngineCapacity(resultSet.getInt("engineCapacity"));
                car.setRegistrationNumber(resultSet.getString("registrationNumber"));
                car.setVehicleType(VehicleType.valueOf(resultSet.getString("vehicleType")));
                car.setInspectionDate(resultSet.getString("dateInspection"));
                vehiclesList.add(car);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return vehiclesList;
    }

    public Car getVehicle(int vehicleId){
        ResultSet resultSet = null;
        Statement statement = null;
        Car car = new Car();
        try{
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM tvehicle WHERE id = " + vehicleId + ";");
            while(resultSet.next()) {
                car.setId(resultSet.getInt("id"));
                car.setBrand(resultSet.getString("brand"));
                car.setModel(resultSet.getString("model"));
                car.setColour(resultSet.getString("colour"));
                car.setMileage(resultSet.getInt("mileage"));
                car.setEngineCapacity(resultSet.getInt("engineCapacity"));
                car.setRegistrationNumber(resultSet.getString("registrationNumber"));
                car.setVehicleType(VehicleType.valueOf(resultSet.getString("vehicleType")));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return car;
    }
    
    public ArrayList<Car> getAllArrestedVehicles(){
        ResultSet resultSet = null;
        Statement statement = null;
        ArrayList<Car>vehiclesList = new ArrayList<Car>();
        try{
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM tvehicle WHERE arrested = true;");
            while(resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setBrand(resultSet.getString("brand"));
                car.setModel(resultSet.getString("model"));
                car.setColour(resultSet.getString("colour"));
                car.setMileage(resultSet.getInt("mileage"));
                car.setEngineCapacity(resultSet.getInt("engineCapacity"));
                car.setRegistrationNumber(resultSet.getString("registrationNumber"));
                car.setVehicleType(VehicleType.valueOf(resultSet.getString("vehicleType")));
                vehiclesList.add(car);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return vehiclesList;
    }

    public ArrayList<Car> getAllFreeVehicles(){
        ResultSet resultSet = null;
        Statement statement = null;
        ArrayList<Car>vehiclesList = new ArrayList<Car>();
        try{
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM tvehicle WHERE arrested = false;");
            while(resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setBrand(resultSet.getString("brand"));
                car.setModel(resultSet.getString("model"));
                car.setColour(resultSet.getString("colour"));
                car.setMileage(resultSet.getInt("mileage"));
                car.setEngineCapacity(resultSet.getInt("engineCapacity"));
                car.setRegistrationNumber(resultSet.getString("registrationNumber"));
                car.setVehicleType(VehicleType.valueOf(resultSet.getString("vehicleType")));
                vehiclesList.add(car);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return vehiclesList;
    }
}
