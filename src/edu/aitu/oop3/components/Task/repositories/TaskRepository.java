package edu.aitu.oop3.components.Task.repositories;

import edu.aitu.oop3.components.Task.entities.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository implements Repository<Task> {
    private List<Task> database = new ArrayList<>();

    @Override
    public void save(Task item) {
        database.add(item);
    }

    @Override
    public List<Task> findAll() {
        return database;
    }

    public Task findByIndex(int index) {
        if (index >= 0 && index < database.size()) {
            return database.get(index);
        }
        return null;
    }
}