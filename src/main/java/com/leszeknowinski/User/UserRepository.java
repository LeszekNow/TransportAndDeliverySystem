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
            resultSet = statement.executeQuery("SELECT * FROM tclient WHERE customerType = 'CUSTOMER';");
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
            resultSet = statement.executeQuery("SELECT * FROM tclient WHERE customerType = 'CUSTOMERB2B';");
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

    public Driver getSingleDriver(int id){
        ResultSet resultSet = null;
        Statement statement = null;
        Driver driver = new Driver();
        try{
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM tdriver WHERE id = " + id + ";");
            while(resultSet.next()) {
                driver.setId(resultSet.getInt("id"));
                driver.setName(resultSet.getString("name"));
                driver.setSurname(resultSet.getString("surname"));
                driver.setPesel(resultSet.getString("pesel"));
                driver.setPhone(resultSet.getString("phone"));
                driver.setUsername(resultSet.getString("username"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return driver;
    }

    public Manager getSingleManager(int id){
        ResultSet resultSet = null;
        Statement statement = null;
        Manager manager = new Manager();
        try{
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM tmanager WHERE id = " + id + ";");
            while(resultSet.next()) {
                manager.setId(resultSet.getInt("id"));
                manager.setName(resultSet.getString("name"));
                manager.setSurname(resultSet.getString("surname"));
                manager.setPesel(resultSet.getString("pesel"));
                manager.setPhone(resultSet.getString("phone"));
                manager.setUsername(resultSet.getString("username"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return manager;
    }

    public Admin getSingleAdmin(int id){
        ResultSet resultSet = null;
        Statement statement = null;
        Admin admin = new Admin();
        try{
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM tadmin WHERE id = " + id + ";");
            while(resultSet.next()) {
                admin.setId(resultSet.getInt("id"));
                admin.setName(resultSet.getString("name"));
                admin.setSurname(resultSet.getString("surname"));
                admin.setPesel(resultSet.getString("pesel"));
                admin.setPhone(resultSet.getString("phone"));
                admin.setUsername(resultSet.getString("username"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return admin;
    }

    public Customer getSingleCustomer(int id){
        ResultSet resultSet = null;
        Statement statement = null;
        Customer customer = new Customer();
        try{
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM tclient WHERE id = " + id + ";");
            while(resultSet.next()) {
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setSurname(resultSet.getString("surname"));
                customer.setPesel(resultSet.getString("pesel"));
                customer.setPhone(resultSet.getString("phone"));
                customer.setUsername(resultSet.getString("username"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return customer;
    }

    public CustomerB2B getSingleCustomerB2B(int id){
        ResultSet resultSet = null;
        Statement statement = null;
        CustomerB2B b2b = new CustomerB2B();
        try{
            statement = connect.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM tclient WHERE id = " + id + ";");
            while(resultSet.next()) {
                b2b.setId(resultSet.getInt("id"));
                b2b.setCompany(resultSet.getString("company"));
                b2b.setNip(resultSet.getString("nip"));
                b2b.setPhone(resultSet.getString("phone"));
                b2b.setUsername(resultSet.getString("username"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return b2b;
    }
}
