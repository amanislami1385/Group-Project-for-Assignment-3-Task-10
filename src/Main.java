import entities.User;
import entities.Project;
import entities.Task;
import entities.Comment;

import repositories.UserRepository;
import repositories.ProjectRepository;
import repositories.TaskRepository;
import repositories.CommentRepository;

import services.UserService;
import services.ProjectService;
import services.TaskService;
import services.CommentService;

import controllers.UserController;
import controllers.ProjectController;
import controllers.TaskController;
import controllers.CommentController;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {

            String url = "jdbc:postgresql://aws-1-us-west-1.pooler.supabase.com:5432/postgres?sslmode=require";
            String user = "postgres.tguvrdybfojhwnnmkmjl";
            String password = "aman1385@1000$usa";

            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to Supabase successfully!");

            UserRepository userRepo = new UserRepository(conn);
            ProjectRepository projectRepo = new ProjectRepository(conn);
            TaskRepository taskRepo = new TaskRepository(conn);
            CommentRepository commentRepo = new CommentRepository(conn);

            UserService userService = new UserService(userRepo);
            ProjectService projectService = new ProjectService(projectRepo);
            TaskService taskService = new TaskService(taskRepo);
            CommentService commentService = new CommentService(commentRepo);

            UserController userController = new UserController(userService);
            ProjectController projectController = new ProjectController(projectService);
            TaskController taskController = new TaskController(taskService);
            CommentController commentController = new CommentController(commentService);

            User newUser = new User(0, "Ahmad Rezai", "ahmadrezai06@example.com");
            userController.createUser(newUser);

            Project project = new Project(0, "Math Project", "Algebra homework",
                    Date.valueOf("2026-02-01"), 1);
            projectController.createProject(project);

            Task task = new Task(0, "Solve equations", "TODO",
                    Date.valueOf("2026-01-25"), 1);
            taskController.createTask(task);

            taskController.changeTaskStatus(1, "DONE");

            Comment comment = new Comment(0, "This task was tricky but done!", 1, 1);
            commentController.addComment(comment);

            conn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}ff