package com.leszeknowinski.App;

import com.leszeknowinski.DataBaseSupport.DBUserHelper;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.leszeknowinski.DataBaseSupport.DBHandler.connect;

public class LogIn {


    public static boolean authenticate(String username, String password, String tableName) {
        try {
            String sqlGet = "SELECT password FROM t" + tableName + " WHERE username = '" + username + "';";
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlGet);
            while (resultSet.next()) {
                if (DigestUtils.md5Hex(password).equals(resultSet.getString("password"))) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}


