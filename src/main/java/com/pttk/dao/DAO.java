package com.pttk.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DAO {
    protected static Connection connection;

    static {
        String URL = "jdbc:mysql://localhost:3306/pttk";
        String USER = "root";
        String PASSWORD = "12345";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Database connected successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot connect to database: " + e.getMessage());
        }
    }

    protected Connection getConnection() throws SQLException {
        return connection;
    }
}
