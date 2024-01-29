import java.util.List;

public class Programmer {
    private String name;
    private List<Task> tasks;
    private String city;

    public Programmer(String name, List<Task> tasks, String city) {
        this.name = name;
        this.tasks = tasks;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "name='" + name + '\'' +
                ", tasks=" + tasks +
                ", city='" + city + '\'' +
                "}";
    }

    public String getName() {
        return name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public String getCity() {
        return city;
    }
}
