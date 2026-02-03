package edu.aitu.oop3.components.Task.entities;

public class ResearchTask extends Task {
    public ResearchTask(String title, String description, int priority) {
        super(title, description, priority);
        setType("RESEARCH");
    }
}
