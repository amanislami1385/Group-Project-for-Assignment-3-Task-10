package Packageedu.aitu.oop3.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private DatabaseConnection() {}

    public static Connection getConnection() throws SQLException {
        String url = ConfigProperties.get("db.url");
        String user = ConfigProperties.get("db.user");
        String password = ConfigProperties.get("db.password");
        return DriverManager.getConnection(url, user, password);
    }
}