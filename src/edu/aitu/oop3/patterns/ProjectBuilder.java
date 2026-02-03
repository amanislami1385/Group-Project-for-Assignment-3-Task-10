package edu.aitu.oop3.patterns;

import edu.aitu.oop3.entities.*;

import java.util.ArrayList;
import java.util.List;

public class ProjectBuilder {
    private String name;
    private String description;
    private List<User> members = new ArrayList<>();
    private List<Task> tasks = new ArrayList<>();

    public ProjectBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ProjectBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public ProjectBuilder addMember(User user) {
        this.members.add(user);
        return this;
    }

    public ProjectBuilder addTask(Task task) {
        this.tasks.add(task);
        return this;
    }

    public Project build() {
        Project project = new Project();
        project.setName(this.name);
        project.setDescription(this.description);
        project.setMembers(this.members);
        project.setTasks(this.tasks);
        return project;
    }
}
