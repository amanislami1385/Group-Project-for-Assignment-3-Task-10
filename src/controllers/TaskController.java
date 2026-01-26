package controllers;

import entities.Task;
import services.TaskService;

public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    public void createTask(Task task) {
        try {
            taskService.addTask(task);
            System.out.println("Task created successfully");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void changeTaskStatus(int taskId, String newStatus) {
        try {
            taskService.updateStatus(taskId, newStatus);
            System.out.println("Task status updated");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}