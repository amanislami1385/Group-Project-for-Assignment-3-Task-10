import java.util.Scanner;

public class Main {
    static SupabaseService supabaseService = new SupabaseService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Connected to Supabase successfully!");

        do {
            printMenu();
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    supabaseService.createUser(email, password);
                    break;
                case 2:
                    System.out.print("Enter project name: ");
                    String projectName = scanner.nextLine();
                    supabaseService.createProject(projectName);
                    break;
                case 3:
                    System.out.print("Enter task ID: ");
                    int taskId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new status: ");
                    String status = scanner.nextLine();
                    supabaseService.updateTaskStatus(taskId, status);
                    break;
                case 4:
                    System.out.print("Enter task ID: ");
                    int commentTaskId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter comment: ");
                    String comment = scanner.nextLine();
                    supabaseService.addComment(commentTaskId, comment);
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n=== Main Menu ===");
        System.out.println("1. Create User");
        System.out.println("2. Create Project");
        System.out.println("3. Update Task Status");
        System.out.println("4. Add Comment");
        System.out.println("0. Exit");
    }
}