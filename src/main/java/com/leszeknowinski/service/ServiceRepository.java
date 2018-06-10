package com.leszeknowinski.service;


import com.leszeknowinski.Cargo.CargoType;
import com.leszeknowinski.Vehicle.Car;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.leszeknowinski.DataBaseSupport.DBHandler.connect;

public class ServiceRepository {

    public void showServices(ArrayList<Service>serviceList, TextArea textArea) {
        for (Service service : serviceList) {
            textArea.appendText(service.toString() + "\n");
        }
    }

    public void insertService(Service service) {
            String sqlInsert = "INSERT INTO tservice (category, description, price)" +
                    "VALUES (?, ?, ?);";
            try {
                PreparedStatement preparedStatement = connect.prepareStatement(sqlInsert);
                preparedStatement.setString(1, String.valueOf(service.getCategory()));
                preparedStatement.setString(2, service.getDescription());
                preparedStatement.setDouble(3, service.getPriceKM());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    public ArrayList<Service> getServices(){
        ResultSet resultSet = null;
        Statement statement = null;
        ArrayList<Service> serviceList = new ArrayList<Service>();
        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM tservice;");
            while (resultSet.next()) {
                Service service = new Service();
                service.setId(resultSet.getInt("id"));
                service.setCategory(CargoType.valueOf(resultSet.getString("category")));
                service.setDescription(resultSet.getString("description"));
                service.setPriceKM(resultSet.getDouble("price"));
                serviceList.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceList;
    }

}
