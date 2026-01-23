package services;

import entities.Project;
import exceptions.PastDeadlineException;
import repositories.ProjectRepository;
import java.sql.Date;
import java.sql.SQLException;

public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void createProject(Project project) throws PastDeadlineException, SQLException {
        if (project.getDeadline().before(new Date(System.currentTimeMillis()))) {
            throw new PastDeadlineException("Project deadline cannot be in the past");
        }
        projectRepository.save(project);
    }
}