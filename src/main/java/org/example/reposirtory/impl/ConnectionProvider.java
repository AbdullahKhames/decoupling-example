package org.example.reposirtory.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    private static final String url = "jdbc:mysql://localhost:3306/blogs";
    private static final String userName = "test";
    private static final String password = "";
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //
//            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            System.out.println("Driver loaded");

        } catch (ClassNotFoundException e/* | SQLException e*/) {
            System.out.println("Driver not found");
        }
    }

    public static Connection getCon() {
        try {
            System.out.println("Connecting to database");
            return DriverManager.getConnection(url, userName, password);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Error connecting to database");
        }
        return null;
    }
}
