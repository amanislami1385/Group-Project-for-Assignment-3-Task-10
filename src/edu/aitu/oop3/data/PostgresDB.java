package edu.aitu.oop3.data;

import edu.aitu.oop3.data.IDB;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PostgresDB implements IDB {
    private static PostgresDB instance;
    private Connection connection;

    private String url;
    private String user;
    private String pass;

    private PostgresDB() {
        try {
            Properties props = new Properties();
            InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");

            if (input == null) {
                System.out.println("Error: config.properties file not found in src folder!");
                return;
            }

            props.load(input);
            this.url = props.getProperty("db.url");
            this.user = props.getProperty("db.user");
            this.pass = props.getProperty("db.password");

            Class.forName("org.postgresql.Driver");

        } catch (Exception e) {
            System.out.println("Error loading DB config: " + e.getMessage());
        }
    }

    public static synchronized PostgresDB getInstance() {
        if (instance == null) {
            instance = new PostgresDB();
        }
        return instance;
    }

    @Override
    public Connection getConnection() throws SQLException {

        if (connection == null || connection.isClosed()) {
            try {
                connection = DriverManager.getConnection(url, user, pass);
            } catch (SQLException e) {
                System.out.println("Connection Failed: " + e.getMessage());
                throw e;
            }
        }
        return connection;
    }
}