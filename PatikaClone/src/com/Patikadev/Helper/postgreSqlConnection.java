package com.Patikadev.Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class postgreSqlConnection{

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/PatikaClone";
    private static final String DATABASE_USERNAME = "postgres";
    private static final String DATABASE_PASSWORD = "mustial38";

    public static Connection connectToDatabase(){
        try {
            return DriverManager.getConnection(JDBC_URL,DATABASE_USERNAME,DATABASE_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
