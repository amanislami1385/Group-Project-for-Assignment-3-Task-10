package edu.aitu.oop3.controllers;

import edu.aitu.oop3.entities.Project;
import edu.aitu.oop3.services.ProjectService;

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