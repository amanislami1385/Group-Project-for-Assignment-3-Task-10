import java.sql.Date;

public class Project {
    private int id;
    private String title;
    private String description;
    private Date deadline;
    private int userId;

    public Project(int id, String title, String description, Date deadline, int userId) {
        this.id = id; this.title = title; this.description = description;
        this.deadline = deadline; this.userId = userId;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public Date getDeadline() { return deadline; }
    public int getUserId() { return userId; }
}
