package edu.aitu.oop3.entities;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private int id;
    private String name;
    private String description;

    private List<User> members;
    private List<Task> tasks;

    public Project() {
        this.members = new ArrayList<>(); // Initialize to avoid null errors
        this.tasks = new ArrayList<>();
    }

    public void setMembers(List<User> members) { this.members = members; }
    public List<User> getMembers() { return members; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<Task> getTasks() { return tasks; }
    public void setTasks(List<Task> tasks) { this.tasks = tasks; }
}
