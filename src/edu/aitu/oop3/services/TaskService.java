package edu.aitu.oop3.services;

import edu.aitu.oop3.entities.Task;
import edu.aitu.oop3.repositories.TaskRepository;
import java.util.List;
import java.util.stream.Collectors;

public class TaskService {
    private TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public void addTask(Task task) { repository.save(task); }

    public void updateStatus(int index, String newStatus) {
        Task task = repository.findByIndex(index);
        if (task != null) {
            task.setCompleted(newStatus.equalsIgnoreCase("DONE"));
        }
    }

    public List<Task> getHighPriorityTasks() {
        return repository.findAll().stream()
                .filter(t -> t.getPriority() >= 4) // Lambda Expression
                .collect(Collectors.toList());
    }

    public void sortTasksByPriority() {
        repository.findAll().sort((t1, t2) -> Integer.compare(t2.getPriority(), t1.getPriority()));
    }
}