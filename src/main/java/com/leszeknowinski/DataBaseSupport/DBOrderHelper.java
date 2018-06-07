package com.leszeknowinski.DataBaseSupport;

import com.leszeknowinski.Cargo.CargoType;
import com.leszeknowinski.GPS.Location;
import com.leszeknowinski.Order.Order;
import com.leszeknowinski.User.CustomerType;
import com.leszeknowinski.Vehicle.VehicleType;
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
            preparedStatement.setString(1, String.valueOf(order.getCargoType()));
            preparedStatement.setInt(2, order.getCargoAmount());
            preparedStatement.setInt(3, order.getCustomerId());
            preparedStatement.setString(4, String.valueOf(order.getCustomerType()));
            preparedStatement.setString(5, order.getStartPoint());
            preparedStatement.setString(6, order.getEndPoint());
            preparedStatement.setDouble(7, order.getDistance());
            preparedStatement.setString(8, String.valueOf(order.getVehicleType()));
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
                order.setCargoType(CargoType.valueOf(resultSet.getString("cargoType")));
                order.setVehicleType(VehicleType.valueOf(resultSet.getString("vehicleType")));
                order.setVehicleId(resultSet.getInt("vehicleId"));
                order.setCargoAmount(resultSet.getInt("cargoAmount"));
                order.setCustomerId(resultSet.getInt("customerId"));
                order.setCustomerType(CustomerType.valueOf(resultSet.getString("customerType")));
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
