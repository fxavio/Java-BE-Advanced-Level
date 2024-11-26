package org.javaadvancedlevel.lab2.designPatterns.singleto;

import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection dbConnection = DatabaseConnection.getInstance();
        Properties dbProperties = dbConnection.openConnection();
        System.out.println(dbConnection);
        String host = dbProperties.getProperty("db.host");
        String port = dbProperties.getProperty("db.port");
        String name = dbProperties.getProperty("db.name");
        String user = dbProperties.getProperty("db.user");
        System.out.println("Port: " + port + " Host: " + host + " Name: " + name + " User: " + user);

        // Close the database connection
        System.out.println(dbConnection.closeConnection());

    }
}
