package edu.aitu.oop3.repositories;

import edu.aitu.oop3.entities.User;
import java.sql.*;

public class UserRepository {
    private final Connection connection;

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    public boolean existsByEmail(String email) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(
                "SELECT COUNT(*) FROM users WHERE email = ?"
        );
        stmt.setString(1, email);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        return rs.getInt(1) > 0;
    }

    public void save(User user) throws SQLException {
        if (!existsByEmail(user.getEmail())) {
            PreparedStatement stmt = connection.prepareStatement(
                    "INSERT INTO users (name, email) VALUES (?, ?)"
            );
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.executeUpdate();
        } else {
            System.out.println("User with email " + user.getEmail() + " already exists.");
        }
    }
}
