package edu.aitu.oop3;

import edu.aitu.oop3.data.PostgresDB;
import edu.aitu.oop3.data.IDB;
import edu.aitu.oop3.entities.Project;
import edu.aitu.oop3.entities.Task;
import edu.aitu.oop3.patterns.ProjectBuilder;
import edu.aitu.oop3.patterns.TaskFactory;
import edu.aitu.oop3.repositories.ProjectRepository;
import edu.aitu.oop3.util.TaskFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Task> taskPool = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        IDB db = PostgresDB.getInstance();
        ProjectRepository projectRepo = new ProjectRepository(db);

        System.out.println("[System] Connected to Database.");

        boolean running = true;
        while (running) {
            System.out.println("\n=== STUDENT TASK MANAGER MENU ===");
            System.out.println("1. Create Project ");
            System.out.println("2. Create Task ");
            System.out.println("3. Filter Tasks ");
            System.out.println("0. Exit");
            System.out.print("Select Option: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:

                    System.out.print("Enter Project Name: ");
                    String pName = scanner.nextLine();
                    System.out.print("Enter Description: ");
                    String pDesc = scanner.nextLine();

                    ProjectBuilder builder = new ProjectBuilder()
                            .setName(pName)
                            .setDescription(pDesc);

                    if (!taskPool.isEmpty()) {
                        for (Task t : taskPool) {
                            builder.addTask(t);
                        }
                        System.out.println("Attached " + taskPool.size() + " tasks to this project.");
                        taskPool.clear();
                    } else {

                        Task defaultTask = TaskFactory.createTask("FEATURE", "Initial Setup", "Auto-generated", 1);
                        builder.addTask(defaultTask);
                    }

                    Project p = builder.build();

                    if (projectRepo.save(p)) {
                        System.out.println("[Success] Project saved to Supabase with ID: " + p.getId());
                    } else {
                        System.out.println("[Error] Failed to save project.");
                    }
                    break;

                case 2:

                    System.out.print("Enter Type (BUG/FEATURE/RESEARCH): ");
                    String type = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Priority (1=Low, 2=Med, 3=High): ");

                    int priority = 1;
                    try {
                        priority = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number. Defaulting to 1.");
                    }

                    try {
                        Task t = TaskFactory.createTask(type, title, "User Created", priority);
                        taskPool.add(t);
                        System.out.println("Task Created: " + t);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:

                    System.out.print("Enter priority to filter by (e.g., 2): ");
                    int filterPrio = Integer.parseInt(scanner.nextLine());

                    TaskFilter<Task> filterTool = new TaskFilter<>();

                    List<Task> highPriority = filterTool.filter(taskPool, t -> t.getPriority() >= filterPrio);

                    System.out.println("Found " + highPriority.size() + " tasks:");
                    for (Task t : highPriority) {
                        System.out.println(t);
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}