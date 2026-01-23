package services;

import entities.Task;
import exceptions.PastDeadlineException;
import exceptions.TaskWithoutProjectException;
import exceptions.InvalidStatusTransitionException;
import repositories.TaskRepository;

import java.sql.Date;
import java.sql.SQLException;

public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTask(Task task) throws PastDeadlineException, TaskWithoutProjectException, SQLException {
        if (task.getDeadline().before(new Date(System.currentTimeMillis()))) {
            throw new PastDeadlineException("Deadline cannot be in the past");
        }
        if (task.getProjectId() <= 0) {
            throw new TaskWithoutProjectException("Task must belong to a project");
        }
        taskRepository.save(task);
    }

    public void updateStatus(int taskId, String newStatus) throws InvalidStatusTransitionException, SQLException {
        if ("IN_PROGRESS".equals(newStatus)) {
            throw new InvalidStatusTransitionException("Cannot move back to IN_PROGRESS once DONE");
        }
        taskRepository.updateStatus(taskId, newStatus);
    }
}dd