package edu.aitu.oop3.entities;

public abstract class Task {
    private int id;
    private String title;
    private String description;
    private int priority;
    private boolean completed;
    private String type;

    public Task(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.completed = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public int getPriority() { return priority; }
    public boolean isCompleted() { return completed; }
    public String getType() { return type; }

    public void setId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setPriority(int priority) { this.priority = priority; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    protected void setType(String type) { this.type = type; }

    @Override
    public String toString() {
        return "[" + type + "] " + title + " (Priority: " + priority + ")";
    }
}