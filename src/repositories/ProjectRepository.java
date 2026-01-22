package repositories;

import entities.Project;
import java.sql.*;

public class ProjectRepository {
    private final Connection connection;

    public ProjectRepository(Connection connection) {
        this.connection = connection;
    }

    public void save(Project project) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(
                "INSERT INTO projects (title, description, deadline, user_id) VALUES (?, ?, ?, ?)"
        );
        stmt.setString(1, project.getTitle());
        stmt.setString(2, project.getDescription());
        stmt.setDate(3, project.getDeadline());
        stmt.setInt(4, project.getUserId());
        stmt.executeUpdate();
    }
} d