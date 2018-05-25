package com.leszeknowinski.DataBaseSupport;

import com.leszeknowinski.Cargo.Cargo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.leszeknowinski.DataBaseSupport.DBHandler.connect;

public class DBCargoHelper {

    public void insertCargo(Cargo cargo){
    try {
        String sqlInsert = "INSERT INTO tcargo (cargoType, customerId, vehicleId, amount, cargoLength, cargoHeight, cargoWidth, cargoWeight)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement = connect.prepareStatement(sqlInsert);
        preparedStatement.setString(1, cargo.getCargoType());
        preparedStatement.setInt(2, cargo.getCustomerId());
        preparedStatement.setInt(3, cargo.getVehicleId());
        preparedStatement.setInt(4, cargo.getAmount());
        preparedStatement.setInt(5, cargo.getCargoLength());
        preparedStatement.setInt(6, cargo.getCargoHeight());
        preparedStatement.setInt(7, cargo.getCargoWidth());
        preparedStatement.setInt(8, cargo.getCargoWeight());
        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    public void insertPeopleCargo(Cargo cargo){
        try {
            String sqlInsert = "INSERT INTO tcargo (customerId, vehicleId, cargoType, amount)" +
                    "VALUES (?, ?, ?, ?);";
            PreparedStatement preparedStatement = connect.prepareStatement(sqlInsert);
            preparedStatement.setInt(1, cargo.getCustomerId());
            preparedStatement.setInt(2, cargo.getCustomerId());
            preparedStatement.setString(3, cargo.getCargoType());
            preparedStatement.setInt(4, cargo.getAmount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
