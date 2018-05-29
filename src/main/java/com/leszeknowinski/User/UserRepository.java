package com.leszeknowinski.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static com.leszeknowinski.DataBaseSupport.DBHandler.connect;

public class UserRepository {

    public ArrayList<Driver> getDriver(){
        ResultSet resultSet = null;
        Statement statement = null;
        ArrayList<Driver>list = new ArrayList<Driver>();
        try{
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM tdriver;");
            while(resultSet.next()) {
                Driver driver = new Driver();
                driver.setId(resultSet.getInt("id"));
                driver.setName(resultSet.getString("name"));
                driver.setSurname(resultSet.getString("surname"));
                driver.setPesel(resultSet.getString("pesel"));
                driver.setPhone(resultSet.getString("phone"));
                driver.setUsername(resultSet.getString("username"));
                list.add(driver);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Manager> getManager(){
        ResultSet resultSet = null;
        Statement statement = null;
        ArrayList<Manager>list = new ArrayList<Manager>();
        try{
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM tmanager;");
            while(resultSet.next()) {
                Manager manager = new Manager();
                manager.setId(resultSet.getInt("id"));
                manager.setName(resultSet.getString("name"));
                manager.setSurname(resultSet.getString("surname"));
                manager.setPesel(resultSet.getString("pesel"));
                manager.setPhone(resultSet.getString("phone"));
                manager.setUsername(resultSet.getString("username"));
                list.add(manager);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Admin> getAdmin(){
        ResultSet resultSet = null;
        Statement statement = null;
        ArrayList<Admin>list = new ArrayList<Admin>();
        try{
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM tadmin;");
            while(resultSet.next()) {
                Admin admin = new Admin();
                admin.setId(resultSet.getInt("id"));
                admin.setName(resultSet.getString("name"));
                admin.setSurname(resultSet.getString("surname"));
                admin.setPesel(resultSet.getString("pesel"));
                admin.setPhone(resultSet.getString("phone"));
                admin.setUsername(resultSet.getString("username"));
                list.add(admin);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Customer> getCustomer(){
        ResultSet resultSet = null;
        Statement statement = null;
        ArrayList<Customer>list = new ArrayList<Customer>();
        try{
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM tclient WHERE customerType = 'customer';");
            while(resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setSurname(resultSet.getString("surname"));
                customer.setPesel(resultSet.getString("pesel"));
                customer.setPhone(resultSet.getString("phone"));
                customer.setUsername(resultSet.getString("username"));
                list.add(customer);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<CustomerB2B> getCustomerB2B(){
        ResultSet resultSet = null;
        Statement statement = null;
        ArrayList<CustomerB2B>list = new ArrayList<CustomerB2B>();
        try{
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM tclient WHERE customerType = 'customerb2b';");
            while(resultSet.next()) {
                CustomerB2B b2b = new CustomerB2B();
                b2b.setId(resultSet.getInt("id"));
                b2b.setCompany(resultSet.getString("company"));
                b2b.setNip(resultSet.getString("nip"));
                b2b.setPhone(resultSet.getString("phone"));
                b2b.setUsername(resultSet.getString("username"));
                list.add(b2b);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    //customer get method
    //customerb2b get method
    //show
    //delete
}
