package entities;

public class Comment {
    private int id;
    private String text;
    private int taskId;
    private int userId;

    public Comment(int id, String text, int taskId, int userId) {
        this.id = id; this.text = text; this.taskId = taskId; this.userId = userId;
    }

    public int getId() { return id; }
    public String getText() { return text; }
    public int getTaskId() { return taskId; }
    public int getUserId() { return userId; }
}