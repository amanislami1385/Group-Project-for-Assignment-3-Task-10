package edu.aitu.oop3.repositories;

import edu.aitu.oop3.data.IDB;
import edu.aitu.oop3.entities.Project;
import edu.aitu.oop3.entities.Task;
import java.sql.*;
import java.util.List;

public class ProjectRepository {
    private final IDB db;

    public ProjectRepository(IDB db) {
        this.db = db;
    }

    public boolean save(Project project) {
        Connection con = null;
        try {
            con = db.getConnection();

            String sql = "INSERT INTO projects(name, description) VALUES (?, ?) RETURNING id";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, project.getName());
            st.setString(2, project.getDescription());

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int projectId = rs.getInt("id");
                project.setId(projectId);

                saveTasks(projectId, project.getTasks(), con);
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error saving project: " + e.getMessage());
        } finally {
            try { if (con != null) con.close(); } catch (SQLException e) { }
        }
        return false;
    }


    private void saveTasks(int projectId, List<Task> tasks, Connection con) throws SQLException {
        if (tasks == null || tasks.isEmpty()) return;

        String sql = "INSERT INTO tasks(title, description, priority, type, project_id) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement st = con.prepareStatement(sql);

        for (Task task : tasks) {
            st.setString(1, task.getTitle());
            st.setString(2, task.getDescription());
            st.setInt(3, task.getPriority());
            st.setString(4, task.getType());
            st.setInt(5, projectId);
            st.addBatch();
        }
        st.executeBatch();
    }
}