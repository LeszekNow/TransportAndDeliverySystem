package com.leszeknowinski.DataBaseSupport;

import com.leszeknowinski.GPS.Location;
import com.leszeknowinski.Order.Order;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.leszeknowinski.DataBaseSupport.DBHandler.connect;

public class DBOrderHelper {

    public void insertOrder(Order order){
        try {
            String sqlInsert = "INSERT INTO torder (cargoType, cargoAmount, customerId, customerType, startPoint, endPoint, distance, vehicleType, completed, vehicleId, inProgress, driverId)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = connect.prepareStatement(sqlInsert);
            preparedStatement.setString(1, order.getCargoType());
            preparedStatement.setInt(2, order.getCargoAmount());
            preparedStatement.setInt(3, order.getCustomerId());
            preparedStatement.setString(4, order.getCustomerType());
            preparedStatement.setString(5, order.getStartPoint());
            preparedStatement.setString(6, order.getEndPoint());
            preparedStatement.setDouble(7, order.getDistance());
            preparedStatement.setString(8, order.getVehicleType());
            preparedStatement.setBoolean(9, order.getCompleted());
            preparedStatement.setInt(10, order.getVehicleId());
            preparedStatement.setBoolean(11, order.getInProgress());
            preparedStatement.setInt(12, order.getDriverId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Order getOrder(int customerId) {
        ResultSet resultSet = null;
        Statement statement = null;
        Order order = new Order();
        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM torder WHERE customerId = " + customerId + ";");
            while (resultSet.next()) {
                order.setId(resultSet.getInt("id"));
                order.setCargoType(resultSet.getString("cargoType"));
                order.setVehicleType(resultSet.getString("vehicleType"));
                order.setVehicleId(resultSet.getInt("vehicleId"));
                order.setCargoAmount(resultSet.getInt("cargoAmount"));
                order.setCustomerId(resultSet.getInt("customerId"));
                order.setCustomerType(resultSet.getString("customerType"));
                order.setStartPoint(resultSet.getString("startPoint"));
                order.setEndPoint(resultSet.getString("endPoint"));
                order.setDistance(resultSet.getDouble("distance"));
                order.setStartDate(resultSet.getDate("orderDate"));
                order.setCompleted(resultSet.getBoolean("completed"));
                order.setInProgress(resultSet.getBoolean("inProgress"));
                order.setDriverId(resultSet.getInt("driverId"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }
    }
