package com.leszeknowinski.DataBaseSupport;

import com.leszeknowinski.User.*;
import com.leszeknowinski.User.Driver;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.*;

import static com.leszeknowinski.DataBaseSupport.DBHandler.connect;

public class DBUserHelper {
    //Here I'll put some methods to

    public void insertAdmin(Admin admin) {
        try {
            String sqlInsert = "INSERT INTO tadmin (name, surname, pesel, phone, username, password)" +
                    "VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = connect.prepareStatement(sqlInsert);
            preparedStatement.setString(1, admin.getName());
            preparedStatement.setString(2, admin.getSurname());
            preparedStatement.setString(3, admin.getPesel());
            preparedStatement.setString(4, admin.getPhone());
            preparedStatement.setString(5, admin.getUsername());
            preparedStatement.setString(6, DigestUtils.md5Hex(admin.getPassword()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void insertManager(Manager manager) {
        try {
            String sqlInsert = "INSERT INTO tmanager (name, surname, pesel, phone, username, password)" +
                    "VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = connect.prepareStatement(sqlInsert);
            preparedStatement.setString(1, manager.getName());
            preparedStatement.setString(2, manager.getSurname());
            preparedStatement.setString(3, manager.getPesel());
            preparedStatement.setString(4, manager.getPhone());
            preparedStatement.setString(5, manager.getUsername());
            preparedStatement.setString(6, DigestUtils.md5Hex(manager.getPassword()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertCustomer(Customer customer) {
        try {
            String sqlInsert = "INSERT INTO tclient (name, surname, pesel, phone, username, password, customerType)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = connect.prepareStatement(sqlInsert);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getSurname());
            preparedStatement.setString(3, customer.getPesel());
            preparedStatement.setString(4, customer.getPhone());
            preparedStatement.setString(5, customer.getUsername());
            preparedStatement.setString(6, DigestUtils.md5Hex(customer.getPassword()));
            preparedStatement.setString(7, customer.getCustomerType());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertB2BCustomer(CustomerB2B customerB2B) {
        try {
            String sqlInsert = "INSERT INTO tclient (company, nip, phone, username, password, customerType)" +
                    "VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = connect.prepareStatement(sqlInsert);
            preparedStatement.setString(1, customerB2B.getCompany());
            preparedStatement.setString(2, customerB2B.getNip());
            preparedStatement.setString(3, customerB2B.getPhone());
            preparedStatement.setString(4, customerB2B.getUsername());
            preparedStatement.setString(5, DigestUtils.md5Hex(customerB2B.getPassword()));
            preparedStatement.setString(6, customerB2B.getCustomerType());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertDriver(Driver driver) {
        String sqlInsert = "INSERT INTO tdriver (name, surname, pesel, phone, username, password, drivingLicence, experience, arrested)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connect.prepareStatement(sqlInsert);
            preparedStatement.setString(1, driver.getName());
            preparedStatement.setString(2, driver.getSurname());
            preparedStatement.setString(3, driver.getPesel());
            preparedStatement.setString(4, driver.getPhone());
            preparedStatement.setString(5, driver.getUsername());
            preparedStatement.setString(6, DigestUtils.md5Hex(driver.getPassword()));
            preparedStatement.setString(7, driver.getDrivingLicence());
            preparedStatement.setInt(8, driver.getExperience());
            preparedStatement.setBoolean(9, driver.getArrested());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

}
