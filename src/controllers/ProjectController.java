package controllers;

import entities.Project;
import services.ProjectService;

public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }


    public void createProject(Project project) {
        try {
            projectService.createProject(project);
            System.out.println("Project created successfully");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}