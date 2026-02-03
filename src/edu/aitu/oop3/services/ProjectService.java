package edu.aitu.oop3.services;

import edu.aitu.oop3.entities.Project;
import edu.aitu.oop3.repositories.ProjectRepository;

public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void createProject(String name, String description) {
        Project project = new Project();
        project.setName(name);
        project.setDescription(description);

        if (projectRepository.save(project)) {
            System.out.println("[Service] Project created successfully.");
        } else {
            System.out.println("[Service] Failed to create project.");
        }
    }
}