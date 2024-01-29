public class Task {
    private int id;
    private static int idCounter = 1;
    private String title;
    private int days;
    private Status status;

    public Task(String title, int days, Status status) {
        this.id = idCounter++;
        this.title = title;
        this.days = days;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", days=" + days +
                ", status=" + status +
                "}";
    }

    public int getId() {
        return id;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public String getTitle() {
        return title;
    }

    public int getDays() {
        return days;
    }

    public Status getStatus() {
        return status;
    }
}
