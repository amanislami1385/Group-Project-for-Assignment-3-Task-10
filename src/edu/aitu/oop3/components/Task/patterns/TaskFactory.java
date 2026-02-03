package edu.aitu.oop3.components.Task.patterns;

import edu.aitu.oop3.components.Task.entities.*;

public class TaskFactory {
    public static Task createTask(String type, String title, String description, int priority) {
        switch (type.toUpperCase()) {
            case "BUG":
                return new BugTask(title, description, priority);
            case "FEATURE":
                return new FeatureTask(title, description, priority);
            case "RESEARCH":
                return new ResearchTask(title, description, priority);
            default:
                throw new IllegalArgumentException("Unknown task type: " + type);
        }
    }
}
