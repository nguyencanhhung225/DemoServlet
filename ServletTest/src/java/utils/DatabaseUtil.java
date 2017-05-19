/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DatabaseUtil {

    public static Connection createConnection() {

        Connection conn = null;

        String url = "jdbc:mysql://localhost:3306/demo_hibernate";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DatabaseUtil.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            System.out.println("Connect Error !");
        }
        
        return conn;
    }

    public static void main(String[] args) {
        Connection conn = DatabaseUtil.createConnection();
        if (conn != null) {
            System.out.println("Connect Success !");
        }

    }
}
