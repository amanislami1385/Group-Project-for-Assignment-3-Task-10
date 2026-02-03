package edu.aitu.oop3.entities;

public class FeatureTask extends Task {
    public FeatureTask(String title, String description, int priority) {
        super(title, description, priority);
        setType("FEATURE");
    }
}
