package edu.aitu.oop3.components.Project.controllers;

import edu.aitu.oop3.components.Project.entities.Project;
import edu.aitu.oop3.components.Project.services.ProjectService;

public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    public String createProject(Project project) {

        projectService.createProject(project.getName(), project.getDescription());

        return "Project creation request sent.";
    }
}