package com.leszeknowinski.Order;

import com.leszeknowinski.Cargo.CargoType;
import com.leszeknowinski.User.CustomerType;
import com.leszeknowinski.Vehicle.Car;
import com.leszeknowinski.Vehicle.VehicleType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.leszeknowinski.DataBaseSupport.DBHandler.connect;

public class OrderRepository {

    public ArrayList<Order> getOrders(int customerId) {
        ResultSet resultSet = null;
        Statement statement = null;
        ArrayList<Order> ordersList = new ArrayList<Order>();
        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM torder WHERE customerId = " + customerId + ";");
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setCargoType(CargoType.valueOf(resultSet.getString("cargoType")));
                order.setVehicleId(resultSet.getInt("vehicleId"));
                order.setCustomerType(CustomerType.valueOf(resultSet.getString("customerType")));
                order.setCustomerId(resultSet.getInt("customerId"));
                order.setCargoAmount(resultSet.getInt("cargoAmount"));
                order.setStartPoint(resultSet.getString("startPoint"));
                order.setEndPoint(resultSet.getString("endPoint"));
                order.setDistance(resultSet.getDouble("distance"));
                order.setStartDate(resultSet.getDate("orderDate"));
                order.setCompleted(resultSet.getBoolean("completed"));
                order.setDriverId(resultSet.getInt("driverId"));
                order.setInProgress(resultSet.getBoolean("inProgress"));
                order.setVehicleType(VehicleType.valueOf(resultSet.getString("vehicleType")));
                ordersList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ordersList;
    }

    public ArrayList<Order> getDriverOrders(int driverId) {
        ResultSet resultSet = null;
        Statement statement = null;
        ArrayList<Order> ordersList = new ArrayList<Order>();
        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM torder WHERE driverId = " + driverId + ";");
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setCargoType(CargoType.valueOf(resultSet.getString("cargoType")));
                order.setVehicleId(resultSet.getInt("vehicleId"));
                order.setCustomerType(CustomerType.valueOf(resultSet.getString("customerType")));
                order.setCustomerId(resultSet.getInt("customerId"));
                order.setCargoAmount(resultSet.getInt("cargoAmount"));
                order.setStartPoint(resultSet.getString("startPoint"));
                order.setEndPoint(resultSet.getString("endPoint"));
                order.setDistance(resultSet.getDouble("distance"));
                order.setStartDate(resultSet.getDate("orderDate"));
                order.setCompleted(resultSet.getBoolean("completed"));
                order.setDriverId(resultSet.getInt("driverId"));
                order.setInProgress(resultSet.getBoolean("inProgress"));
                order.setVehicleType(VehicleType.valueOf(resultSet.getString("vehicleType")));
                ordersList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ordersList;
    }

    public ArrayList<Order> getAllOrders() {
        ResultSet resultSet = null;
        Statement statement = null;
        ArrayList<Order> ordersList = new ArrayList<Order>();
        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM torder;");
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setCargoType(CargoType.valueOf(resultSet.getString("cargoType")));
                order.setVehicleId(resultSet.getInt("vehicleId"));
                order.setCustomerType(CustomerType.valueOf(resultSet.getString("customerType")));
                order.setCustomerId(resultSet.getInt("customerId"));
                order.setCargoAmount(resultSet.getInt("cargoAmount"));
                order.setStartPoint(resultSet.getString("startPoint"));
                order.setEndPoint(resultSet.getString("endPoint"));
                order.setDistance(resultSet.getDouble("distance"));
                order.setStartDate(resultSet.getDate("orderDate"));
                order.setCompleted(resultSet.getBoolean("completed"));
                order.setDriverId(resultSet.getInt("driverId"));
                order.setInProgress(resultSet.getBoolean("inProgress"));
                order.setVehicleType(VehicleType.valueOf(resultSet.getString("vehicleType")));
                ordersList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ordersList;
    }
}
