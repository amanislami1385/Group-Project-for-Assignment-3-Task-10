package entities;

import java.sql.Date;

public class Task {
    private int id;
    private String title;
    private String status;
    private Date deadline;
    private int projectId;

    public Task(int id, String title, String status, Date deadline, int projectId) {
        this.id = id; this.title = title; this.status = status;
        this.deadline = deadline; this.projectId = projectId;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getStatus() { return status; }
    public Date getDeadline() { return deadline; }
    public int getProjectId() { return projectId; }

    public void setStatus(String status) { this.status = status; }
d