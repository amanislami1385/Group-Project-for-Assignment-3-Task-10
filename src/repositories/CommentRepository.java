package repositories;

import entities.Comment;
import java.sql.*;

public class CommentRepository {
    private final Connection connection;

    public CommentRepository(Connection connection) {
        this.connection = connection;
    }

    public void save(Comment comment) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(
                "INSERT INTO comments (text, task_id, user_id) VALUES (?, ?, ?)"
        );
        stmt.setString(1, comment.getText());
        stmt.setInt(2, comment.getTaskId());
        stmt.setInt(3, comment.getUserId());
        stmt.executeUpdate();
    }
}
