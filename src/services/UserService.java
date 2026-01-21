import java.sql.Date;

public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTask(Task task) throws PastDeadlineException, TaskWithoutProjectException, SQLException {
        if (task.getDeadline().before(new Date(System.currentTimeMillis()))) {
            throw new PastDeadlineException("Deadline cannot be in the past");
        }
        if (task.getProjectId() <= 0) {
            throw new TaskWithoutProjectException("Task must belong to a project");
        }
        taskRepository.save(task);
    }

    public void updateStatus(int taskId, String newStatus) throws InvalidStatusTransitionException, SQLException {
        if (newStatus.equals("IN_PROGRESS")) {
            throw new InvalidStatusTransitionException("Cannot move back to IN_PROGRESS once DONE");
        }
        taskRepository.updateStatus(taskId, newStatus);
    }
}