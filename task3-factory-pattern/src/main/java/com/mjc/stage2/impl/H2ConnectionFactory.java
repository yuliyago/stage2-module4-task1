package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {
    // Write your code here!
    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/test";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    @Override
    public Connection createConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            Properties properties = new Properties();
            properties.setProperty("user", USER);
            properties.setProperty("password", PASSWORD);
            return DriverManager.getConnection(DB_URL, properties);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

