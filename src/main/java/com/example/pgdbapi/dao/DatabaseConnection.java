package com.example.pgdbapi.dao;

import org.springframework.context.annotation.Configuration;

import java.sql.*;


@Configuration
public class DatabaseConnection {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5433/pgdb";

    //  Database credentials
    static final String USER = "postgres";
    static final String PASS = "1234";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
