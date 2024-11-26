package org.javaadvancedlevel.lab2.designPatterns.singleto;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConnection {
    private static DatabaseConnection instance;

    // Private constructor to prevent instantiation from outside
    private DatabaseConnection() {
        // Initialize the database connection here
    }

    // Static method to get the singleton instance
    public static DatabaseConnection getInstance() {
        // Lazy initialization: create the instance only if it's null
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
    public Properties openConnection() {
        Properties prop = new Properties();
        try {
            // Load the properties from config.properties file
            InputStream input = getClass().getClassLoader().getResourceAsStream("designPatterns/singleto/config.properties");
            if (input == null) {
                throw new FileNotFoundException("config.properties not found in the classpath");
            }
            prop.load(input);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public String closeConnection() {
        // Close the database connection
        return "Connection closed ";
    }
    @Override
    public String toString() {
        return "DatabaseConnection Singleton Instance";
    }
}