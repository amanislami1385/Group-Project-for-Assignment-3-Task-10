package repositories;

import entities.Task;
import java.sql.*;

public class TaskRepository {
    private final Connection connection;

    public TaskRepository(Connection connection) {
        this.connection = connection;
    }

    public void save(Task task) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(
                "INSERT INTO tasks (title, status, deadline, project_id) VALUES (?, ?, ?, ?)"
        );
        stmt.setString(1, task.getTitle());
        stmt.setString(2, task.getStatus());
        stmt.setDate(3, task.getDeadline());
        stmt.setInt(4, task.getProjectId());
        stmt.executeUpdate();
    }

    public void updateStatus(int taskId, String newStatus) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(
                "UPDATE tasks SET status = ? WHERE id = ?"
        );
        stmt.setString(1, newStatus);
        stmt.setInt(2, taskId);
        stmt.executeUpdate();
    }
}
