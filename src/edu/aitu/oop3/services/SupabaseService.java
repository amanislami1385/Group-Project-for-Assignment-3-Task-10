package edu.aitu.oop3.services;

public class SupabaseService {
    public void createUser(String email, String password) {
        System.out.println("User created successfully: " + email);
    }

    public void createProject(String projectName) {
        System.out.println("Project created successfully: " + projectName);
    }

    public void updateTaskStatus(int taskId, String status) {
        System.out.println("Task " + taskId + " status updated to: " + status);
    }

    public void addComment(int taskId, String comment) {
        System.out.println("Comment added to task " + taskId + ": " + comment);
    }
}