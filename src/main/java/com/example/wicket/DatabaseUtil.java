package com.example.wicket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseUtil {
    private static Properties loadProperties() {
        Properties props = new Properties();
        try (var input = DatabaseUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                throw new RuntimeException("Unable to find db.properties");
            }
            props.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load database properties", e);
        }
        return props;
    }

    public static Connection getConnection() {
        Properties props = loadProperties();
        try {
        	System.out.println("this is inner dbutil class");
            Class.forName(props.getProperty("db.driver"));
            return DriverManager.getConnection(
                props.getProperty("db.url"),
                props.getProperty("db.username"),
                props.getProperty("db.password")
            );
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Database connection failed", e);
        }
    }
}
