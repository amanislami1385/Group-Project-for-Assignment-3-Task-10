package Packageedu.aitu.oop3.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnection {
    private static final String URL =
            "jdbc:postgresql://aws-1-us-west-1.pooler.supabase.com";
    private static final String USER = "postgres.tguvrdybfojhwnnmkmjl";
    private static final String PASSWORD = "aman1385@1000$usa";// ← DATABASE PASSWORD
    private DatabaseConnection() {
        // no instances
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}