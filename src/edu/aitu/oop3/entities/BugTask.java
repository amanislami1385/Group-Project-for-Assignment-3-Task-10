package edu.aitu.oop3.entities;

public class BugTask extends Task {
    public BugTask(String title, String description, int priority) {
        super(title, description, priority);
        setType("BUG");
    }
}