package com.leszeknowinski.DataBaseSupport;

import java.sql.*;

public class DBHandler {

    public static Connection connect = null;

    public static void connect() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/transportationsystem?"
                            + "user=root&password=");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void connectToDataBase(String sqlAccess) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connect.prepareStatement(sqlAccess);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e2) {
            e2.printStackTrace();
        }
    }

    public int getSthIdFromDB(String sqlAccess) {
        ResultSet resultSet = null;
        Statement statement = null;
        int customerId = 0;
        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery(sqlAccess);
            while (resultSet.next()) {
                customerId = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException n) {
            n.printStackTrace();
        }

        return customerId;
    }

    public boolean getSthBooleanFromDB(String sqlAccess, String label) {
        ResultSet resultSet = null;
        Statement statement = null;
        boolean bool = false;
        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery(sqlAccess);
            while (resultSet.next()) {
                bool = resultSet.getBoolean(label);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException n) {
            n.printStackTrace();
        }

        return bool;
    }

    public String getStringFromDB(String sqlAccess, String string) {
        ResultSet resultSet = null;
        Statement statement = null;
        String stringInDB = "";
        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery(sqlAccess);
            while (resultSet.next()) {
                stringInDB = resultSet.getString(string);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException n) {
            n.printStackTrace();
        }

        return stringInDB;
    }

    public int getIntFromDB(String sqlAccess, String label) {
        ResultSet resultSet = null;
        Statement statement = null;
        int number = 0;
        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery(sqlAccess);
            while (resultSet.next()) {
                number = resultSet.getInt(label);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException n) {
            n.printStackTrace();
        }

        return number;
    }

    public double getDoubleFromDB(String sqlAccess, String label) {
        ResultSet resultSet = null;
        Statement statement = null;
        double number = 0;
        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery(sqlAccess);
            while (resultSet.next()) {
                number = resultSet.getDouble(label);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException n) {
            n.printStackTrace();
        }
        return number;
    }
}
